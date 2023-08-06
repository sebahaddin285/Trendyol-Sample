package com.marangoz.trendyolsample.domain.usecase

import com.marangoz.trendyolsample.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ViewPagerPhotosUseCase@Inject constructor(private val repo: Repository){
    suspend fun getViewPagerPhotos(): Flow<MutableList<Int>> = flow {
        emit(repo.getViewPagerPhotos())
    }

}