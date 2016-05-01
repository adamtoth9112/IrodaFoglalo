package mobsoft.bme.hu.irodafoglalo.model

import com.github.salomonbrys.kotson.byString
import com.google.gson.JsonObject
import com.orm.SugarRecord

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class Person(val obj: JsonObject) : SugarRecord<Person>() {
    val firstName: String by obj.byString("first_name")
    val lastName: String by obj.byString("last_name")
    val email: String by obj.byString
    val userId: String by obj.byString
}