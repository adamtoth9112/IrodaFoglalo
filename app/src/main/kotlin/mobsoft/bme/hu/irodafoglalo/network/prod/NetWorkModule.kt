package mobsoft.bme.hu.irodafoglalo.network.prod

import dagger.Module
import dagger.Provides
import mobsoft.bme.hu.irodafoglalo.network.NetworkConfig
import mobsoft.bme.hu.irodafoglalo.network.RoomsApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        var clientBuilder: OkHttpClient.Builder? = null
        try {
            clientBuilder = UnsafeClientFactory.getUnsafeClient()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (clientBuilder == null) {
            throw RuntimeException("HttpClient cannot be initialized!")
        }

        return clientBuilder
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(NetworkConfig.ENDPOINT_ADDRESS).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideRoomsApi(retrofit: Retrofit): RoomsApi {
        return retrofit.create(RoomsApi::class.java)
    }
}
