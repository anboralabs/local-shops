package co.anbora.labs.localstores.internal.injection.module

import android.content.Context
import co.anbora.labs.localstores.data.local.ICategoryManager
import co.anbora.labs.localstores.data.local.ILocalShopManager
import co.anbora.labs.localstores.data.local.RoomDataSource
import co.anbora.labs.localstores.data.local.dao.CategoryDAO
import co.anbora.labs.localstores.data.local.inventory.AppDatabase
import co.anbora.labs.localstores.data.local.manager.CategoryManagerImpl
import co.anbora.labs.localstores.data.local.manager.LocalShopManagerImpl
import co.anbora.labs.localstores.data.local.mapper.CategoryMapper
import co.anbora.labs.localstores.data.local.mapper.ListCategoryMapper
import co.anbora.labs.localstores.data.remote.mapper.ListCategoryDTOMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class LocalDataSourceModule {

    @Provides
    @Singleton
    internal fun provideLocalDataSource(
        categoryManager: ICategoryManager,
        localShopManager: ILocalShopManager
    ): RoomDataSource = RoomDataSource(categoryManager, localShopManager)

    @Provides
    @Singleton
    internal fun provideCategoryManager(
        categoriesDAO: CategoryDAO,
        listCategoryMapper: ListCategoryMapper,
        listCategoryDTOMapper: ListCategoryDTOMapper
    ): ICategoryManager = CategoryManagerImpl(categoriesDAO, listCategoryMapper, listCategoryDTOMapper)

    @Provides
    @Singleton
    internal fun provideLocalShopManager(): ILocalShopManager = LocalShopManagerImpl()

    @Provides
    @Singleton
    internal fun provideListCategoryMapper(
        categoryMapper: CategoryMapper
    ): ListCategoryMapper = ListCategoryMapper(categoryMapper)

    @Provides
    @Singleton
    internal fun provideCategoryVOMapper(): CategoryMapper = CategoryMapper()

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    internal fun provideCategoryDAO(database: AppDatabase): CategoryDAO = database.getCategoryDao()
}