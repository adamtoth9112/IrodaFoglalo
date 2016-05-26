package mobsoft.bme.hu.irodafoglalo.ui.participants

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.R
import mobsoft.bme.hu.irodafoglalo.model.Person
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RecyclerItemClickListener
import java.util.*
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class ParticipantsFragment : Fragment(), ParticipantsScreen {

    init {
        arguments = Bundle()
    }

    @Inject
    lateinit var participantsPresenter: ParticipantsPresenter

    private var mProgressView: View? = null

    private var rvParticipants: RecyclerView? = null

    private var participantsAdapter: ParticipantsAdapter? = null

    private val peopleList = ArrayList<Person>()

    private var roomId = ""

    private var userId: String = ""

    private var timeId: String = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater?.inflate(R.layout.fragment_participants, container, false)

        userId = arguments.getBundle("data").getString("userId")
        roomId = arguments.getBundle("data").getString("roomId")
        timeId = arguments.getBundle("data").getString("timeId")

        mProgressView = fragmentView?.findViewById(R.id.login_progress)

        showProgress(true)
        participantsPresenter.getParticipants(userId, roomId, timeId)

        rvParticipants = fragmentView?.findViewById(R.id.rvParticipants) as RecyclerView
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvParticipants?.layoutManager = llm

        participantsAdapter = ParticipantsAdapter(context, peopleList)
        rvParticipants?.adapter = participantsAdapter

        rvParticipants?.addOnItemTouchListener(RecyclerItemClickListener(context,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val person = participantsAdapter?.getItem(position)
                    }
                }))

        return fragmentView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        IrodaFoglaloApplication.injector?.inject(this)

        participantsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        participantsPresenter.detachScreen()
        super.onDetach()
    }

    override fun showError(text: String) {

    }

    override fun showParticipants(people: List<Person>) {
        peopleList.clear()
        peopleList.addAll(people)
        participantsAdapter?.notifyDataSetChanged()
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    override fun showProgress(show: Boolean) {

        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            mProgressView?.visibility = if (show) View.VISIBLE else View.GONE
            mProgressView?.animate()
                    ?.setDuration(shortAnimTime)
                    ?.alpha(if (show) 1f else .0f)
                    ?.setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            mProgressView?.visibility = if (show) View.VISIBLE else View.GONE
                        }
                    })
        } else {
            mProgressView?.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}