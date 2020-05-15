package co.anbora.labs.localstores.data.local.manager

import co.anbora.labs.localstores.data.local.ILocalShopManager
import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import co.anbora.labs.localstores.domain.model.LocalShopBo
import co.anbora.labs.localstores.domain.model.LocationBo
import kotlinx.coroutines.flow.Flow

class LocalShopManagerImpl: ILocalShopManager {
    override fun getLocalShops(categoryId: String): Flow<List<LocalShopBo>> {
        TODO("Not yet implemented")
    }

    override fun getAllNearestShopsFrom(location: LocationBo): List<LocalShopBo> {
        TODO("Not yet implemented")
    }

    override fun saveLocalShops(response: List<LocalShopDTO>) {
        TODO("Not yet implemented")
    }
}