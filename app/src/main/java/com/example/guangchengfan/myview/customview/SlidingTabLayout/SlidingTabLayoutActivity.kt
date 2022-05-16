package com.example.guangchengfan.myview.customview.SlidingTabLayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.guangchengfan.myview.R
import com.example.guangchengfan.myview.fragment.Fragment1
import com.example.guangchengfan.myview.fragment.Fragment2
import com.example.guangchengfan.myview.viewpager.MyPagerAdapter
import com.flyco.tablayout.SlidingTabLayout


class SlidingTabLayoutActivity: AppCompatActivity() {

    private var mTab: SlidingTabLayout? = null
    private var mVp: ViewPager? = null
    private var mFragments: ArrayList<Fragment>? = null
    private val mTitlesArrays = arrayOf("新闻", "娱乐", "头条", "八卦", "哈哈", "嗷嗷啊", "ajdajdiajdij")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_tablayout_activity)
        initView()
    }

    private fun initView() {
        mTab = findViewById<View>(R.id.tab) as SlidingTabLayout
        mVp = findViewById<View>(R.id.vp) as ViewPager
        mFragments = ArrayList()
        mFragments!!.add(Fragment1())
        mFragments!!.add(Fragment2())
        mFragments!!.add(Fragment1())
        mFragments!!.add(Fragment2())
        mFragments!!.add(Fragment1())
        mFragments!!.add(Fragment2())
        mFragments!!.add(Fragment1())
        val pagerAdapter = MyPagerAdapter(supportFragmentManager, mFragments)
        mVp!!.adapter = pagerAdapter
        mTab!!.setViewPager(mVp, mTitlesArrays) //tab和ViewPager进行关联
    }
}