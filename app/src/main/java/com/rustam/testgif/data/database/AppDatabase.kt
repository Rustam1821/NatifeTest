package com.rustam.testgif.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rustam.testgif.data.database.dao.GifsDao
import com.rustam.testgif.data.database.entities.RoomGif

@Database (
    version = 1,
    entities = [
        RoomGif::class
    ],
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract val gifsDao: GifsDao

    companion object {
        const val DB_NAME = "app.db"
    }
}