package mobsoft.bme.hu.irodafoglalo.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.bme.hu.irodafoglalo.di.Network;
import mobsoft.bme.hu.irodafoglalo.ui.main.MainPresenter;
import mobsoft.bme.hu.irodafoglalo.ui.rooms.RoomsPresenter;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public RoomsPresenter provideArtistsPresenter() {
        return new RoomsPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}

