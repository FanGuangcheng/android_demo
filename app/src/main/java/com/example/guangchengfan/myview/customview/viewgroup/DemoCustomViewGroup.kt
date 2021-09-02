package com.example.guangchengfan.myview.customview.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * @author :fgc
 * @date :9/1/21
 */
class DemoCustomViewGroup : ViewGroup {
    constructor(context: Context) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }


}