package mobsoft.bme.hu.irodafoglalo.ui.rooms;

import android.app.Fragment;
import android.content.Context;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class RoomsFragment extends Fragment implements RoomsScreen {

    @Inject
    RoomsPresenter roomsPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        roomsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        roomsPresenter.detachScreen();
        super.onDetach();
    }
}
