package com.rustam.testgif.presentation.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.rustam.testgif.core.extentions.collectWithLifecycle
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

abstract class BaseFragment: Fragment(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any>  = androidInjector

    protected val viewScope: LifecycleCoroutineScope
        get() = viewLifecycleOwner.lifecycleScope

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    open fun inject () {
        AndroidSupportInjection.inject(this)
    }

    protected inline fun <T> Flow<T>.collectWithLifecycleState(
        crossinline action: suspend (T) -> Unit
    ) {
        this.collectWithLifecycle(
            lifecycleScope = viewScope,
            lifecycle = lifecycle,
            action = action
        )
    }
}
