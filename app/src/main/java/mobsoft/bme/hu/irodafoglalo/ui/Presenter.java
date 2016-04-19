package mobsoft.bme.hu.irodafoglalo.ui;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
