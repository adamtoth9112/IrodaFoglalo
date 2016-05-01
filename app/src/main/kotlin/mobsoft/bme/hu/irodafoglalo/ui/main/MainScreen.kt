package mobsoft.bme.hu.irodafoglalo.ui.main

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
interface MainScreen {
    fun resetErrors()

    fun setPasswordError(error: String)

    fun setEmailError(error: String)

    fun requestFocus(focusView: String)

    fun showProgress(show: Boolean)
}
