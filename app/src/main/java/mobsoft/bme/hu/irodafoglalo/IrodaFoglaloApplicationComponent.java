package mobsoft.bme.hu.irodafoglalo;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.bme.hu.irodafoglalo.interactor.InteractorModule;
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor;
import mobsoft.bme.hu.irodafoglalo.network.NetworkModule;
import mobsoft.bme.hu.irodafoglalo.ui.UIModule;
import mobsoft.bme.hu.irodafoglalo.ui.main.MainActivity;
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsFragment;
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsPresenter;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,
        InteractorModule.class})
public interface IrodaFoglaloApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(RoomsFragment roomsFragment);

    void inject(RoomsInteractor roomsInteractor);

    void inject(RoomsPresenter roomsPresenter);
}

