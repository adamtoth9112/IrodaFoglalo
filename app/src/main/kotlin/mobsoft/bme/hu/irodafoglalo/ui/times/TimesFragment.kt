package mobsoft.bme.hu.irodafoglalo.ui.times

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
import mobsoft.bme.hu.irodafoglalo.model.Time
import mobsoft.bme.hu.irodafoglalo.ui.participants.ParticipantsFragment
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RecyclerItemClickListener
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsActivity
import java.util.*
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class TimesFragment() : Fragment(), TimesScreen {

    init {
        arguments = Bundle()
    }

    @Inject
    lateinit var timesPresenter: TimesPresenter

    private var mProgressView: View? = null

    private var rvTimes: RecyclerView? = null

    private var timesAdapter: TimesAdapter? = null

    private val timesList = ArrayList<Time>()

    private var roomId = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater?.inflate(R.layout.fragment_times, container, false)

        roomId = arguments.getBundle("data").getString("roomId")

        mProgressView = fragmentView?.findViewById(R.id.login_progress)

        showProgress(true)
        timesPresenter.getRoomDetails(roomId)

        rvTimes = fragmentView?.findViewById(R.id.rvTimes) as RecyclerView
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvTimes?.layoutManager = llm

        timesAdapter = TimesAdapter(context, timesList)
        rvTimes?.adapter = timesAdapter

        rvTimes?.addOnItemTouchListener(RecyclerItemClickListener(context,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val time = timesAdapter?.getItem(position)

                        throw UnsupportedOperationException()

                        var fr = ParticipantsFragment()
                        val data = Bundle()
                        data.putString("roomId", roomId)
                        data.putString("userId", "")
                        data.putString("timeId", time?.timeId)
                        fr.arguments.putBundle("data", data)

                        (activity as RoomsActivity).addFragment(fr)
                    }
                }))

        return fragmentView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        IrodaFoglaloApplication.injector?.inject(this)

        timesPresenter.attachScreen(this)
    }

    override fun onDetach() {
        timesPresenter.detachScreen()
        super.onDetach()
    }

    override fun showError(text: String) {

    }

    override fun showRoomDetails(times: List<Time>) {
        timesList.clear()
        timesList.addAll(times)
        timesAdapter?.notifyDataSetChanged()
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
