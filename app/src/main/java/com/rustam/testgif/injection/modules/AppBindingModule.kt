package com.rustam.testgif.injection.modules

import com.rustam.testgif.presentation.main.FirstFragment
import com.rustam.testgif.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindingModule {

//    @ContributesAndroidInjector
//    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindFirstFragment(): FirstFragment
}