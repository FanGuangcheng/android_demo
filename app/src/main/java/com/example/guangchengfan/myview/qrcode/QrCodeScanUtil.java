package com.example.guangchengfan.myview.qrcode;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
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
import java.io.IOException;
import java.io.InputStream;

/**
 * @author :fgc
 * @date :2021/9/27
 */
public class QrCodeScanUtil {

    /**
     * 读取一个缩放后的图片，限定图片大小，避免OOM
     * @param uri       图片uri，支持“file://”、“content://”
     * @param maxWidth  最大允许宽度
     * @param maxHeight 最大允许高度
     * @return  返回一个缩放后的Bitmap，失败则返回null
     */
    public static Bitmap decodeUri(Context context, Uri uri, int maxWidth, int maxHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; //只读取图片尺寸
        resolveUri(context, uri, options);

        //计算实际缩放比例
        int scale = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if ((options.outWidth / scale > maxWidth &&
                    options.outWidth / scale > maxWidth * 1.4) ||
                    (options.outHeight / scale > maxHeight &&
                            options.outHeight / scale > maxHeight * 1.4)) {
                scale++;
            } else {
                break;
            }
        }

        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;//读取图片内容
        options.inPreferredConfig = Bitmap.Config.RGB_565; //根据情况进行修改
        Bitmap bitmap = null;
        try {
            bitmap = resolveUriForBitmap(context, uri, options);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    private static void resolveUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            return;
        }

        String scheme = uri.getScheme();
        if (ContentResolver.SCHEME_CONTENT.equals(scheme) ||
                ContentResolver.SCHEME_FILE.equals(scheme)) {
            InputStream stream = null;
            try {
                stream = context.getContentResolver().openInputStream(uri);
                BitmapFactory.decodeStream(stream, null, options);
            } catch (Exception e) {
                Log.w("resolveUri", "Unable to open content: " + uri, e);
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        Log.w("resolveUri", "Unable to close content: " + uri, e);
                    }
                }
            }
        } else if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            Log.w("resolveUri", "Unable to close content: " + uri);
        } else {
            Log.w("resolveUri", "Unable to close content: " + uri);
        }
    }

    private static Bitmap resolveUriForBitmap(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            return null;
        }

        Bitmap bitmap = null;
        String scheme = uri.getScheme();
        if (ContentResolver.SCHEME_CONTENT.equals(scheme) ||
                ContentResolver.SCHEME_FILE.equals(scheme)) {
            InputStream stream = null;
            try {
                stream = context.getContentResolver().openInputStream(uri);
                bitmap = BitmapFactory.decodeStream(stream, null, options);
            } catch (Exception e) {
                Log.w("resolveUriForBitmap", "Unable to open content: " + uri, e);
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        Log.w("resolveUriForBitmap", "Unable to close content: " + uri, e);
                    }
                }
            }
        } else if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            Log.w("resolveUriForBitmap", "Unable to close content: " + uri);
        } else {
            Log.w("resolveUriForBitmap", "Unable to close content: " + uri);
        }

        return bitmap;
    }

    public static void scanImg(Context context, Uri uri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                    scanImage(bitmap, context);
                Bitmap bitmap = decodeUri(context, uri, 4000, 4000);
                Log.d("QrCodeScanUtil", "bitmap count : " + bitmap.getByteCount());
                HmsScan[] result = ScanUtil.decodeWithBitmap(context, bitmap, new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScan.ALL_SCAN_TYPE).setPhotoMode(true).create());
                if (result != null && result.length > 0) {
                    Log.d("QrCodeScanUtil", "result: " + result[0].originalValue);
                } else {
                    Log.d("QrCodeScanUtil", "no qrcode retur ");

                }
            }
        });
        thread.start();
