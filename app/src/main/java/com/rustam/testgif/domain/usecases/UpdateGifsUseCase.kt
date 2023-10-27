package com.rustam.testgif.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateGifsUseCase {

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        //TODO: "get gifs and save into DB"
    }
}