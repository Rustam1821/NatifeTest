package com.rustam.testgif.network.repo

import javax.inject.Inject

class GifNetworkRepository @Inject constructor(
    private val dataSource: GifNetworkDataSource
) {
}