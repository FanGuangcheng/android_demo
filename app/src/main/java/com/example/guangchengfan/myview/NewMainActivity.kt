package com.example.guangchengfan.myview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.guangchengfan.myview.activity.RestoreActivity
import com.example.guangchengfan.myview.constraintlayout.ConstraintLayoutActivity
import com.example.guangchengfan.myview.coordinatorlayout.CoorDinatorBehaviorActivity
import com.example.guangchengfan.myview.customview.SlidingTabLayout.SlidingTabLayoutActivity
import com.example.guangchengfan.myview.ffmpeg.VideoFfmpegAct
import com.example.guangchengfan.myview.imageload.LoadBigImgActivity
import com.example.guangchengfan.myview.mediacodec.MediaCodecAct
import com.example.guangchengfan.myview.qrcode.QrCodeActivity
import com.example.guangchengfan.myview.recycleview.BRVAH.BRVAHRecycleViewActivity
import com.example.guangchengfan.myview.recycleview.SwapRecyclerViewAct
import com.example.guangchengfan.myview.view.TouchDelegateActivity
import com.example.guangchengfan.myview.viewpager.ViewPager2DemoActivity
import com.example.guangchengfan.myview.viewpager.ViewPager2LoopActivity
import com.example.guangchengfan.myview.webview.LoadWebviewActivity

/**
 * @author :fgc
 * @date :8/30/21
 */
class NewMainActivity: Activity() {
    lateinit var btn_small_icon: Button
    lateinit var btn_restore_activity: Button
    lateinit var btn_constraint_layout: Button
    lateinit var btn_qrcode_activity: Button
    lateinit var btn_brvah_recycle_view: Button
    lateinit var btn_coor_behavior: Button
    lateinit var btn_sliding_tab_layout: Button
    lateinit var btn_viewpager2_loop: Button
    lateinit var btn_img_load_big: Button
    lateinit var btn_webview_load: Button
    lateinit var btn_viewpager2_demo: Button
    lateinit var btn_swap_act: Button
    lateinit var btn_ffmpeg_test: Button
    lateinit var btn_mediacodec: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_new)

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
        btn_sliding_tab_layout = findViewById(R.id.btn_sliding_tab_layout)
        btn_sliding_tab_layout.setOnClickListener {
            startTargetActivity(SlidingTabLayoutActivity::class.java)
        }
        btn_viewpager2_loop = findViewById(R.id.btn_viewpager2_loop)
        btn_viewpager2_loop.setOnClickListener {
            startTargetActivity(ViewPager2LoopActivity::class.java)
        }
        btn_img_load_big = findViewById(R.id.btn_img_load_big)
        btn_img_load_big.setOnClickListener {
            startTargetActivity(LoadBigImgActivity::class.java)
        }

        btn_webview_load = findViewById(R.id.btn_webview_load)
        btn_webview_load.setOnClickListener {
            startTargetActivity(LoadWebviewActivity::class.java)
        }

        btn_viewpager2_demo = findViewById(R.id.btn_viewpager2_demo)
        btn_viewpager2_demo.setOnClickListener {
            startTargetActivity(ViewPager2DemoActivity::class.java)
        }

        btn_swap_act = findViewById(R.id.btn_swap_act)
        btn_swap_act.setOnClickListener {
            startTargetActivity(SwapRecyclerViewAct::class.java)
        }

        btn_ffmpeg_test = findViewById(R.id.btn_ffmpeg_test)
        btn_ffmpeg_test.setOnClickListener {
            startTargetActivity(VideoFfmpegAct::class.java)
        }

        btn_mediacodec = findViewById(R.id.btn_mediacodec)
        btn_mediacodec.setOnClickListener {
            startTargetActivity(MediaCodecAct::class.java)
        }

    }

    private fun startTargetActivity(cls : Class<*>) {
        val intent = Intent()
        intent.setClass(this, cls)
        startActivity(intent)
    }
}