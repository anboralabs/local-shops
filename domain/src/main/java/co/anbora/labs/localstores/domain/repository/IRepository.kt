package co.anbora.labs.localstores.domain.repository

import co.anbora.labs.localstores.domain.result.Result
import co.anbora.labs.localstores.domain.model.impl.CategoryBo
import co.anbora.labs.localstores.domain.model.impl.LocalShopBo
import co.anbora.labs.localstores.domain.model.LocationBo
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getCategories(): Flow<Result<List<CategoryBo>>>

    fun getLocalShopsByCategory(categoryId: String): Flow<Result<List<LocalShopBo>>>

    fun getAllNearestShops(location: LocationBo): List<LocalShopBo>

}