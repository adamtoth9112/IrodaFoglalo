package mobsoft.bme.hu.irodafoglalo.ui.main

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.R
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsActivity
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private var mEmailView: AutoCompleteTextView? = null

    private var mPasswordView: EditText? = null
    private var mProgressView: View? = null
    private var mLoginFormView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        IrodaFoglaloApplication.injector?.inject(this)

        mEmailView = findViewById(R.id.email) as AutoCompleteTextView

        mPasswordView = findViewById(R.id.password) as EditText

        val mEmailSignInButton = findViewById(R.id.email_sign_in_button) as Button
        mEmailSignInButton.setOnClickListener {
            mainPresenter.attemptLogin(mEmailView?.text.toString(), mPasswordView?.text.toString())
        }

        mLoginFormView = findViewById(R.id.login_form)
        mProgressView = findViewById(R.id.login_progress)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        mainPresenter.detachScreen()
        super.onStop()
    }

    override fun resetErrors() {
        mEmailView?.error = null;
        mPasswordView?.error = null;
    }

    override fun setPasswordError(error: String) {
        mPasswordView?.error = error;
    }

    override fun setEmailError(error: String) {
        mEmailView?.error = error
    }

    override fun requestFocus(focusView: String) {
        when (focusView) {
            "email" -> mEmailView?.requestFocus()
            "pw" -> mPasswordView?.requestFocus()
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    override fun showProgress(show: Boolean) {

        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            mLoginFormView?.visibility = if (show) View.GONE else View.VISIBLE
            mLoginFormView?.animate()
                    ?.setDuration(shortAnimTime)
                    ?.alpha(if (show) .0f else 1f)
                    ?.setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            mLoginFormView?.visibility = if (show) View.GONE else View.VISIBLE
                        }
                    })

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
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView?.visibility = if (show) View.VISIBLE else View.GONE
            mLoginFormView?.visibility = if (show) View.GONE else View.VISIBLE
        }
    }

    override fun showRooms() {
        val intent = Intent(this@MainActivity, RoomsActivity::class.java)
        startActivity(intent)
    }
}
