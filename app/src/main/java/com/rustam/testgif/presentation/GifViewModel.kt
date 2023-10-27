package com.rustam.testgif.presentation

import com.rustam.testgif.data.database.repo.GifDatabaseRepository
import com.rustam.testgif.domain.usecases.UpdateGifsUseCase
import com.rustam.testgif.presentation.base.BaseViewModel
import com.rustam.testgif.presentation.entities.UiGif
import com.rustam.testgif.presentation.mappers.GifDomainToUiMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GifViewModel @Inject constructor(
    private val databaseRepository: GifDatabaseRepository,
    private val domainToUiMapper: GifDomainToUiMapper,
    private val updateGifsUseCase: UpdateGifsUseCase,

    ) : BaseViewModel() {

    val gifsFlow: Flow<List<UiGif>>
        get() = databaseRepository.observeGifs().map {
            domainToUiMapper.map(it)
        }

    fun updateGifs() = launch {
        updateGifsUseCase()
    }
}