package com.example.guangchengfan.myview.qrcode

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R
import com.google.zxing.integration.android.IntentIntegrator

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
            .setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES)// 扫码的类型,可选：一维码，二维码，一/二维码
            .setPrompt("请对准二维码")// 设置提示语
            .setCameraId(0)// 选择摄像头,可使用前置或者后置
            .setBeepEnabled(false)// 是否开启声音,扫完码之后会"哔"的一声
            .setBarcodeImageEnabled(true)// 扫完码之后生成二维码的图片
            .initiateScan();// 初始化扫码
    }
}