package com.rustam.testgif.data.network

sealed class BackEndConfig(val baseUrl: String) {
    object Stage : BackEndConfig("https://api.giphy.com")
    object Production : BackEndConfig("https://api.giphy.com")
}