package com.rustam.testgif.domain.usecases

import android.util.Log
import com.rustam.testgif.data.database.repo.GifDatabaseRepository
import com.rustam.testgif.data.network.repo.GifNetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateGifsUseCase @Inject constructor (
    private val networkRepository: GifNetworkRepository,
    private val databaseRepository: GifDatabaseRepository
) {

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        val gifs = networkRepository.getGifs()
        databaseRepository.saveGifs(gifs)
    }
}