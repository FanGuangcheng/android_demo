package com.example.guangchengfan.myview.qrcode

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R
import com.google.zxing.integration.android.IntentIntegrator
import android.widget.Toast

import com.google.zxing.integration.android.IntentResult

import android.content.Intent
import android.net.Uri
import com.google.zxing.qrcode.QRCodeReader


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
        IntentIntegrator(this)
            .setPrompt("请对准二维码1")// 设置提示语
            .initiateScan();// 初始化扫码
        QrCodeScanUtil.scanImg(this)
    }



    // Get the results:
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}