package mobsoft.bme.hu.irodafoglalo.ui.times

import android.os.AsyncTask
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor
import mobsoft.bme.hu.irodafoglalo.model.Time
import mobsoft.bme.hu.irodafoglalo.ui.Presenter
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class TimesPresenter : Presenter<TimesScreen>() {

    @Inject
    lateinit var roomsInteractor: RoomsInteractor

    var getRoomDetailsTask: GetRoomDetailsTask? = null

    override fun attachScreen(screen: TimesScreen) {
        super.attachScreen(screen)
        IrodaFoglaloApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getRoomDetails(roomId: String) {
        getRoomDetailsTask = GetRoomDetailsTask(roomId)
        getRoomDetailsTask?.execute()
    }

    fun finish(times: List<Time>) {
        screen?.showRoomDetails(times)
    }

    inner class GetRoomDetailsTask(var roomId: String) : AsyncTask<Void, Void, List<Time>>() {

        override fun doInBackground(vararg params: Void): List<Time> {
            return roomsInteractor.getRoomDetails(roomId)
        }

        override fun onPostExecute(times: List<Time>?) {
            getRoomDetailsTask = null

            if (times != null && times.size > 0) {
                finish(times)
            } else {
                screen?.showError("Nincsenek elérhető adatok.")
            }

            screen?.showProgress(false)
        }

        override fun onCancelled() {
            getRoomDetailsTask = null
            screen?.showProgress(false)
        }
    }
}