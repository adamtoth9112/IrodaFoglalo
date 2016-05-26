package mobsoft.bme.hu.irodafoglalo.network.prod

import okhttp3.OkHttpClient
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Created by Adam Toth on 2016. 05. 12..
 */
class UnsafeClientFactory {

    companion object
}

@Throws(KeyManagementException::class, NoSuchAlgorithmException::class)
fun UnsafeClientFactory.Companion.getUnsafeClient(): OkHttpClient.Builder {

    // Create a trust manager that does not validate certificate chains
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
        }

        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? {
            return null
        }
    })

    // Install the all-trusting trust manager
    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, java.security.SecureRandom())
    // Create an ssl socket factory with our all-trusting manager
    val sslSocketFactory = sslContext.socketFactory

    return OkHttpClient.Builder().sslSocketFactory(sslSocketFactory).hostnameVerifier { hostname, session -> true }

}