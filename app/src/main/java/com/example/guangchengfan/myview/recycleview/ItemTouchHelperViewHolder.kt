package com.example.guangchengfan.myview.recycleview

interface ItemTouchHelperViewHolder {
    fun onItemSelected() {
        // 改变外观，例如背景颜色
    }

    fun onItemClear() {
        // 重置外观
    }
}
