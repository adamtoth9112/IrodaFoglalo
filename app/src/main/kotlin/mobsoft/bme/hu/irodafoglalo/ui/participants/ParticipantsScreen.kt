package mobsoft.bme.hu.irodafoglalo.ui.participants

import mobsoft.bme.hu.irodafoglalo.model.Person

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
interface ParticipantsScreen {
    fun showParticipants(people: List<Person>)

    fun showError(s: String)

    fun showProgress(b: Boolean)
}