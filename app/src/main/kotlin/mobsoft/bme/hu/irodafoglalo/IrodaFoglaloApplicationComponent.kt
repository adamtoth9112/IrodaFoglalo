package mobsoft.bme.hu.irodafoglalo

import dagger.Component
import mobsoft.bme.hu.irodafoglalo.interactor.InteractorModule
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor
import mobsoft.bme.hu.irodafoglalo.network.NetworkModule
import mobsoft.bme.hu.irodafoglalo.ui.UIModule
import mobsoft.bme.hu.irodafoglalo.ui.main.MainActivity
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsFragment
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsPresenter
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
@Singleton
@Component(modules = arrayOf(UIModule::class, NetworkModule::class, InteractorModule::class))
interface IrodaFoglaloApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(roomsFragment: RoomsFragment)

    fun inject(roomsInteractor: RoomsInteractor)

    fun inject(roomsPresenter: RoomsPresenter)
}