package com.rustam.testgif.injection.modules

import com.rustam.testgif.BuildConfig
import com.rustam.testgif.network.BackEndConfig
import com.rustam.testgif.network.Production
import com.rustam.testgif.network.Stage
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideBackEndConfig(): BackEndConfig {
        return if (BuildConfig.DEBUG) BackEndConfig.Stage else BackEndConfig.Production
    }

    @Provides
    @Singleton
    fun provideJsonConverter(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }


}