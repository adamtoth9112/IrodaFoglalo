package mobsoft.bme.hu.irodafoglalo.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication;
import mobsoft.bme.hu.irodafoglalo.R;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IrodaFoglaloApplication.injector.inject(this);
    }
}
