package com.marangoz.trendyolsample.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.domain.model.ProductsItem

class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ViewHolderClass>() {

    var serviceList: List<Int> = listOf()


    inner class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView


        init {
            image = view.findViewById(R.id.serviceImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val design = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_adapter_design, parent, false)
        return ViewHolderClass(design)
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val product = serviceList[position]

        holder.image.setImageResource(product)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Int>) {
        serviceList = newList
        notifyDataSetChanged()
    }
}