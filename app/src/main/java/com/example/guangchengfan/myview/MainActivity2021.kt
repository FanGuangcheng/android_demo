package com.example.guangchengfan.myview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.guangchengfan.myview.activity.RestoreActivity
import com.example.guangchengfan.myview.constraintlayout.ConstraintLayoutActivity
import com.example.guangchengfan.myview.coordinatorlayout.CoorDinatorBehaviorActivity
import com.example.guangchengfan.myview.qrcode.QrCodeActivity
import com.example.guangchengfan.myview.recycleview.BRVAH.BRVAHRecycleViewActivity
import com.example.guangchengfan.myview.view.TouchDelegateActivity

/**
 * @author :fgc
 * @date :8/30/21
 */
class MainActivity2021: Activity() {
    lateinit var btn_small_icon: Button
    lateinit var btn_restore_activity: Button
    lateinit var btn_constraint_layout: Button
    lateinit var btn_qrcode_activity: Button
    lateinit var btn_brvah_recycle_view: Button
    lateinit var btn_coor_behavior: Button
    //test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2021)

        btn_small_icon = findViewById(R.id.btn_small_icon)
        btn_small_icon.setOnClickListener {
            startTargetActivity(TouchDelegateActivity::class.java)
        }

        btn_restore_activity = findViewById(R.id.btn_restore_activity)
        btn_restore_activity.setOnClickListener {
            startTargetActivity(RestoreActivity::class.java)
        }

        btn_constraint_layout = findViewById(R.id.btn_constraint_layout)
        btn_constraint_layout.setOnClickListener {
            startTargetActivity(ConstraintLayoutActivity::class.java)
        }

        btn_qrcode_activity = findViewById(R.id.btn_qrcode_activity)
        btn_qrcode_activity.setOnClickListener {
            startTargetActivity(QrCodeActivity::class.java)
        }
        btn_brvah_recycle_view = findViewById(R.id.btn_brvah_recycle_view)
        btn_brvah_recycle_view.setOnClickListener {
            startTargetActivity(BRVAHRecycleViewActivity::class.java)
        }
        btn_coor_behavior = findViewById(R.id.btn_coor_behavior)
        btn_coor_behavior.setOnClickListener {
            startTargetActivity(CoorDinatorBehaviorActivity::class.java)
        }
    }

    private fun startTargetActivity(cls : Class<*>) {
        val intent = Intent()
        intent.setClass(this, cls)
        startActivity(intent)
    }
}