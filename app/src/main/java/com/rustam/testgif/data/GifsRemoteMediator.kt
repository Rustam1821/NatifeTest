package com.rustam.testgif.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.rustam.testgif.data.database.entities.RoomGif
import com.rustam.testgif.data.database.repo.GifDatabaseRepository
import com.rustam.testgif.data.network.repo.GifNetworkRepository
import com.rustam.testgif.domain.entities.Gif
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class GifsRemoteMediator @Inject constructor(
    private val networkRepository: GifNetworkRepository,
    private val databaseRepository: GifDatabaseRepository,
) : RemoteMediator<Int, RoomGif>() {

    private var pageIndex: Int = 0

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, RoomGif>): MediatorResult {
        pageIndex = getPageIndex(loadType) ?: return MediatorResult.Success(endOfPaginationReached = true)

        val limit: Int = state.config.pageSize
        val offset: Int = pageIndex * limit

        return try {
            val gifs = fetchGifs(limit, offset)
            if (loadType == LoadType.REFRESH) {
                databaseRepository.refresh(gifs)
            } else {
                databaseRepository.saveGifs(gifs)
            }
            MediatorResult.Success(
                endOfPaginationReached = gifs.size < limit
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }

    }

    private suspend fun fetchGifs(limit: Int, offset: Int): List<Gif> {
        val gifs: List<Gif> = networkRepository.getGifsNeo(limit = limit, offsett = offset)
        return gifs
    }

    private fun getPageIndex(loadType: LoadType): Int? {
        pageIndex = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return null
            LoadType.APPEND -> pageIndex++
        }
        return pageIndex
    }
}