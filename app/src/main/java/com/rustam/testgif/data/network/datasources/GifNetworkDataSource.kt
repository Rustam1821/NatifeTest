package com.rustam.testgif.data.network.datasources

import com.rustam.testgif.data.network.entities.ApiGif
import com.rustam.testgif.data.network.entities.GifyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GifNetworkDataSource {

    @GET ("v1/gifs/search")
    suspend fun getGifs (
        @Query("api_key") apKey: String,
        @Query("q") q: Int = 0, //TODO: why do we need it?
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): GifyResponse
}