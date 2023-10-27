package com.rustam.testgif.data.network.repo

import com.rustam.testgif.BuildConfig
import com.rustam.testgif.domain.entities.Gif
import com.rustam.testgif.data.network.datasources.GifNetworkDataSource
import com.rustam.testgif.data.network.mappers.GifApiToDomainMapper
import javax.inject.Inject

class GifNetworkRepository @Inject constructor(
    private val dataSource: GifNetworkDataSource,
    private val mapper: GifApiToDomainMapper,
) {

    suspend fun getGifs(): List<Gif> {
        val response = dataSource.getGifs(
            apKey = BuildConfig.API_KEY,
            limit = 10,
            q = 1
        )
        return mapper.map(response)
    }
}