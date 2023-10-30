package com.rustam.testgif.data.network.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GifyResponse(
    @Json(name = "data")
    val gifs: List<ApiGif>,
    @Json(name = "pagination")
    val pagination: Pagination,
)
