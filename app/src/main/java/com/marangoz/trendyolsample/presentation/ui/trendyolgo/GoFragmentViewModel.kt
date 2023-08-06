package com.marangoz.trendyolsample.presentation.ui.trendyolgo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.marangoz.trendyolsample.domain.model.ResultsItem
import com.marangoz.trendyolsample.domain.model.RickModel
import com.marangoz.trendyolsample.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoFragmentViewModel @Inject constructor(private val repo : Repository) : ViewModel() {
    var liveData : LiveData<PagingData<ResultsItem>> = MutableLiveData()
     fun getRickData()  {
         viewModelScope.launch {
             val pagingConfig = PagingConfig(10)
             liveData = repo.getRickData(pagingConfig)
         }

    }



}