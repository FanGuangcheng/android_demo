package com.example.guangchengfan.myview.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author :fgc
 * @date :2021/9/27
 */
public class QrCodeScanUtil {

    public static void scanImg(Context context) {
        try {
            FileInputStream fs = null;
//            fs = new FileInputStream("/sdcard/1/1234.png");
//            fs = new FileInputStream("/sdcard/1/long.jpg");
            fs = new FileInputStream("/sdcard/1/short.jpg");
            Bitmap bitmap  = BitmapFactory.decodeStream(fs);

            Uri imageUri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap , null,null));
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    scanImage(bitmap, context);
                }
            });
            thread.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
