package mobsoft.bme.hu.irodafoglalo.model

import com.orm.SugarRecord

/**
 * Created by Adam Toth on 2016. 04. 27..
 */
class Person(val email: String,
             val password: String,
             val firstName: String,
             val lastName: String,
             val userId: String,
             val roomId: String,
             val timeId: String) : SugarRecord<Person>() {
}