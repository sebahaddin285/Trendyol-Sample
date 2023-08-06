package com.marangoz.trendyolsample.presentation.ui.anasayfa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.marangoz.trendyolsample.data.remote.RickPaggingSource
import com.marangoz.trendyolsample.data.repository.RepositoryImpl
import com.marangoz.trendyolsample.domain.model.Categories
import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.Response
import com.marangoz.trendyolsample.domain.model.RickModel
import com.marangoz.trendyolsample.domain.usecase.CategoryUseCase
import com.marangoz.trendyolsample.domain.usecase.ProductUseCase
import com.marangoz.trendyolsample.domain.usecase.ServiceUseCase
import com.marangoz.trendyolsample.domain.usecase.ViewPagerPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageFragmentViewModel @Inject constructor(private val productUseCase: ProductUseCase,private val serviceUseCase: ServiceUseCase,private val viewPagerUseCase: ViewPagerPhotosUseCase,private val categoryUseCase: CategoryUseCase) : ViewModel() {


        val liveProduct : MutableLiveData<Response<Products?>> = MutableLiveData()

         fun getData() {
             viewModelScope.launch {
                  productUseCase.getProducts().collect {
                      liveProduct.value = it

                 }
             }

        }

    suspend fun getServiceData() : Flow<MutableList<Int>>{


        return serviceUseCase.getServices()

    }
    suspend fun getViewPagerPhotos(): Flow<MutableList<Int>> {

        return viewPagerUseCase.getViewPagerPhotos()
    }

    suspend fun getCategory(): Flow<MutableList<Categories>> {

        return categoryUseCase.getCategory()
    }





}