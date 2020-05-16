package co.anbora.labs.localstores.internal.injection.module

import android.content.Context
import co.anbora.labs.localstores.internal.injection.DaggerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    @Singleton
    internal fun providesContext(application: DaggerApplication): Context = application.applicationContext
}