//        try {
////            FileInputStream fs = null;
////            fs = new FileInputStream("/sdcard/1/1234.png");
////            fs = new FileInputStream("/sdcard/1/long.jpg");
////            fs = new FileInputStream("/sdcard/1/short.jpg");
////            Bitmap bitmap  = BitmapFactory.decodeStream(fs);
//
////            Uri imageUri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap , null,null));
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
////                    scanImage(bitmap, context);
//                    HmsScan[] result = ScanUtil.decodeWithBitmap(context, bitmap, new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScan.ALL_SCAN_TYPE).setPhotoMode(true).create());
//                    if (result != null) {
//                        Log.d("QrCodeScanUtil", "result: " + result[0].originalValue);
//                    }
//                }
//            });
//            thread.start();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
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
//public static final Bitmap getBitmap(ContentResolver cr, Uri url)
//        throws FileNotFoundException, IOException {
//    InputStream input = cr.openInputStream(url);
//    BitmapFactory.Options options = new BitmapFactory.Options();
//
//    // 设置成了true,不占用内存，只获取bitmap宽高
//    options.inSampleSize = 2;
//    Bitmap bitmap = BitmapFactory.decodeStream(input, null, options);
//    input.close();
//    return bitmap;
//
//    // 初始化options对象
//    BitmapFactory.decodeResource(res, resId, options);
//    // 得到计算好的options，目标宽、目标高
//    options = getBestOptions(options, reqWidth, reqHeight);
//    Bitmap src = BitmapFactory.decodeResource(res, resId, options); // 载入一个稍大的缩略图
//    return createScaleBitmap(src, mDesiredWidth, mDesiredHeight); // 进一步得到目标大小的缩略图
//
//}
//
//
//    private static int mDesiredWidth;
//    private static int mDesiredHeight;
//
//    /**
//     * @description 从Resources中加载图片
//     *
//     * @param res
//     * @param resId
//     * @param reqWidth
//     * @param reqHeight
//     * @return
//     */
//    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        // 设置成了true,不占用内存，只获取bitmap宽高
//        options.inJustDecodeBounds = true;
//        // 初始化options对象
//        BitmapFactory.decodeResource(res, resId, options);
//        // 得到计算好的options，目标宽、目标高
//        options = getBestOptions(options, reqWidth, reqHeight);
//        Bitmap src = BitmapFactory.decodeResource(res, resId, options); // 载入一个稍大的缩略图
//        return createScaleBitmap(src, mDesiredWidth, mDesiredHeight); // 进一步得到目标大小的缩略图
//    }
//
//    /**
//     * @description 从SD卡上加载图片
//     *
//     * @param pathName
//     * @param reqWidth
//     * @param reqHeight
//     * @return
//     */
//    public static Bitmap decodeSampledBitmapFromFile(String pathName, int reqWidth, int reqHeight) {
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(pathName, options);
//        options = getBestOptions(options, reqWidth, reqHeight);
//        Bitmap src = BitmapFactory.decodeFile(pathName, options);
//        return createScaleBitmap(src, mDesiredWidth, mDesiredHeight);
//    }
//
//    /**
//     * @description 计算目标宽度，目标高度，inSampleSize
//     *
//     * @param options
//     * @param reqWidth
//     * @param reqHeight
//     * @return BitmapFactory.Options对象
//     */
//    private static BitmapFactory.Options getBestOptions(BitmapFactory.Options options, int reqWidth, int reqHeight) {
//        // 读取图片长宽
//        int actualWidth = options.outWidth;
//        int actualHeight = options.outHeight;
//        // Then compute the dimensions we would ideally like to decode to.
//        mDesiredWidth = getResizedDimension(reqWidth, reqHeight, actualWidth, actualHeight);
//        mDesiredHeight = getResizedDimension(reqHeight, reqWidth, actualHeight, actualWidth);
//        // 根据现在得到计算inSampleSize
//        options.inSampleSize = calculateBestInSampleSize(actualWidth, actualHeight, mDesiredWidth, mDesiredHeight);
//        // 使用获取到的inSampleSize值再次解析图片
//        options.inJustDecodeBounds = false;
//        return options;
//    }
//
//    /**
//     * Scales one side of a rectangle to fit aspect ratio. 最终得到重新测量的尺寸
//     *
//     * @param maxPrimary
//     *            Maximum size of the primary dimension (i.e. width for max
//     *            width), or zero to maintain aspect ratio with secondary
//     *            dimension
//     * @param maxSecondary
//     *            Maximum size of the secondary dimension, or zero to maintain
//     *            aspect ratio with primary dimension
//     * @param actualPrimary
//     *            Actual size of the primary dimension
//     * @param actualSecondary
//     *            Actual size of the secondary dimension
//     */
//    private static int getResizedDimension(int maxPrimary, int maxSecondary, int actualPrimary, int actualSecondary) {
//        double ratio = (double) actualSecondary / (double) actualPrimary;
//        int resized = maxPrimary;
//        if (resized * ratio > maxSecondary) {
//            resized = (int) (maxSecondary / ratio);
//        }
//        return resized;
//    }
//
//    /**
//     * Returns the largest power-of-two divisor for use in downscaling a bitmap
//     * that will not result in the scaling past the desired dimensions.
//     *
//     * @param actualWidth
//     *            Actual width of the bitmap
//     * @param actualHeight
//     *            Actual height of the bitmap
//     * @param desiredWidth
//     *            Desired width of the bitmap
//     * @param desiredHeight
//     *            Desired height of the bitmap
//     */
//    // Visible for testing.
//    private static int calculateBestInSampleSize(int actualWidth, int actualHeight, int desiredWidth, int desiredHeight) {
//        double wr = (double) actualWidth / desiredWidth;
//        double hr = (double) actualHeight / desiredHeight;
//        double ratio = Math.min(wr, hr);
//        float inSampleSize = 1.0f;
//        while ((inSampleSize * 2) <= ratio) {
//            inSampleSize *= 2;
//        }
//
//        return (int) inSampleSize;
//    }
//
//    /**
//     * @description 通过传入的bitmap，进行压缩，得到符合标准的bitmap
//     *
//     * @param src
//     * @param dstWidth
//     * @param dstHeight
//     * @return
//     */
//    private static Bitmap createScaleBitmap(Bitmap tempBitmap, int desiredWidth, int desiredHeight) {
//        // If necessary, scale down to the maximal acceptable size.
//        if (tempBitmap != null && (tempBitmap.getWidth() > desiredWidth || tempBitmap.getHeight() > desiredHeight)) {
//            // 如果是放大图片，filter决定是否平滑，如果是缩小图片，filter无影响
//            Bitmap bitmap = Bitmap.createScaledBitmap(tempBitmap, desiredWidth, desiredHeight, true);
//            tempBitmap.recycle(); // 释放Bitmap的native像素数组
//            return bitmap;
//        } else {
//            return tempBitmap; // 如果没有缩放，那么不回收
//        }
//    }
}
