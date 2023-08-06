package com.marangoz.trendyolsample.domain.usecase

import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.Response
import com.marangoz.trendyolsample.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServiceUseCase @Inject constructor(private val repo: Repository) {


    suspend fun getServices(): Flow<MutableList<Int>> = flow {
        emit(repo.getServices())
    }


}