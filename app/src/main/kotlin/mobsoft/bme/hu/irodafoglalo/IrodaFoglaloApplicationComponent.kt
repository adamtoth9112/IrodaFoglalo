package mobsoft.bme.hu.irodafoglalo

import dagger.Component
import mobsoft.bme.hu.irodafoglalo.interactor.InteractorModule
import mobsoft.bme.hu.irodafoglalo.interactor.db.DBInteractor
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor
import mobsoft.bme.hu.irodafoglalo.model.prod.ModelModule
import mobsoft.bme.hu.irodafoglalo.network.prod.NetworkModule
import mobsoft.bme.hu.irodafoglalo.ui.UIModule
import mobsoft.bme.hu.irodafoglalo.ui.main.MainActivity
import mobsoft.bme.hu.irodafoglalo.ui.main.MainPresenter
import mobsoft.bme.hu.irodafoglalo.ui.participants.ParticipantsFragment
import mobsoft.bme.hu.irodafoglalo.ui.participants.ParticipantsPresenter
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsFragment
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsPresenter
import mobsoft.bme.hu.irodafoglalo.ui.times.TimesFragment
import mobsoft.bme.hu.irodafoglalo.ui.times.TimesPresenter
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class, ModelModule::class, NetworkModule::class))
interface IrodaFoglaloApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(roomsFragment: RoomsFragment)

    fun inject(roomsPresenter: RoomsPresenter)

    fun inject(roomsInteractor: RoomsInteractor)

    fun inject(timesFragment: TimesFragment)

    fun inject(timesPresenter: TimesPresenter)

    fun inject(participantsFragment: ParticipantsFragment)

    fun inject(participantsPresenter: ParticipantsPresenter)

    fun inject(dbInteractor: DBInteractor)
}
