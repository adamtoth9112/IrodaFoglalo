package mobsoft.bme.hu.irodafoglalo.ui

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
abstract class Presenter<S> {

    protected var screen: S? = null

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen() {
        this.screen = null
    }
}