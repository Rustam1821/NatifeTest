package com.rustam.testgif.data.network.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiGif(
    @Json(name = "id")
    val id: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "images")
    val images: ApiImages,
)

@JsonClass(generateAdapter = true)
data class ApiImages(
    @Json(name = "original")
    val original: ApiImageUrl,
    @Json(name = "preview_gif")
    val preview: ApiImageUrl,
)

@JsonClass(generateAdapter = true)
data class ApiImageUrl(
    @Json(name = "url")
    val url: String,
)
