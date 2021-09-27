package com.example.guangchengfan.myview.textview;

import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guangchengfan.myview.R;

public class TextviewActivity extends AppCompatActivity {
    private static final int TV_TIPS_WIDHT = 220;
    private static final int TV_TIPS_RECOM_WIDTH = 200;

    TextView tvTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        tvTips = (TextView)findViewById(R.id.tv_tips);

        Log.d("TextviewActivity", "1: " + getJustifyStr("最新拼团订单来自济宁市的mama_1F0Q1E849", tvTips));
        Log.d("TextviewActivity", "2: " + getJustifyStr("最新拼团订单来自连云港市的曦潇研", tvTips));
        Log.d("TextviewActivity", "3: " + getJustifyStr("最新拼团订单来自菏泽市的     心软是病", tvTips));
        Log.d("TextviewActivity", "4: " + getJustifyStr("最新拼团订单来自北京市的mama_1CCR8635", tvTips));
        Log.d("TextviewActivity", "5: " + getJustifyStr("最新拼团订单来自济南市的12345大猫", tvTips));
        Log.d("TextviewActivity", "6: " + getJustifyStr("最新拼团订单来自铜仁市的宇妈_33", tvTips));
        Log.d("TextviewActivity", "7: " + getJustifyStr("最新拼团订单来自郴州市的mama_21FOIF", tvTips));
        Log.d("TextviewActivity", "8: " + getJustifyStr("最新拼团订单来自北京市的肆意的贪婪丶只因你宠爱", tvTips));

    }

    private String getJustifyStr(String str, TextView tv) {
        if (TextUtils.isEmpty(str) || tv == null)
            return null;

        if (!containLetter(str)) {
            Log.d("TextviewActivity", "no letter  " + str);
            return str;
        }

        if (getTextWith(str, tv) < dip2px(TV_TIPS_WIDHT))
            return str;

        String tempStr;
        for (int i = 0, length = str.length(); i < length; i++) {
            tempStr = str.substring(0, i);
            float tempWidht = getTextWith(tempStr, tv);
            if (tempWidht >= dip2px(TV_TIPS_RECOM_WIDTH) && tempWidht < dip2px(TV_TIPS_WIDHT))
                return tempStr + " " + str.substring(i);
        }

        return str;

    }

    //获取content在textview中的宽度
    public float getTextWith(String content, TextView textView) {
        TextPaint paint = textView.getPaint();
        return Layout.getDesiredWidth(content, paint);
    }

    public int dip2px(float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private boolean containLetter(String str) {
        if (TextUtils.isEmpty(str))
            return false;

        for (int i = 0, length = str.length(); i < length; i++) {
            if (isLetter((int)str.charAt(i)))
                return true;
        }

        return false;
    }

    private boolean isLetter(int c) {
        if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return true;
        }

        return false;
    }
}
