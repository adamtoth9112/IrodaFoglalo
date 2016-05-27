package mobsoft.bme.hu.irodafoglalo.ui.rooms

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.analytics.HitBuilders
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.R

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mobsoft.bme.hu.irodafoglalo.R.layout.activity_rooms)

        val application = application as IrodaFoglaloApplication
        val mTracker = application.defaultTracker;

        mTracker.send(HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Logged in")
                .build())

        supportFragmentManager.beginTransaction().add(R.id.fragment, RoomsFragment()).commitAllowingStateLoss()
    }

    fun addFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).addToBackStack(fragment.toString()).commitAllowingStateLoss()
    }
}
