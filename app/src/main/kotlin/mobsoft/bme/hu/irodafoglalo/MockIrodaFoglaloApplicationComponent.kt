package mobsoft.bme.hu.irodafoglalo

import dagger.Component
import mobsoft.bme.hu.irodafoglalo.interactor.InteractorModule
import mobsoft.bme.hu.irodafoglalo.model.mock.MockModelModule
import mobsoft.bme.hu.irodafoglalo.network.prod.MockNetworkModule
import mobsoft.bme.hu.irodafoglalo.ui.UIModule
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 05. 01..
 */
@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class, MockModelModule::class, MockNetworkModule::class))
interface MockIrodaFoglaloApplicationComponent : IrodaFoglaloApplicationComponent {
}