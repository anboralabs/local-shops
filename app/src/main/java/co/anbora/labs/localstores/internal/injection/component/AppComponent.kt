package co.anbora.labs.localstores.internal.injection.component

import co.anbora.labs.localstores.internal.injection.DaggerApplication
import co.anbora.labs.localstores.internal.injection.module.ActivitiesModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivitiesModule::class
])
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}
