package mobsoft.bme.hu.irodafoglalo.model

import com.github.salomonbrys.kotson.byBool
import com.github.salomonbrys.kotson.byString
import com.google.gson.JsonObject

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class Time(val obj: JsonObject) {
    val timeId: String by obj.byString
    val roomId: String by obj.byString
    val userId: String by obj.byString
    val description: String by obj.byString
    val state: Boolean by obj.byBool
}