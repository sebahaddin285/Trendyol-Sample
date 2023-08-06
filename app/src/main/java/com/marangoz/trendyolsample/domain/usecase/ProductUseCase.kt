package com.marangoz.trendyolsample.domain.usecase

import com.marangoz.trendyolsample.data.repository.RepositoryImpl
import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.Response
import com.marangoz.trendyolsample.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val repo: Repository) {


    suspend fun getProducts(): Flow<Response<Products?>> = flow {
        emit(Response.Loading)
        try {
            emit(Response.Success(repo.getProduct()))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage))
        }

    }


}