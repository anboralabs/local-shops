package co.anbora.labs.localstores.data.remote

import co.anbora.labs.localstores.data.remote.api.LocalShopsService
import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import retrofit2.Response

class ApiDataSource(private val api: LocalShopsService) {

    suspend fun categories(): Response<List<CategoryDTO>> = api.categories()

    suspend fun localShops(categoryId: String): Response<List<LocalShopDTO>> = api.localShops(categoryId)

}