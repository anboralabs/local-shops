package co.anbora.labs.localstores.internal.injection.module

import co.anbora.labs.localstores.internal.injection.module.main.LocalShopsModule
import co.anbora.labs.localstores.internal.injection.scope.MainScope
import co.anbora.labs.localstores.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {

    @MainScope
    @ContributesAndroidInjector(modules = [LocalShopsModule::class])
    internal abstract fun contributeStartupActivity(): MainActivity
}