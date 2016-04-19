package mobsoft.bme.hu.irodafoglalo.interactor;

/**
 * Created by mobsoft on 2016. 04. 18..
 */

import dagger.Module;
import dagger.Provides;
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor;

@Module
public class InteractorModule {

    @Provides
    public RoomsInteractor provideRoomInteractor() {
        return new RoomsInteractor();
    }
}