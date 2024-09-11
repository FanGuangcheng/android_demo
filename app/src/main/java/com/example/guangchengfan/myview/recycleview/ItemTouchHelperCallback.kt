package com.example.guangchengfan.myview.recycleview

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemTouchHelperCallback(val adapter: MyAdapter) : ItemTouchHelper.Callback() {


    override fun isLongPressDragEnabled(): Boolean {
        return true  // 长按启用拖拽
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false  // 禁用滑动删除
    }

    // 当拖拽时调用，用来交换项目位置
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        adapter.swapItems(fromPosition, toPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // 不处理滑动
    }

    // 定义拖拽和滑动的方向
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        return makeMovementFlags(dragFlags, 0)
    }
}
