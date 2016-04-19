package mobsoft.bme.hu.irodafoglalo.interactor.rooms;

import javax.inject.Inject;

import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication;
import mobsoft.bme.hu.irodafoglalo.network.RoomsApi;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class RoomsInteractor {

    @Inject
    RoomsApi roomsApi;

    public RoomsInteractor() {
        IrodaFoglaloApplication.injector.inject(this);
    }
}
