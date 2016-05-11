package mobsoft.bme.hu.irodafoglalo.ui.rooms

import android.app.Fragment
import android.content.Context
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsFragment : Fragment, RoomsScreen {

    @Inject
    lateinit var roomsPresenter: RoomsPresenter

    constructor() : super() {
        IrodaFoglaloApplication.injector?.inject(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        roomsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        roomsPresenter.detachScreen()
        super.onDetach()
    }
}
