package com.marangoz.trendyolsample.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.domain.model.ResultsItem
import com.marangoz.trendyolsample.domain.model.RickModel

class RickAdapter() : PagingDataAdapter<ResultsItem, RickAdapter.ViewHolderClass>(CollectionComparator) {

    override fun onBindViewHolder(holder: RickAdapter.ViewHolderClass, position: Int) {
        val items = getItem(position)

        Glide.with(holder.itemView.context).load(items?.image).into(holder.image)
        holder.text.text = items?.name.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAdapter.ViewHolderClass {
        val design = LayoutInflater.from(parent.context)
            .inflate(R.layout.rick_adapter_design, parent, false)
        return ViewHolderClass(design)
    }


    object CollectionComparator : DiffUtil.ItemCallback<ResultsItem>() {

        override fun areItemsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem == newItem
        }


    }
    inner class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val text : TextView


        init {
            image = view.findViewById(R.id.RickText)
            text = view.findViewById(R.id.nameText)
        }

    }



}