package com.marangoz.trendyolsample.domain.model

import com.google.gson.annotations.SerializedName

data class Products(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)