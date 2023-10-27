package com.rustam.testgif.injection.components

import com.rustam.testgif.injection.App
import com.rustam.testgif.injection.modules.ApiModule
import com.rustam.testgif.injection.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        AppBindingModule::class,
        ViewModelModule::class,
        ApiModule::class,
        DatabaseModule::class
    ]
)

interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App?)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}