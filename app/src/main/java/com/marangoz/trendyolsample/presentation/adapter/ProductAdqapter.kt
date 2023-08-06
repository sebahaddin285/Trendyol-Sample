package com.marangoz.trendyolsample.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.domain.model.Products
import com.marangoz.trendyolsample.domain.model.ProductsItem

class ProductAdqapter  : RecyclerView.Adapter<ProductAdqapter.ViewHolderClass>(){

    var listt : List<ProductsItem> = listOf()



    inner class ViewHolderClass(view : View) :   RecyclerView.ViewHolder(view){
        val image : ImageView
        val title : TextView
        val price : TextView

        init {
            image = view.findViewById(R.id.productImage)
            title = view.findViewById(R.id.titleText)
            price = view.findViewById(R.id.priceText)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.product_adapter_design, parent, false)
        return ViewHolderClass(design)
    }

    override fun getItemCount(): Int {
        return listt.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val product = listt[position]
        Glide.with(holder.itemView.context).load(product.images!![0]).into(holder.image)
        holder.title.text = product.title.toString()
        holder.price.text = product.price.toString() + "TL"



    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList : List<ProductsItem>){
        listt = newList
        notifyDataSetChanged()
    }


}