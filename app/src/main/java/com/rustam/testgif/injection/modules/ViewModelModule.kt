package com.rustam.testgif.injection.modules

import androidx.lifecycle.ViewModel
import com.rustam.testgif.injection.modules.annotations.ViewModelKey
import com.rustam.testgif.presentation.GifViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(GifViewModel::class)
    @Binds
    fun bindGifViewModel(viewModel: GifViewModel): ViewModel
}