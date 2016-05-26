package mobsoft.bme.hu.irodafoglalo.ui.rooms

import mobsoft.bme.hu.irodafoglalo.model.Room

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
interface RoomsScreen {
    fun showProgress(show: Boolean)

    fun showRooms(rooms: List<Room>)

    fun showError(text: String)
}
