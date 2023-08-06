package com.marangoz.trendyolsample.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marangoz.trendyolsample.R

class ViewPagerAdapter(var images : List<Int>?, val mContext: Context) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolderClass>()  {

    inner class ViewPagerViewHolderClass(view: View) : RecyclerView.ViewHolder(view){
        val viewPagerFoto : ImageView
        val counterText : TextView
        init {
            viewPagerFoto = view.findViewById(R.id.viewPagerImage)
            counterText = view.findViewById(R.id.counterText)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolderClass {
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_pager_adapter_design,parent,false)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        return ViewPagerViewHolderClass(view)
    }


    override fun onBindViewHolder(holder: ViewPagerViewHolderClass, position: Int) {
        val image = images?.get(position)
        if (image != null) {
            holder.viewPagerFoto.setImageResource(image)
        }
        holder.counterText.setText("${position+1}/${images?.size}")
    }

    override fun getItemCount(): Int {
        return images?.size ?: 0
    }

    fun setList(newList: MutableList<Int>){
        images = newList
        notifyDataSetChanged()
    }



}