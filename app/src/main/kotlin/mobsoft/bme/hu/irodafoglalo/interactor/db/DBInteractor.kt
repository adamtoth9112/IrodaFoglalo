package mobsoft.bme.hu.irodafoglalo.interactor.db

import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.model.prod.DBModel
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 05. 01..
 */
class DBInteractor {

    @Inject
    lateinit var dbModel: DBModel

    init {
        IrodaFoglaloApplication.injector.inject(this)
    }
}