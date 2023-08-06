package com.marangoz.trendyolsample.data.remote

import com.marangoz.trendyolsample.domain.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {


    @GET("/products")
    suspend fun getProduct(): Response<Products>




}