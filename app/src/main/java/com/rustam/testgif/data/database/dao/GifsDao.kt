package com.rustam.testgif.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.rustam.testgif.data.database.entities.RoomGif
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GifsDao {

    @Query("SELECT * FROM gifs")
    abstract fun observeGifs(): Flow<List<RoomGif>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun saveGif(item: RoomGif)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun saveGifs(item: List<RoomGif>)
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(gifs: List<RoomGif>)

    @Query("SELECT * FROM gifs WHERE :query = '' OR title LIKE '%' || :query || '%'")
    abstract suspend fun pagingSource(query: String): PagingSource<Int, RoomGif>

    @Query("DELETE FROM gifs")
    abstract suspend fun clearAll()

    @Transaction
    suspend fun refresh(gifs: List<RoomGif>) {
        clearAll()
        insertAll(gifs)
    }
}