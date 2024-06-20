package com.example.guangchengfan.myview.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.guangchengfan.myview.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ViewPager2DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2_demo)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // 设置 ViewPager 的适配器
        viewPager.setAdapter(MyPager2Adapter(this))

        // 使用 TabLayoutMediator 绑定 TabLayout 和 ViewPager2
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab, position ->
            val customView = LayoutInflater.from(this).inflate(R.layout.tab_layout_item_view, null)
            val title = customView.findViewById<TextView>(R.id.tv_tab_title)
            title.text = "Tab-" + (position + 1)

            if (viewPager.currentItem == position) {
                title.setTextColor(resources.getColor(R.color.tab_green))
            } else {
                title.setTextColor(resources.getColor(R.color.colorPrimary))
            }

            tab.customView = customView
        }.attach()

        // 代码中设置属性
        tabLayout.tabGravity = TabLayout.GRAVITY_CENTER
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
//        tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.colorAccent))
//        tabLayout.setSelectedTabIndicatorHeight(4) // px
        tabLayout.setTabTextColors(
            resources.getColor(R.color.colorPrimary),
            resources.getColor(R.color.tab_green)
        )
        tabLayout.setTabRippleColorResource(R.color.colorAccent)

        // 设置 Tab 的背景
        tabLayout.setBackgroundResource(R.color.tabBackground)
//        tabLayout.post{
//            for (i in 0 until tabLayout.tabCount) {
//                val tab = tabLayout.getTabAt(i)
//                if (tab != null) {
//                    val tabView = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
//                    tabView.minimumWidth = 30
//                    tabView.requestLayout()
//                }
//            }
//        }
//
////        // 设置 Tab 的 Padding
////        for (i in 0 until tabLayout.tabCount) {
////            val tab = tabLayout.getTabAt(i)
////            if (tab != null && tab.view != null) {
////                tab.view.setPadding(0, 0, 0, 0) // 左右设置16px的内边距
////            }
////        }
    }
}
