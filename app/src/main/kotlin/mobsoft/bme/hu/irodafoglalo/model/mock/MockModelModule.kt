package mobsoft.bme.hu.irodafoglalo.model.mock

import dagger.Module
import dagger.Provides
import mobsoft.bme.hu.irodafoglalo.model.prod.DBModel
import mobsoft.bme.hu.irodafoglalo.model.prod.MockDBModel

/**
 * Created by Adam Toth on 2016. 05. 01..
 */
@Module
class MockModelModule {

    @Provides
    fun provideMockDBModel(): DBModel {
        return MockDBModel()
    }
}