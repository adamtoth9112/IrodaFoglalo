package mobsoft.bme.hu.irodafoglalo.network

import mobsoft.bme.hu.irodafoglalo.model.Person
import mobsoft.bme.hu.irodafoglalo.model.Room
import mobsoft.bme.hu.irodafoglalo.model.Time
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Adam Toth on 2016. 04. 20..
 */
interface RoomsApi {

    /**
     * Add new person
     *
     * @param person
     * @return Call<Void>
     */

    @POST("addParticipant")
    fun addParticipantPost(
            @Body person: Person
    ): Call<Void>


    /**
     * Get known persons
     *
     * @param userId
     * @param roomId
     * @return Call<List<Person>>
     */

    @GET("participants")
    fun participantsGet(
            @Query("userId") userId: String,
            @Query("roomId") roomId: String,
            @Query("timeId") timeId: String
    ): Call<List<Person>>


    /**
     * Get Room details
     *
     * @param roomId
     * @return Call<List<Time>>
     */

    @GET("roomDetails")
    fun roomDetailsGet(
            @Query("roomId") roomId: String
    ): Call<List<Time>>


    /**
     * Get Rooms
     *
     * @return Call<List<Room>>
     */

    @GET("rooms")
    fun roomsGet(): Call<List<Room>>


    /**
     * Login
     *
     * @param person
     * @return Call<Void>
     */

    @POST("login")
    fun loginPost(
            @Body person: Person
    ): Call<Void>

}
