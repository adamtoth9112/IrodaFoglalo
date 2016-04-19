package mobsoft.bme.hu.irodafoglalo;

import android.app.Application;

import mobsoft.bme.hu.irodafoglalo.ui.UIModule;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class IrodaFoglaloApplication extends Application {

    public static IrodaFoglaloApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerIrodaFoglaloApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
