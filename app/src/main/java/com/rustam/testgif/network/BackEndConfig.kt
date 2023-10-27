package com.rustam.testgif.network

sealed class BackEndConfig(val baseUrl: String) {
    object Stage : BackEndConfig("https://api.giphy.com")
    object Production : BackEndConfig("https://api.giphy.com")
}