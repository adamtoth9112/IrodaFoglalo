package mobsoft.bme.hu.irodafoglalo.network.prod

import dagger.Module
import dagger.Provides
import mobsoft.bme.hu.irodafoglalo.network.RoomsApi
import mobsoft.bme.hu.irodafoglalo.network.mock.MockHttpServer
import mobsoft.bme.hu.irodafoglalo.network.mock.call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
@Module
class MockNetworkModule {

    private val networkModule = NetworkModule()

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        return networkModule.provideOkHttpClientBuilder()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        builder.interceptors().add(0, Interceptor { chain ->
            val request = chain.request()
            MockHttpServer.call(request)
        })
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return networkModule.provideRetrofit(client)
    }

    @Provides
    @Singleton
    fun provideRoomsApi(retrofit: Retrofit): RoomsApi {
        return retrofit.create(RoomsApi::class.java)
    }
}
