package com.example.guangchengfan.myview.recycleview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guangchengfan.myview.R
import java.util.Collections

class MyAdapter(private val itemList: MutableList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(), ItemTouchHelperAdapter {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemTouchHelperViewHolder {
        val textView: TextView = itemView.findViewById(R.id.textView)

        override fun onItemSelected() {
            itemView.setBackgroundColor(Color.RED) // 改变选中时的背景颜色
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(Color.GREEN) // 重置背景颜色
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.swap_item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = itemList[position]
        holder.itemView.setOnClickListener {
            holder.itemView.setBackgroundColor(Color.GREEN) // 重置背景颜色
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    // 实现拖动时的数据交换
    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(itemList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }
}
