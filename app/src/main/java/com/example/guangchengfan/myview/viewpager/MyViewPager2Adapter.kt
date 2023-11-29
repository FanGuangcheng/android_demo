package com.example.guangchengfan.myview.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guangchengfan.myview.R
import com.google.android.material.imageview.ShapeableImageView

class MyViewPager2Adapter : RecyclerView.Adapter<MyViewPager2Adapter.MyViewPager2Holder>() {

    var dataList = mutableListOf<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewPager2Holder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_viewpager2, parent, false)
        return MyViewPager2Holder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewPager2Holder, position: Int) {
        holder.ivItemImg.setImageDrawable(holder.ivItemImg.resources.getDrawable(dataList.get(position)))
    }

    class MyViewPager2Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var ivItemImg = itemView.findViewById<ShapeableImageView>(R.id.iv_banner_view)
    }
}

