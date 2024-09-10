package com.example.guangchengfan.myview.recycleview.BRVAH

import android.app.Service
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.guangchengfan.myview.R
import java.util.*
import kotlin.collections.ArrayList
import androidx.recyclerview.widget.ItemTouchHelper.Callback as Callback
import android.os.Vibrator




/**
 * @author :fgc
 * @date :2022/1/14
 */
class BRVAHRecycleViewActivity : AppCompatActivity() {

    lateinit var rv_brvah_recycle_view : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brvah_recycleview)
        rv_brvah_recycle_view = findViewById(R.id.rv_brvah_recycle_view)

        var gridLayoutManager = GridLayoutManager(this, 4)
        rv_brvah_recycle_view.layoutManager = gridLayoutManager

        var adapter = DemoBRVAHAdpter(R.layout.layout_brvah_item)
        var list = ArrayList<String>()
        for (i in 0..20) {
            list.add(i.toString())
        }

        adapter.setNewData(list)
        rv_brvah_recycle_view.adapter = adapter
        rv_brvah_recycle_view.addItemDecoration(DemoItemDecoration())

        var itemTouchHelper = ItemTouchHelper(object : Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                var dragFlags = 0;
                var swipeFlags = 0;
                if (recyclerView.layoutManager is GridLayoutManager) {
                    dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
                } else {
                    dragFlags = ItemTouchHelper.DOWN or ItemTouchHelper.UP
                }
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition

                if (fromPosition < toPosition) {
                    for (i in fromPosition until toPosition) {
                        Collections.swap(list, i, i + 1)
                    }
                } else {
                    for (i in fromPosition until toPosition) {
                        Collections.swap(list, i, i - 1)
                    }
                }

                adapter.notifyItemMoved(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
            }

            /**
             * 当长按选中item的时候（拖拽开始的是）调用
             */
            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder!!.itemView.setBackgroundColor(Color.YELLOW)
                }
                super.onSelectedChanged(viewHolder, actionState)
            }

            /**
             * 当手指松开的时候（拖拽完成的时候）调用
             */
            override fun clearView(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) {
                super.clearView(recyclerView, viewHolder)
                viewHolder!!.itemView.setBackgroundColor(Color.WHITE)
            }

            override fun isLongPressDragEnabled(): Boolean {
                return false
            }
        })

        itemTouchHelper.attachToRecyclerView(rv_brvah_recycle_view)

        adapter.setOnItemLongClickListener(object : OnItemLongClickListener {
            override fun onItemLongClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ): Boolean {
                if (position != 5 && position != 10) {
                    val viewHolder = rv_brvah_recycle_view.findViewHolderForAdapterPosition(position)
                    itemTouchHelper.startDrag(viewHolder!!)

                    var service = getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
                    service.vibrate(100)
                } else {
                    Toast.makeText(this@BRVAHRecycleViewActivity, "当前item不支持拖拽:", Toast.LENGTH_LONG).show()
                }

                return true
            }
        })

        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Toast.makeText(this@BRVAHRecycleViewActivity, "position is :" + position, Toast.LENGTH_LONG).show()
            }

        })
    }

    class DemoItemDecoration : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.set(10,10,10,10)
        }
    }

}