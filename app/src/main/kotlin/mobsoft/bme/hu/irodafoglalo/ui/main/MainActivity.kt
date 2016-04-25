package mobsoft.bme.hu.irodafoglalo.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
open class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        IrodaFoglaloApplication.injector?.inject(this)
    }
}
