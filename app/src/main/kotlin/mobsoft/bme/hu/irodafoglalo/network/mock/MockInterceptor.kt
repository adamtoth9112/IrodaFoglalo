package mobsoft.bme.hu.irodafoglalo.network.mock

import android.util.Log
import mobsoft.bme.hu.irodafoglalo.network.NetworkConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by Adam Toth on 2016. 05. 12..
 */
class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        return process(chain?.request())
    }

    fun process(request: Request?): Response? {

        val uri = request?.url().toString()

        Log.d("Test Http Client", "URL call: " + uri.toString())
        val headers = request?.headers()

        if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/login")) {
            return RoomsMock.process(request)
        } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/rooms")) {
            return RoomsMock.process(request)
        } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/addParticipant")) {
            return RoomsMock.process(request)
        } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/participants")) {
            return RoomsMock.process(request)
        } else if (uri.startsWith(NetworkConfig.ENDPOINT_ADDRESS + "/roomDetails")) {
            return RoomsMock.process(request)
        } else {
            return MockHelper.makeResponse(request, headers, 404, "Unknown")
        }
    }

}