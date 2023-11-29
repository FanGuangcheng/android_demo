package com.example.guangchengfan.myview.viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.guangchengfan.myview.R

class ViewPager2LoopActivity : AppCompatActivity() {

    private lateinit var bannerVp: ViewPager2
    private var currentItem: Int = 0
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager2_loop)
        bannerVp = findViewById(R.id.bannerVp)

        var adapter = MyViewPager2Adapter()
        var imgList = mutableListOf<Int>()

        // 开头添加最后一个item
        imgList.add(R.drawable.img_444)

        imgList.add(R.drawable.img_111)
        imgList.add(R.drawable.img_222)
        imgList.add(R.drawable.img_333)
        imgList.add(R.drawable.img_444)

        // 结尾添加第一个item
        imgList.add(R.drawable.img_111)

        adapter.dataList = imgList
        bannerVp.adapter = adapter
        currentItem = 0

        bannerVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentItem = position
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (adapter.itemCount > 2) { // 列表大于1，才会无限滚动
                    if (state == ViewPager2.SCROLL_STATE_IDLE) {
                        if (currentItem == 0) {
                            bannerVp.setCurrentItem(adapter.itemCount - 2, false)
                        } else if (currentItem == adapter.itemCount - 1) {
                            bannerVp.setCurrentItem(1, false)
                        }
                    }
                }
            }
        })

        bannerVp.getChildAt(0).setOnTouchListener { _, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    enableLoop(false)
                }
                MotionEvent.ACTION_UP -> {
                    enableLoop(true)
                }
            }

            return@setOnTouchListener false
        }

        bannerVp.currentItem = 1

    }

    private val mRunnable = Runnable {
        bannerVp.currentItem = ++bannerVp.currentItem
        enableLoop(true)
    }

    private fun enableLoop(enable: Boolean) {
        if (enable) {
            bannerVp.postDelayed(mRunnable, 2000)
        } else {
            bannerVp.removeCallbacks(mRunnable)
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        enableLoop(hasFocus)
    }
}