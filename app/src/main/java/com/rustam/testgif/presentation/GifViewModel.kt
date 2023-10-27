package com.rustam.testgif.presentation

import com.rustam.testgif.data.database.repo.GifDatabaseRepository
import com.rustam.testgif.domain.entities.Gif
import com.rustam.testgif.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GifViewModel @Inject constructor(
    private val databaseRepository: GifDatabaseRepository,
) : BaseViewModel() {

    val gifsFlow: Flow<List<Gif>>
        get() = databaseRepository.observeGifs().map {
            domainToUiMapper.map(it)
        }
}