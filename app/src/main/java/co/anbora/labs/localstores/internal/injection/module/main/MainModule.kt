package co.anbora.labs.localstores.internal.injection.module.main

import co.anbora.labs.localstores.ui.category.CategoriesFragment
import co.anbora.labs.localstores.ui.map.MapFragment
import co.anbora.labs.localstores.ui.stores.StoresFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCategoriesFragment(): CategoriesFragment

    @ContributesAndroidInjector
    internal abstract fun contributeMapFragment(): MapFragment

    @ContributesAndroidInjector
    internal abstract fun contributeStoresFragment(): StoresFragment

}