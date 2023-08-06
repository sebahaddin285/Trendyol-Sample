package com.marangoz.trendyolsample.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.marangoz.trendyolsample.domain.model.ResultsItem
import com.marangoz.trendyolsample.domain.model.RickModel
import java.io.IOException
import javax.inject.Inject

class RickPaggingSource @Inject constructor(private val api : RickService) :
    PagingSource<Int, ResultsItem>() {
    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {
        val page = params.key ?: 1
        return try {
            val response = api.getRick(page)

            LoadResult.Page(
                data = response.results, prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.info?.next == null) null else page + 1
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }

    }


}