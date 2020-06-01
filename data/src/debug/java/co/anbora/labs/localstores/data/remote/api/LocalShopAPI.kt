package co.anbora.labs.localstores.data.remote.api

import co.anbora.labs.localstores.data.remote.api.util.MoshiConverters
import co.anbora.labs.localstores.data.local.AssetFileReader
import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.data.remote.model.LocalShopDTO
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT = 10L

class LocalShopAPI(
    private val urlApi: String,
    private val assetReader: AssetFileReader
): LocalShopsService {

    private val remoteService: LocalShopsService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        val mockResponseInterceptor = FakeResponseInterceptor(assetReader)

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(mockResponseInterceptor)

        val client = httpClient.build()

        val moshi = Moshi.Builder()
            .add(Wrapped.ADAPTER_FACTORY)
            .add(MoshiConverters())
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()

        remoteService = retrofit.create(LocalShopsService::class.java)
    }

    override suspend fun categories(): Response<List<CategoryDTO>> = remoteService.categories()

    override suspend fun localShops(categoryId: String): Response<List<LocalShopDTO>> = remoteService.localShops(categoryId)
}