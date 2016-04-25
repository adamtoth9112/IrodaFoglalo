package mobsoft.bme.hu.irodafoglalo.interactor.rooms

import mobsoft.bme.hu.irodafoglalo.IrodaFoglaloApplication
import mobsoft.bme.hu.irodafoglalo.network.RoomsApi
import javax.inject.Inject

/**
 * Created by Adam Toth on 2016. 04. 19..
 */
class RoomsInteractor {

    @Inject
    lateinit var roomsApi: RoomsApi

    constructor() {
        IrodaFoglaloApplication.injector?.inject(this)
    }
}