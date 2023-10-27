package com.rustam.testgif.presentation.mappers

import com.rustam.testgif.domain.entities.Gif
import com.rustam.testgif.domain.mappers.Mapper
import com.rustam.testgif.presentation.entities.UiGif
import javax.inject.Inject

class GifDomainToUiMapper @Inject constructor(): Mapper<Gif, UiGif> {
    override fun map(source: Gif): UiGif {
        return UiGif(
            id = source.id,
            type = source.type,
            url = source.url,
            title = source.title
        )
    }
}