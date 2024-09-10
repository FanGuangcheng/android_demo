package com.example.guangchengfan.myview.qrcode

import android.content.ContentResolver
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.net.Uri
import android.provider.MediaStore
import android.text.TextUtils
import com.huawei.hms.hmsscankit.ScanUtil
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions
import java.io.FileNotFoundException
import java.io.IOException

/**
 * @author :fgc
 * @date :2021/9/27
 */
class QrCodeActivity : AppCompatActivity() {

    companion object{
        const val SCAN_RESULT = "scanResult"
        const val REQUEST_CODE_PHOTO = 0X1113
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)
    }

    fun onQrBtnClick(view : View) {
//        QrCodeScanUtil.scanImg(this)
        val pickIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        this@QrCodeActivity.startActivityForResult(pickIntent, REQUEST_CODE_PHOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_PHOTO) {
            try {
//                val bitmap = getBitmap(this.contentResolver, data?.data)
                QrCodeScanUtil.scanImg(this, data?.data)

//                val hmsScans = ScanUtil.decodeWithBitmap(this@QrCodeActivity, bitmap, HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create())
//                if (hmsScans != null && hmsScans.size > 0 && hmsScans[0] != null && !TextUtils.isEmpty(hmsScans[0]!!.getOriginalValue())) {
//                    val intent = Intent()
//                    intent.putExtra(SCAN_RESULT, hmsScans[0])
//                    setResult(RESULT_OK, intent)
//                    finish()
//                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    @Throws(FileNotFoundException::class, IOException::class)
    fun getBitmap(cr: ContentResolver, url: Uri): Bitmap? {

        val input = cr.openInputStream(url)
        val options = BitmapFactory.Options()

        options.inSampleSize = 2
        val rect = Rect()
        val bitmap = BitmapFactory.decodeStream(input, null, options)
//        val bitmap = BitmapFactory.decodeStream(input)
        input?.close()
        return bitmap
    }

}