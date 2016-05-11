package mobsoft.bme.hu.irodafoglalo.network

import dagger.Module
import dagger.Provides
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
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(NetworkConfig.ENDPOINT_ADDRESS).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideRoomsApi(retrofit: Retrofit): RoomsApi {
        return retrofit.create(RoomsApi::class.java)
    }
}
