package mobsoft.bme.hu.irodafoglalo.interactor

import dagger.Module
import dagger.Provides
import mobsoft.bme.hu.irodafoglalo.interactor.db.DBInteractor
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
@Module
class InteractorModule {

    @Provides
    fun provideRoomsInteractor(): RoomsInteractor {
        return RoomsInteractor()
    }

    @Provides
    fun provideDBInteractor(): DBInteractor {
        return DBInteractor()
    }
}
