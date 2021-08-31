package com.example.guangchengfan.myview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.guangchengfan.myview.view.TouchDelegateActivity

/**
 * @author :fgc
 * @date :8/30/21
 */
class MainActivity2021: Activity() {
    lateinit var btn_small_icon: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2021)

        btn_small_icon = findViewById(R.id.btn_small_icon)
        btn_small_icon.setOnClickListener {
            startTargetActivity(TouchDelegateActivity::class.java)
        }
    }

    private fun startTargetActivity(cls : Class<*>) {
        val intent = Intent()
        intent.setClass(this, cls)
        startActivity(intent)
    }
}