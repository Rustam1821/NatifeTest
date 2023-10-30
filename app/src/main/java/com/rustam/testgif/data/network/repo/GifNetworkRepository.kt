package com.rustam.testgif.data.network.repo

import android.util.Log
import com.rustam.testgif.BuildConfig
import com.rustam.testgif.domain.entities.Gif
import com.rustam.testgif.data.network.datasources.GifNetworkDataSource
import com.rustam.testgif.data.network.mappers.GifApiToDomainMapper
import javax.inject.Inject

class GifNetworkRepository @Inject constructor(
    private val dataSource: GifNetworkDataSource,
    private val mapper: GifApiToDomainMapper,
) {

    private var requestNumber = 0
    private var offset = LIMIT * requestNumber++

    suspend fun getGifs(): List<Gif> {
        val response = dataSource.getGifs(
            apKey = BuildConfig.API_KEY,
            limit = LIMIT,
            offset = offset,
        )
        val gifs = response.gifs
        return mapper.map(gifs)
    }

    companion object {
        private const val LIMIT = 10
    }
}