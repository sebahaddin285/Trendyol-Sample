package com.marangoz.trendyolsample.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.marangoz.trendyolsample.domain.model.Categories
import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.ResultsItem
import com.marangoz.trendyolsample.domain.model.RickModel
import retrofit2.Response
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getProduct() : Products?

    suspend fun getServices() : MutableList<Int>

    suspend fun getViewPagerPhotos() : MutableList<Int>

    suspend fun getCategory() : MutableList<Categories>

    suspend fun getRickData(pagingData: PagingConfig) : LiveData<PagingData<ResultsItem>>




}