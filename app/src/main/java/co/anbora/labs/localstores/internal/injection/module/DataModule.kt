package co.anbora.labs.localstores.internal.injection.module

import android.content.Context
import androidx.arch.core.util.Function
import co.anbora.labs.localstores.data.local.ICategoryManager
import co.anbora.labs.localstores.data.local.ILocalShopManager
import co.anbora.labs.localstores.data.local.RoomDataSource
import co.anbora.labs.localstores.data.local.dao.CategoryDAO
import co.anbora.labs.localstores.data.local.inventory.AppDatabase
import co.anbora.labs.localstores.data.local.manager.CategoryManagerImpl
import co.anbora.labs.localstores.data.local.mapper.CategoryMapper
import co.anbora.labs.localstores.data.local.mapper.ListCategoryMapper
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.data.remote.ApiDataSource
import co.anbora.labs.localstores.data.remote.mapper.CategoryDTOMapper
import co.anbora.labs.localstores.data.remote.mapper.ListCategoryDTOMapper
import co.anbora.labs.localstores.data.repository.LocalStoresRepository
import co.anbora.labs.localstores.domain.model.impl.CategoryBo
import co.anbora.labs.localstores.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DataModule {

    @Provides
    @Singleton
    internal fun provideRepository(
        localDataSource: RoomDataSource,
        remoteDataSource: ApiDataSource
    ): IRepository = LocalStoresRepository(localDataSource, remoteDataSource)

}