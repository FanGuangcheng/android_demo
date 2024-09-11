package com.example.guangchengfan.myview.recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guangchengfan.myview.R

class SwapRecyclerViewAct : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swap_act)

        recyclerView = findViewById(R.id.recyclerView)

        // 初始化数据
        val items = mutableListOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // 设置适配器
        adapter = MyAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 创建并附加 ItemTouchHelper
        val itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
