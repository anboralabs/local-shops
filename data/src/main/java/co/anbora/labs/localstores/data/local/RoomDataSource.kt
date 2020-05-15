package co.anbora.labs.localstores.data.local

import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import co.anbora.labs.localstores.domain.model.CategoryBo
import co.anbora.labs.localstores.domain.model.LocalShopBo
import co.anbora.labs.localstores.domain.model.LocationBo
import kotlinx.coroutines.flow.Flow

class RoomDataSource(
    private val categoryManager: ICategoryManager,
    private val localShopManager: ILocalShopManager
) {

    fun getCategories(): Flow<List<CategoryBo>> = categoryManager.getCategories()

    fun saveCategories(response: List<CategoryDTO>) = categoryManager.saveCategories(response)

    fun getLocalShops(categoryId: String): Flow<List<LocalShopBo>> = localShopManager.getLocalShops(categoryId)

    fun getAllNearestShopsFrom(location: LocationBo): List<LocalShopBo> = localShopManager.getAllNearestShopsFrom(location)

    fun saveLocalShops(response: List<LocalShopDTO>) = localShopManager.saveLocalShops(response)
}