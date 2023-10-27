package com.rustam.testgif.domain.usecases

import com.rustam.testgif.network.repo.GifNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateGifsUseCase (
        private val networkRepository: GifNetworkRepository,
) {

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        val gifs = networkRepository.getGifs()
        //TODO: "get gifs and save into DB"
    }
}