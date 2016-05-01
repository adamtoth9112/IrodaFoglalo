package mobsoft.bme.hu.irodafoglalo;

import android.app.Application;

import mobsoft.bme.hu.irodafoglalo.ui.UIModule;

/**
 * Created by Adam Toth on 2016. 04. 20..
 */
public class IrodaFoglaloApplication extends Application {

    public static IrodaFoglaloApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.FLAVOR.equals("mock")) {
            injector = DaggerMockIrodaFoglaloApplicationComponent.builder().uIModule(new UIModule(this)).build();
        } else {
            injector = DaggerIrodaFoglaloApplicationComponent.builder().uIModule(new UIModule(this)).build();
        }
    }
}
