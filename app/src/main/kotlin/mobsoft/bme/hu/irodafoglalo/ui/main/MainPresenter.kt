package mobsoft.bme.hu.irodafoglalo.ui.main

import android.os.AsyncTask
import android.text.TextUtils
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor
import mobsoft.bme.hu.irodafoglalo.ui.Presenter
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class MainPresenter : Presenter<MainScreen>() {

    @Inject
    lateinit var roomsInteractor: RoomsInteractor

    private var mAuthTask: UserLoginTask? = null

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        IrodaFoglaloApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun attemptLogin(email: String, password: String) {
        // Reset errors.
        screen?.resetErrors()

        var cancel: Boolean = false
        var focusView: String = ""

        // Check for a valid password, if the user entered one.

        if (TextUtils.isEmpty(password)) {
            screen?.setPasswordError("Password required")
            cancel = true
            focusView = "pw"
        }
        if (!isPasswordValid(password)) {
            screen?.setPasswordError("Invalid Password")
            cancel = true
            focusView = "pw"
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            screen?.setEmailError("Email required")
            cancel = true
            focusView = "email"
        } else if (!isEmailValid(email)) {
            screen?.setEmailError("Invalid email")
            cancel = true
            focusView = "email"
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            screen?.requestFocus(focusView)
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            screen?.showProgress(true)
            mAuthTask = UserLoginTask(email, password)
            mAuthTask?.execute()
        }
    }

    private fun finish() {
        screen?.showRooms()
    }

    private fun isEmailValid(email: String): Boolean {
        return true
    }

    private fun isPasswordValid(password: String): Boolean {
        return true
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    inner class UserLoginTask internal constructor(private val email: String, private val password: String) : AsyncTask<Void, Void, Boolean>() {

        override fun doInBackground(vararg params: Void): Boolean? {
            return roomsInteractor.login(email, password)
        }

        override fun onPostExecute(success: Boolean?) {
            mAuthTask = null
            screen?.showProgress(false)

            if (success!!) {
                finish()
            } else {
                screen?.setPasswordError("Invalid Password")
            }
        }

        override fun onCancelled() {
            mAuthTask = null
            screen?.showProgress(false)
        }
    }
}
