package mobsoft.bme.hu.irodafoglalo.model

import com.github.salomonbrys.kotson.byInt
import com.github.salomonbrys.kotson.byString
import com.google.gson.JsonObject

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class Error(val obj: JsonObject) {
    val code: Int by obj.byInt
    val type: String by obj.byString
    val fields: String by obj.byString
}
