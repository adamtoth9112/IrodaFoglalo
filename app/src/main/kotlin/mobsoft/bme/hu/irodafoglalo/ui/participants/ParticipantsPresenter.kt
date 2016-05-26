package mobsoft.bme.hu.irodafoglalo.ui.participants

import android.os.AsyncTask
import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.interactor.rooms.RoomsInteractor
import mobsoft.bme.hu.irodafoglalo.model.Person
import mobsoft.bme.hu.irodafoglalo.ui.Presenter
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class ParticipantsPresenter : Presenter<ParticipantsScreen>() {

    @Inject
    lateinit var roomsInteractor: RoomsInteractor

    var getParticipantsTask: GetParticipantsTask? = null

    override fun attachScreen(screen: ParticipantsScreen) {
        super.attachScreen(screen)
        IrodaFoglaloApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getParticipants(userId: String, roomId: String, timeId: String) {
        getParticipantsTask = GetParticipantsTask(userId, roomId, timeId)
        getParticipantsTask?.execute()
    }

    fun finish(people: List<Person>) {
        screen?.showParticipants(people)
    }

    inner class GetParticipantsTask(var userId: String, var roomId: String, var timeId: String) : AsyncTask<Void, Void, List<Person>>() {

        override fun doInBackground(vararg params: Void): List<Person> {
            return roomsInteractor.getParticipants(userId, roomId, timeId)
        }

        override fun onPostExecute(people: List<Person>?) {
            getParticipantsTask = null

            if (people != null && people.size > 0) {
                finish(people)
            } else {
                screen?.showError("Nincsenek elérhető adatok.")
            }

            screen?.showProgress(false)
        }

        override fun onCancelled() {
            getParticipantsTask = null
            screen?.showProgress(false)
        }
    }
}