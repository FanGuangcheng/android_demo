package com.example.guangchengfan.myview.qrcode

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R
import android.content.Intent
/**
 * @author :fgc
 * @date :2021/9/27
 */
class QrCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)
    }

    fun onQrBtnClick(view : View) {
    }



    // Get the results:
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}