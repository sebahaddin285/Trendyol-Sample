package com.marangoz.trendyolsample.domain.model

import com.google.gson.annotations.SerializedName

data class Categories (
    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("isSelected")
    var isSelected: Boolean? = null
){
}