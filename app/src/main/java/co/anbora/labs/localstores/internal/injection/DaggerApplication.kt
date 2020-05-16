package co.anbora.labs.localstores.internal.injection

import android.app.AppComponentFactory
import android.app.Application
import co.anbora.labs.localstores.internal.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class DaggerApplication: Application(), HasAndroidInjector {

    @Inject lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .create(this).inject(this)
    }
}