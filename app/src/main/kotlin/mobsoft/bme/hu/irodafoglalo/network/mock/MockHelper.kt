package mobsoft.bme.hu.irodafoglalo.network.mock

import okhttp3.*
import okio.Buffer
import okio.BufferedSource
import okio.Okio
import java.io.ByteArrayInputStream
import java.io.IOException

/**
 * Created by Adam Toth on 2016. 05. 12..
 */
class MockHelper {

    companion object {}
}

fun MockHelper.Companion.makeResponse(request: Request?, headers: Headers?, code: Int, content: String): Response {

    return Response.Builder().protocol(Protocol.HTTP_2).code(code).request(request).headers(headers).body(object : ResponseBody() {
        override fun contentType(): MediaType {
            return MediaType.parse("application/json")
        }

        override fun contentLength(): Long {
            return content.toByteArray().size.toLong()
        }

        override fun source(): BufferedSource {
            return Okio.buffer(Okio.source(ByteArrayInputStream(content.toByteArray())))
        }
    }).build()
}

fun MockHelper.Companion.bodyToString(request: Request): String {

    try {
        val copy = request.newBuilder().build()
        val buffer = Buffer()
        copy.body().writeTo(buffer)
        return buffer.readUtf8()
    } catch (e: IOException) {
        return ""
    }

}