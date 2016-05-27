package mobsoft.bme.hu.irodafoglalo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.fabric.sdk.android.Fabric;
import mobsoft.bme.hu.irodafoglalo.ui.UIModule;

/**
 * Created by Adam Toth on 2016. 04. 20..
 */
public class IrodaFoglaloApplication extends Application {

    public static IrodaFoglaloApplicationComponent injector;

    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        if (BuildConfig.MOCK) {
            injector = DaggerMockIrodaFoglaloApplicationComponent.builder().uIModule(new UIModule(this)).build();
        } else {
            injector = DaggerIrodaFoglaloApplicationComponent.builder().uIModule(new UIModule(this)).build();
        }
    }

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
