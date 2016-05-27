package mobsoft.bme.hu.irodafoglalo.ui.rooms

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
import mobsoft.bme.hu.irodafoglalo.model.Room
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RecyclerItemClickListener.OnItemClickListener
import mobsoft.bme.hu.irodafoglalo.ui.times.TimesFragment
import java.util.*
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsFragment : Fragment(), RoomsScreen {

    init {
        IrodaFoglaloApplication.injector?.inject(this)
    }

    @Inject
    lateinit var roomsPresenter: RoomsPresenter

    private var mProgressView: View? = null

    private var rvRooms: RecyclerView? = null

    private var roomsAdapter: RoomsAdapter? = null

    private val roomsList = ArrayList<Room>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater?.inflate(R.layout.fragment_rooms, container, false)

        mProgressView = fragmentView?.findViewById(R.id.login_progress)

        showProgress(true)
        roomsPresenter.getRooms()

        rvRooms = fragmentView?.findViewById(R.id.rvRooms) as RecyclerView
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvRooms?.layoutManager = llm

        roomsAdapter = RoomsAdapter(context, roomsList)
        rvRooms?.adapter = roomsAdapter

        rvRooms?.addOnItemTouchListener(RecyclerItemClickListener(context,
                object : OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {

                        val room = roomsAdapter?.getItem(position)

                        var time = TimesFragment()
                        val data = Bundle()
                        data.putString("roomId", room?.roomId)
                        time.arguments.putBundle("data", data)

                        (activity as RoomsActivity).addFragment(time)
                    }
                }))

        return fragmentView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        roomsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        roomsPresenter.detachScreen()
        super.onDetach()
    }

    override fun showRooms(rooms: List<Room>) {
        roomsList.clear()
        roomsList.addAll(rooms)
        roomsAdapter?.notifyDataSetChanged()
    }

    override fun showError(text: String) {

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
