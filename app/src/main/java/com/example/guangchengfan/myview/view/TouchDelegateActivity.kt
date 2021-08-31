package com.example.guangchengfan.myview.view

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.TouchDelegate
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.guangchengfan.myview.R


/**
 * 扩大View点击范围
 * https://www.jianshu.com/p/5091dc716d80
 */
class TouchDelegateActivity : AppCompatActivity() {
    lateinit var imageLike : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_delegate)
        imageLike = findViewById(R.id.iv_small_like)
        setTouchDelegate(imageLike, 50)
        imageLike.setOnClickListener {
            Toast.makeText(this@TouchDelegateActivity, "点击了live图标",  Toast.LENGTH_LONG).show()
            Log.d("TouchDelegateActivity", "点击了live图标")
        }

    }

   /* 必须保证parent足够大，如果自定义的范围超出parent的大小，则超出的那部分无效。
    一个parent只能设置一个触摸委派，设置多个时，只有最后设置的child有效。
    如果希望一个view能设置多个委派，需要再自定义parent */
    fun setTouchDelegate(view: View, expandTouchWidth: Int) {
        val parentView: View = view.parent as View
        parentView.post {
            val rect = Rect()
            // view 构建完成后，才能获取view的区域，所以放到post中
            view.getHitRect(rect)
            // 4个方向增加矩形区域面积
            rect.top -= expandTouchWidth
            rect.bottom += expandTouchWidth
            rect.left -= expandTouchWidth
            rect.right += expandTouchWidth
            // parent中rect这块区域，代理给view
            parentView.touchDelegate = TouchDelegate(rect, view)
        }
    }
}