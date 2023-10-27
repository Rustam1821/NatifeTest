package com.rustam.testgif.injection.modules

import com.rustam.testgif.presentation.main.FirstFragment
import com.rustam.testgif.presentation.main.MainActivity
import com.rustam.testgif.presentation.main.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun bindSecondFragment(): SecondFragment
}