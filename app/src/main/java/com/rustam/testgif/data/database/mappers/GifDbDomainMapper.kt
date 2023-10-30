package com.rustam.testgif.data.database.mappers

import com.rustam.testgif.data.database.entities.RoomGif
import com.rustam.testgif.domain.entities.Gif
import com.rustam.testgif.domain.mappers.Mapper
import javax.inject.Inject

class GifDbToDomainMapper @Inject constructor() : Mapper<RoomGif, Gif> {
    override fun map(source: RoomGif): Gif {
        return Gif(
            id = source.id,
            type = source.type,
            originalUrl = source.originalUrl,
            previewUrl = source.previewUrl,
            title = source.title,
        )
    }
}

class GifDomainToDbMapper @Inject constructor() : Mapper<Gif, RoomGif> {
    override fun map(source: Gif): RoomGif {
        return RoomGif(
            id = source.id,
            type = source.type,
            originalUrl = source.originalUrl,
            previewUrl = source.previewUrl,
            title = source.title,
        )
    }

}