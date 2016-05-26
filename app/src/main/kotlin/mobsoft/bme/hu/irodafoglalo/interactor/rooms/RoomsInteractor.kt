package mobsoft.bme.hu.irodafoglalo.interactor.rooms

import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.model.Person
import mobsoft.bme.hu.irodafoglalo.model.Room
import mobsoft.bme.hu.irodafoglalo.model.Time
import mobsoft.bme.hu.irodafoglalo.network.RoomsApi
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsInteractor {

    @Inject
    lateinit var roomsApi: RoomsApi

    constructor() {
        IrodaFoglaloApplication.injector?.inject(this)
    }

    fun getRooms(): List<Room> {

        var response: Response<List<Room>>?
        val call = roomsApi.roomsGet()

        try {
            response = call.execute()
        } catch (e: Exception) {
            throw Exception("Network error on execute with get!")
        }

        if (response?.code() != 200) {
            throw Exception("Network error with get!")
        }

        return response.body()
    }

    fun login(email: String, password: String): Boolean {

        val person: Person = Person(email, password, "", "", "", "", "")
        var response: Response<Void>?
        val call = roomsApi.loginPost(person)

        try {
            response = call.execute()
        } catch (e: Exception) {
            throw Exception("Network error on execute with get!")
        }

        if (response?.code() != 200) {
            throw Exception("Network error with get!")
        }

        return true
    }

    fun getRoomDetails(roomId: String): List<Time> {

        val call = roomsApi.roomDetailsGet(roomId)
        var response: Response<List<Time>>?

        try {
            response = call.execute()
        } catch (e: Exception) {
            throw Exception("Network error on execute with get!")
        }

        if (response?.code() != 200) {
            throw Exception("Network error with get!")
        }

        return response.body()
    }

    fun getParticipants(userId: String, roomId: String, timeId: String): List<Person> {

        val call = roomsApi.participantsGet(userId, roomId, timeId)

        var response: Response<List<Person>>?

        try {
            response = call.execute()
        } catch (e: Exception) {
            throw Exception("Network error on execute with get!")
        }

        if (response?.code() != 200) {
            throw Exception("Network error with get!")
        }

        return response.body()
    }
}
