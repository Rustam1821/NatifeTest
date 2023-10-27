package com.rustam.testgif.data.network.mappers

import com.rustam.testgif.domain.entities.Gif
import com.rustam.testgif.domain.mappers.Mapper
import com.rustam.testgif.data.network.entities.ApiGif
import javax.inject.Inject

class GifApiToDomainMapper @Inject constructor() : Mapper<ApiGif, Gif> {
    override fun map(source: ApiGif): Gif {
        return Gif(
            id = source.id,
            type = source.type,
            url = source.url,
            title = source.title
        )
    }
}