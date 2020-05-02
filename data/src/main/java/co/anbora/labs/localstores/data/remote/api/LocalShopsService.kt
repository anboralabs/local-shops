package co.anbora.labs.localstores.data.remote.api

import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocalShopsAPI {

    @GET("/categories")
    suspend fun categories(): Response<List<CategoryDTO>>

    @GET("/{categoryId}/shops")
    suspend fun localShops(@Path("categoryId") categoryId: String): Response<List<LocalShopDTO>>

}