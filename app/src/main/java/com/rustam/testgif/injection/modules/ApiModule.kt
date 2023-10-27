package com.rustam.testgif.injection.modules

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.rustam.testgif.BuildConfig
import com.rustam.testgif.core.FeatureFlags
import com.rustam.testgif.network.BackEndConfig
import com.rustam.testgif.network.datasources.GifNetworkDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
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

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
            .readTimeout(1L, TimeUnit.MINUTES)
            .connectTimeout(1L, TimeUnit.MINUTES)
            .writeTimeout(1L, TimeUnit.MINUTES)
        if (FeatureFlags.Network.enableOkHttpLogging) {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            httpClientBuilder.addInterceptor(logger)
        }
        if (FeatureFlags.Network.enableOkHttpProfiling) {
            httpClientBuilder.addInterceptor(OkHttpProfilerInterceptor())
        }
        return httpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        backEndConfig: BackEndConfig,
        converterFactory: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(backEndConfig.baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideGifNetworkDataSource(retrofit: Retrofit): GifNetworkDataSource {
        return retrofit.create(GifNetworkDataSource::class.java)
    }

}