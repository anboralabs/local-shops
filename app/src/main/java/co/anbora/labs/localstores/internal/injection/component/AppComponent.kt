package co.anbora.labs.localstores.internal.injection.component

import co.anbora.labs.localstores.internal.injection.DaggerApplication
import co.anbora.labs.localstores.internal.injection.module.*
import co.anbora.labs.localstores.internal.injection.module.ActivitiesModule
import co.anbora.labs.localstores.internal.injection.module.AppModule
import co.anbora.labs.localstores.internal.injection.module.LocalDataSourceModule
import co.anbora.labs.localstores.internal.injection.module.RemoteDataSourceModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivitiesModule::class,
    AppModule::class,
    DataModule::class,
    LocalDataSourceModule::class,
    RemoteDataSourceModule::class
])
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}
