package mobsoft.bme.hu.irodafoglalo.ui.rooms

import android.os.AsyncTask
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor
import mobsoft.bme.hu.irodafoglalo.model.Room
import mobsoft.bme.hu.irodafoglalo.ui.Presenter
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsPresenter : Presenter<RoomsScreen>() {

    @Inject
    lateinit var roomsInteractor: RoomsInteractor

    var getRoomTask: GetRoomsTask? = null

    override fun attachScreen(screen: RoomsScreen) {
        super.attachScreen(screen)
        IrodaFoglaloApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getRooms() {
        getRoomTask = GetRoomsTask()
        getRoomTask?.execute()
    }

    fun finish(rooms: List<Room>) {
        screen?.showRooms(rooms)
    }

    inner class GetRoomsTask : AsyncTask<Void, Void, List<Room>>() {

        override fun doInBackground(vararg params: Void): List<Room> {
            return roomsInteractor.getRooms()
        }

        override fun onPostExecute(rooms: List<Room>?) {
            getRoomTask = null

            if (rooms != null && rooms.size > 0) {
                finish(rooms)
            } else {
                screen?.showError("Nincsenek elérhető tárgyalók.")
            }

            screen?.showProgress(false)
        }

        override fun onCancelled() {
            getRoomTask = null
            screen?.showProgress(false)
        }
    }
}
