package com.rustam.testgif.presentation.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    protected fun launch(
        coroutineContext: CoroutineContext = EmptyCoroutineContext,
        exceptionHandler: CoroutineExceptionHandler = coroutineExceptionHandler,
        block: suspend CoroutineScope.() -> Unit,
    ): Job = viewModelScope.launch(coroutineContext + exceptionHandler, block = block)

    private fun handleError(throwable: Throwable) {
        Log.w("BaseViewModel", throwable)
    }
}