package com.example.guangchengfan.myview.recycleview.BRVAH

import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.guangchengfan.myview.R

/**
 * @author :fgc
 * @date :2022/1/14
 */
class DemoBRVAHAdpter(@LayoutRes layoutResId: Int): BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: String) {

        var title = holder.getView<TextView>(R.id.tv_item_title)
        title.setText(item)
//        title.setOnClickListener {
//            Toast.makeText(context, "position:" + holder.layoutPosition, Toast.LENGTH_LONG).show()
//        }
    }
}