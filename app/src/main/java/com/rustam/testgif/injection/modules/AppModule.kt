package com.rustam.testgif.injection.modules

import android.content.Context
import com.rustam.testgif.injection.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context = application.applicationContext
}