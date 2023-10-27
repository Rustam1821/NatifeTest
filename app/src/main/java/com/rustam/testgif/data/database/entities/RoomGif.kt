package com.rustam.testgif.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "gifs"
)
data class RoomGif (
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val type: String,
    val url: String,
    val title: String,
)
