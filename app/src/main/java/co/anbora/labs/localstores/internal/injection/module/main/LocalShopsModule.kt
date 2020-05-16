package co.anbora.labs.localstores.internal.injection.module.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.anbora.labs.localstores.internal.injection.scope.MainScope
import co.anbora.labs.localstores.ui.category.CategoriesFragment
import co.anbora.labs.localstores.ui.category.CategoriesViewModel
import co.anbora.labs.localstores.ui.map.MapFragment
import co.anbora.labs.localstores.ui.stores.StoresFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

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
        internal fun provideViewModelFactory(): ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            return object: ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return when {
                        modelClass.isAssignableFrom(CategoriesViewModel::class.java) ->
                            CategoriesViewModel() as T

                        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }

}