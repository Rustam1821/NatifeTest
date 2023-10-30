package com.rustam.testgif.domain.entities

data class Gif(
    val id: String,
    val type: String,
    val originalUrl: String,
    val previewUrl: String,
    val title: String,
)
