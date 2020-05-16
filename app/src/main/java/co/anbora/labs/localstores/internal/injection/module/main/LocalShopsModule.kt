package co.anbora.labs.localstores.internal.injection.module.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.anbora.labs.localstores.domain.repository.IRepository
import co.anbora.labs.localstores.domain.usecase.categories.GetAllCategoriesUseCase
import co.anbora.labs.localstores.internal.injection.scope.MainScope
import co.anbora.labs.localstores.ui.category.CategoriesFragment
import co.anbora.labs.localstores.ui.category.CategoriesViewModel
import co.anbora.labs.localstores.ui.map.MapFragment
import co.anbora.labs.localstores.ui.stores.StoresFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.Dispatchers

@Module
internal abstract class LocalShopsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCategoriesFragment(): CategoriesFragment

    @ContributesAndroidInjector
    internal abstract fun contributeMapFragment(): MapFragment

    @ContributesAndroidInjector
    internal abstract fun contributeStoresFragment(): StoresFragment

    @Module
    companion object {

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideGetAllCategoriesUseCase(repository: IRepository): GetAllCategoriesUseCase {
            return GetAllCategoriesUseCase(repository, Dispatchers.Default)
        }

        @MainScope
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(
            getAllCategoriesUseCase: GetAllCategoriesUseCase
        ): ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            return object: ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return when {
                        modelClass.isAssignableFrom(CategoriesViewModel::class.java) ->
                            CategoriesViewModel(getAllCategoriesUseCase) as T

                        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }

}