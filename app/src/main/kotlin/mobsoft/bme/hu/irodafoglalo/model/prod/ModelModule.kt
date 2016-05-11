package mobsoft.bme.hu.irodafoglalo.model.prod

import dagger.Module
import dagger.Provides

/**
 * Created by Adam Toth on 2016. 05. 01..
 */
@Module
class ModelModule {

    @Provides
    fun provideDBModel(): DBModel {
        return DBModel()
    }
}