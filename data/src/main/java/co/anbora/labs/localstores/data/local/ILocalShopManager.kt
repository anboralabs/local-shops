package co.anbora.labs.localstores.data.local

import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import co.anbora.labs.localstores.domain.model.LocalShopBo
import kotlinx.coroutines.flow.Flow

interface ILocalShopManager {

    fun getLocalShops(categoryId: String): Flow<List<LocalShopBo>>

    fun getAllLocalShops(): Flow<List<LocalShopBo>>

    fun saveLocalShops(response: List<LocalShopDTO>)

}