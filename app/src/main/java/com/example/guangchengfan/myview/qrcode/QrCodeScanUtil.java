package com.example.guangchengfan.myview.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author :fgc
 * @date :2021/9/27
 */
public class QrCodeScanUtil {

    public static void scanImg(Context context, Bitmap bitmap) {
        try {
            FileInputStream fs = null;
            fs = new FileInputStream("/sdcard/1/1234.png");
//            fs = new FileInputStream("/sdcard/1/long.jpg");
//            fs = new FileInputStream("/sdcard/1/short.jpg");
//            Bitmap bitmap  = BitmapFactory.decodeStream(fs);

            Uri imageUri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap , null,null));
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    scanImage(bitmap, context);
                    HmsScan[] result = ScanUtil.decodeWithBitmap(context, bitmap, new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScan.ALL_SCAN_TYPE).setPhotoMode(true).create());
                    if (result != null) {
                        Log.d("QrCodeScanUtil", "result: " + result[0].originalValue);
                    }
                }
            });
            thread.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    private fun decodeBitmap(bitmap: Bitmap, scanType: Int) {
//        val hmsScans = ScanUtil.decodeWithBitmap(this@CommonActivity, bitmap, HmsScanAnalyzerOptions.Creator().setHmsScanTypes(scanType).setPhotoMode(true).create())
//        if (hmsScans != null && hmsScans.size > 0 && hmsScans[0] != null && !TextUtils.isEmpty(hmsScans[0]!!.getOriginalValue())) {
//            val intent = Intent()
//            intent.putExtra(SCAN_RESULT, hmsScans)
//            setResult(RESULT_OK, intent)
//            finish()
//        }
//    }
}
