package mobsoft.bme.hu.irodafoglalo.model

import com.orm.SugarRecord

/**
 * Created by Adam Toth on 2016. 04. 20..
 */
class Room(val roomId: String,
           val description: String,
           val name: String) : SugarRecord<Room>() {

}
