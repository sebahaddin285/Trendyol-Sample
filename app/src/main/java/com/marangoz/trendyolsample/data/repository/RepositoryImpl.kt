package com.marangoz.trendyolsample.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.data.remote.RetrofitService
import com.marangoz.trendyolsample.data.remote.RickPaggingSource
import com.marangoz.trendyolsample.data.remote.RickService
import com.marangoz.trendyolsample.domain.model.Categories
import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.ResultsItem
import com.marangoz.trendyolsample.domain.model.RickModel
import com.marangoz.trendyolsample.domain.repository.Repository
import retrofit2.Response
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val api : RetrofitService , val rickApi : RickService) : Repository {
    override suspend fun getProduct(): Products? {
        return api.getProduct().body()
    }

    override suspend fun getServices(): MutableList<Int> {
        val imageList : ArrayList<Int> = ArrayList()
        imageList.add(R.drawable.resim1)
        imageList.add(R.drawable.resim2)
        imageList.add(R.drawable.resim3)
        imageList.add(R.drawable.resim4)
        imageList.add(R.drawable.resim5)
        imageList.add(R.drawable.resim6)


        return imageList
    }

    override suspend fun getViewPagerPhotos(): MutableList<Int> {
        val imageList : ArrayList<Int> = ArrayList()
        imageList.add(R.drawable.viewpager1)
        imageList.add(R.drawable.viewpager2)
        imageList.add(R.drawable.viewpager3)



        return imageList
    }

    override suspend fun getCategory(): MutableList<Categories> {
        val clist : ArrayList<Categories> = ArrayList()
        val model = Categories("Giyim",true)
        val model1 = Categories("Bilgisayar",false)
        val model3 = Categories("Tablet",false)
        val model4 = Categories("Beyaz Eşya",false)
        val model5 = Categories("Telefon",false)
        val model6 = Categories("Gözlük",false)
        val model7 = Categories("Araba",false)
        val model8 = Categories("Cam",false)
        clist.add(model)
        clist.add(model1)
        clist.add(model4)
        clist.add(model3)
        clist.add(model5)
        clist.add(model6)
        clist.add(model7)
        clist.add(model8)


        return clist
    }

    override suspend fun getRickData(pagingConfig : PagingConfig): LiveData<PagingData<ResultsItem>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {RickPaggingSource(rickApi)}
        ).liveData
    }


}