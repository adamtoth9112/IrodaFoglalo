package mobsoft.bme.hu.irodafoglalo.ui.rooms

import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.ui.Presenter

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsPresenter : Presenter<RoomsScreen>() {

    override fun attachScreen(screen: RoomsScreen) {
        super.attachScreen(screen)
        IrodaFoglaloApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }
}