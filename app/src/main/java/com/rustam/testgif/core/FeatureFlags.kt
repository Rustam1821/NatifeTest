package com.rustam.testgif.core

import androidx.annotation.Keep
import com.rustam.testgif.BuildConfig

sealed class FeatureFlags {

    object Network {
        @Keep
        @JvmField
        var enableOkHttpLogging: Boolean = BuildConfig.DEBUG

        @Keep
        @JvmField
        var enableOkHttpProfiling: Boolean = BuildConfig.DEBUG
    }
}
