package com.rustam.testgif.core.extentions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectWithLifecycle(
    lifecycleScope: LifecycleCoroutineScope,
    lifecycle: Lifecycle,
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline action: suspend (T) -> Unit
) {
    lifecycleScope.launch {
        this@collectWithLifecycle
            .flowWithLifecycle(lifecycle, lifecycleState)
            .collect {
                action(it)
            }
    }
}