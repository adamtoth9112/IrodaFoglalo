package mobsoft.bme.hu.irodafoglalo.network.mock

import okhttp3.Request
import okhttp3.Response

/**
 * Created by Adam Toth on 2016. 05. 12..
 */
class MockHttpServer {

    companion object {}
}

fun MockHttpServer.Companion.call(request: Request?): Response? {
    val mockInterceptor = MockInterceptor()
    return mockInterceptor.process(request)
}