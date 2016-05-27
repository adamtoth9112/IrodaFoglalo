package mobsoft.bme.hu.irodafoglalo.network.mock

import mobsoft.bme.hu.irodafoglalo.model.Person
import mobsoft.bme.hu.irodafoglalo.model.Room
import mobsoft.bme.hu.irodafoglalo.model.Time
import mobsoft.bme.hu.irodafoglalo.network.GsonHelper
import mobsoft.bme.hu.irodafoglalo.network.NetworkConfig
import mobsoft.bme.hu.irodafoglalo.network.getGson
import okhttp3.Request
import okhttp3.Response
import java.util.*

/**
 * Created by Adam Toth on 2016. 05. 12..
 */
class RoomsMock {

    companion object {
        @JvmField var isInitialized = false
        @JvmField var rooms = ArrayList<Room>()
        @JvmField val testRoom1 = Room("410", "4. emeleti tárgyaló", "Zöld Tárgyaló")
        @JvmField val testRoom2 = Room("611", "5,5. emeleti tárgyaló", "Kék Tárgyaló")
        @JvmField var times = ArrayList<Time>()
        @JvmField var participants = ArrayList<Person>()
    }
}

fun RoomsMock.Companion.process(request: Request?): Response? {
    val uri = request?.url().toString()

    var responseString: String
    var responseCode: Int
    val headers = request?.headers()

    if (uri == NetworkConfig.ENDPOINT_ADDRESS + "/rooms" && request?.method() == "GET") {
        if (!RoomsMock.isInitialized) {
            rooms.add(testRoom1)
            rooms.add(testRoom2)
            RoomsMock.isInitialized = true
        }
        responseString = GsonHelper.getGson().toJson(rooms)
        responseCode = 200
    } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/login") && request?.method() == "POST") {
        responseString = ""
        responseCode = 200
    } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/roomDetails") && request?.method() == "GET") {
        val roomId = uri.substring(uri.lastIndexOf('=') + 1)

        if (times.size == 0) {
            initTimes()
        }

        val roomTimes = times.filter { t -> t.roomId.equals(roomId) }

        responseString = GsonHelper.getGson().toJson(roomTimes)
        responseCode = 200
    } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/addParticipant") && request?.method() == "POST") {

        responseString = ""
        responseCode = 200
    } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/participants") && request?.method() == "GET") {
        val roomId = uri.substring(uri.lastIndexOf("roomId=") + 6, uri.lastIndexOf("roomId=") + 6 + 4)
        val timeId = uri.substring(uri.lastIndexOf('=') + 1)

        if (participants.size == 0) {
            initParticipants()
        }

        val people = participants.filter { p -> p.roomId.equals(roomId) && p.timeId.equals(timeId) }

        responseString = GsonHelper.getGson().toJson(people)
        responseCode = 200
    } else {
        responseString = "ERROR"
        responseCode = 503
    }

    return MockHelper.makeResponse(request, headers, responseCode, responseString)
}

private fun initTimes() {
    RoomsMock.times.add(Time("1", "410", "", "2016.05.26.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.26.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.26.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.26.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.27.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.27.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.27.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.27.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.28.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.28.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.28.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.28.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.29.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.29.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.29.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "410", "", "2016.05.29.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.26.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.26.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.26.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.26.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.27.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.27.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.27.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.27.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.28.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.28.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.28.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.28.", "14:00-16:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.29.", "8:00-10:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.29.", "10:00-12:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.29.", "12:00-14:00", false))
    RoomsMock.times.add(Time("0", "611", "", "2016.05.29.", "14:00-16:00", false))
}

private fun initParticipants() {
    RoomsMock.participants.add(Person("asd@ext.asd.hu", "", "Asd", "Dsa", "", "410", "1"))
    RoomsMock.participants.add(Person("eerere@ext.asd.hu", "", "Eer", "Ere", "", "410", "1"))
}
