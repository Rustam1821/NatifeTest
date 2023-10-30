package com.rustam.testgif.data.database.repo

import com.rustam.testgif.data.database.dao.GifsDao
import com.rustam.testgif.data.database.mappers.GifDbToDomainMapper
import com.rustam.testgif.data.database.mappers.GifDomainToDbMapper
import com.rustam.testgif.domain.entities.Gif
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GifDatabaseRepository @Inject constructor(
    private val gifsDao: GifsDao,
    private val dbToDomainMapper: GifDbToDomainMapper,
    private val domainToDbMapper: GifDomainToDbMapper,
) {
    suspend fun saveGifs(gifs: List<Gif>) {
        val roomGifs = domainToDbMapper.map(gifs)
        gifsDao.saveGifs(roomGifs)
    }

    fun observeGifs(): Flow<List<Gif>> {
        return gifsDao.observeGifs().map {
            dbToDomainMapper.map(it)
        }
    }

    suspend fun refresh(gifs:List<Gif>) {
        val roomGifs = domainToDbMapper.map(gifs)
        gifsDao.refresh(roomGifs)
    }

}