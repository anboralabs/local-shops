package co.anbora.labs.localstores.internal.injection.module

import co.anbora.labs.localstores.data.remote.ApiDataSource
import co.anbora.labs.localstores.data.remote.api.LocalShopAPI
import co.anbora.labs.localstores.data.remote.api.LocalShopsService
import co.anbora.labs.localstores.data.remote.mapper.CategoryDTOMapper
import co.anbora.labs.localstores.data.remote.mapper.ListCategoryDTOMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class RemoteDataSourceModule {

    @Provides
    @Singleton
    internal fun provideAPIDataSource(api: LocalShopsService): ApiDataSource = ApiDataSource(api)

    @Provides
    @Singleton
    internal fun provideLocalShopsService(): LocalShopsService = LocalShopAPI("http://127.0.0.1/")

    @Provides
    @Singleton
    internal fun provideListCategoryDTOMapper(
        categoryDTOMapper: CategoryDTOMapper
    ): ListCategoryDTOMapper = ListCategoryDTOMapper(categoryDTOMapper)

    @Provides
    @Singleton
    internal fun provideCategoryDTOMapper(): CategoryDTOMapper = CategoryDTOMapper()

}