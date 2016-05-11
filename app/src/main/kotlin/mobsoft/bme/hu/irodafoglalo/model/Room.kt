package mobsoft.bme.hu.irodafoglalo.model

import com.github.salomonbrys.kotson.byString
import com.google.gson.JsonObject
import com.orm.SugarRecord

/**
 * Created by Adam Toth on 2016. 04. 20..
 */
class Room(val obj: JsonObject) : SugarRecord<Room>() {
    val roomId: String by obj.byString
    val description: String by obj.byString
    val name: String by obj.byString("display_name")
}
