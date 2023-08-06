package com.marangoz.trendyolsample.domain.model

sealed class Response<out T> {

    class Success<T>(val data: T) : Response<T>()

    class Error(val message: String?) : Response<Nothing>()

    object Loading : Response<Nothing>()

}