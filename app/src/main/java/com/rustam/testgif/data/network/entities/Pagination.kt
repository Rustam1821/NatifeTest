package com.rustam.testgif.data.network.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "count")
    val count: Int,
    @Json(name = "offset")
    val offset: Int,
)