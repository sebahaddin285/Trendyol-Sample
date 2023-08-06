package com.marangoz.trendyolsample.domain.usecase

import com.marangoz.trendyolsample.domain.model.Categories
import com.marangoz.trendyolsample.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val repo: Repository) {


    suspend fun getCategory(): Flow<MutableList<Categories>> = flow {
        emit(repo.getCategory())
    }


}