package mobsoft.bme.hu.irodafoglalo.ui.times

import mobsoft.bme.hu.irodafoglalo.model.Time

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
interface TimesScreen {
    fun showRoomDetails(times: List<Time>)

    fun showError(s: String)

    fun showProgress(b: Boolean)

}