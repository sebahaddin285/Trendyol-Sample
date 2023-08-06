package com.marangoz.trendyolsample.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.domain.model.Categories

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolderClass>() {

    var categoryList: List<Categories> = listOf()



    inner class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView
        val text : TextView


        init {
            card = view.findViewById(R.id.categoryCard)
            text = view.findViewById(R.id.categoryText)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val design = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_adapter_design, parent, false)
        return ViewHolderClass(design)
    }

    override fun getItemCount(): Int {

        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val category = categoryList[position]

        holder.text.text = category.category.toString()

        if (category.isSelected == true){
            holder.card.setCardBackgroundColor(ContextCompat.getColor(holder.card.context,R.color.orange))
            holder.text.setTextColor(ContextCompat.getColor(holder.card.context,R.color.white))
        }else{
            holder.card.setCardBackgroundColor(ContextCompat.getColor(holder.card.context,R.color.white))
            holder.text.setTextColor(ContextCompat.getColor(holder.card.context,R.color.black))
        }

        holder.card.setOnClickListener(){
            categoryList.forEachIndexed { index, category ->
                if (category.isSelected == true) {
                    category.isSelected = false
                    notifyItemChanged(index)
                }
            }
            categoryList[position].isSelected = true
            notifyItemChanged(position)
        }



    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Categories>) {
        categoryList = newList
        notifyDataSetChanged()
    }
}