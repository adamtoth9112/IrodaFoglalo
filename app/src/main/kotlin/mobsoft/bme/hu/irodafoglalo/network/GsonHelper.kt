package mobsoft.bme.hu.irodafoglalo.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Created by Adam Toth on 2016. 05. 12..
 */
class GsonHelper {

    companion object {
        val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        @JvmField var gson = GsonBuilder().setDateFormat(DATE_FORMAT).create()
    }

}

fun GsonHelper.Companion.getGson(): Gson {
    return gson
}
