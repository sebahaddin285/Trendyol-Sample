package com.marangoz.trendyolsample.data.remote

import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.RickModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickService {


    @GET("api/character/")
    suspend fun getRick(
        @Query("page") page: Int
    ): RickModel

}