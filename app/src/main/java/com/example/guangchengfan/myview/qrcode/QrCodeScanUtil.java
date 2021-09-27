package com.example.guangchengfan.myview.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
                    scanImage(bitmap, context);
                }
            });
            thread.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Result scanImage(Bitmap bitmap, Context context) {
        Result result = null;
        try {
//            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
//            bitmap = getSmallerBitmap(bitmap);
            if (bitmap != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int[] pixels = new int[width * height];
                bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

                RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
                BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
                Reader reader = new QRCodeReader();
                try {
                    result = reader.decode(binaryBitmap);
                } catch (NotFoundException | ChecksumException | FormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
         }

        if (result != null) {
            Log.d("QrCodeScanUtil", result.getText());
        } else {
            Log.d("QrCodeScanUtil", "get result error");
        }
        return result;
    }

    private static Bitmap getSmallerBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            int size = bitmap.getWidth() * bitmap.getHeight() / 160000;
            if (size <= 1) {
                return bitmap;
            } else {
                Matrix matrix = new Matrix();
                matrix.postScale((float) (1 / Math.sqrt(size)), (float) (1 / Math.sqrt(size)));
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        }
        return null;
    }
}
