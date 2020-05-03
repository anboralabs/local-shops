package co.anbora.labs.localstores.data.repository

import co.anbora.labs.localstores.data.local.ICategoryManager
import co.anbora.labs.localstores.data.local.ILocalShopManager
import co.anbora.labs.localstores.data.remote.api.LocalShopsService
import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import co.anbora.labs.localstores.domain.model.CategoryBo
import co.anbora.labs.localstores.domain.model.LocalShopBo
import co.anbora.labs.localstores.domain.repository.IRepository
import co.anbora.labs.localstores.domain.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

@ExperimentalCoroutinesApi
class LocalStoresRepository(
    private val categoryManager: ICategoryManager,
    private val localShopManager: ILocalShopManager,
    private val remoteDataSource: LocalShopsService
) : IRepository {
    override fun getCategories(): Flow<Result<List<CategoryBo>>> {
        return object : NetworkBoundRepository<List<CategoryBo>, List<CategoryDTO>>() {
            override suspend fun saveRemoteData(response: List<CategoryDTO>) {
                categoryManager.saveCategories(response)
            }

            override fun fetchFromLocal(): Flow<List<CategoryBo>> = categoryManager.getCategories()

            override suspend fun fetchFromRemote(): Response<List<CategoryDTO>> = remoteDataSource.categories()
        }.asFlow().flowOn(Dispatchers.IO)
    }

    override fun getLocalShopsByCategory(categoryId: String): Flow<Result<List<LocalShopBo>>> {
        return object : NetworkBoundRepository<List<LocalShopBo>, List<LocalShopDTO>>() {
            override suspend fun saveRemoteData(response: List<LocalShopDTO>) {
                localShopManager.saveLocalShops(response)
            }

            override fun fetchFromLocal(): Flow<List<LocalShopBo>> = localShopManager.getLocalShops(categoryId)

            override suspend fun fetchFromRemote(): Response<List<LocalShopDTO>> = remoteDataSource.localShops(categoryId)
        }.asFlow().flowOn(Dispatchers.IO)
    }
}