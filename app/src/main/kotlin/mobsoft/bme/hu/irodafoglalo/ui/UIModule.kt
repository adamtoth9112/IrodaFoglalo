package mobsoft.bme.hu.irodafoglalo.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import mobsoft.bme.hu.irodafoglalo.ui.main.MainPresenter
import mobsoft.bme.hu.irodafoglalo.ui.participants.ParticipantsPresenter
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsPresenter
import mobsoft.bme.hu.irodafoglalo.ui.times.TimesPresenter
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
@Module
class UIModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }

    @Provides
    @Singleton
    fun provideRoomsPresenter(): RoomsPresenter {
        return RoomsPresenter()
    }

    @Provides
    @Singleton
    fun provideTimesPresenter(): TimesPresenter {
        return TimesPresenter()
    }

    @Provides
    @Singleton
    fun provideParticipantsPresenter(): ParticipantsPresenter {
        return ParticipantsPresenter()
    }
}
