package com.rustam.testgif.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rustam.testgif.data.database.entities.RoomGif
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GifsDao {

    @Query("SELECT * FROM gifs")
    abstract suspend fun getGifs(): List<RoomGif>

    @Query("SELECT * FROM gifs")
    abstract fun observeGifs(): Flow<List<RoomGif>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun saveGif(item: RoomGif)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveGifs(item: List<RoomGif>)
}