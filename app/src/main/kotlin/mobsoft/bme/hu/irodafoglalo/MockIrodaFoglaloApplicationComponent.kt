package mobsoft.bme.hu.irodafoglalo

import dagger.Component
import mobsoft.bme.hu.irodafoglalo.interactor.InteractorModule
import mobsoft.bme.hu.irodafoglalo.model.mock.MockModelModule
import mobsoft.bme.hu.irodafoglalo.network.NetworkModule
import mobsoft.bme.hu.irodafoglalo.ui.UIModule
import javax.inject.Singleton

/**
 * Created by Adam Toth on 2016. 05. 01..
 */
@Singleton
@Component(modules = arrayOf(UIModule::class, NetworkModule::class, InteractorModule::class, MockModelModule::class))
interface MockIrodaFoglaloApplicationComponent : IrodaFoglaloApplicationComponent {
}