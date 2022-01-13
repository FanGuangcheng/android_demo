package com.example.guangchengfan.myview.textview;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

/**
 * @author :fgc
 * @date :2022/1/13
 */
public class TextviewUtil {

    public static void setCustomText(CharSequence text, TextView textView) {
        if (text == null || textView == null) {
            return;
        }

        // 获得视觉定义的每行文字的行高
        int lineHeight = (int) textView.getTextSize();

        SpannableStringBuilder ssb ;
        if (text instanceof SpannableStringBuilder) {
            ssb = (SpannableStringBuilder) text;
            // 设置LineHeightSpan
            ssb.setSpan(new ExcludeInnerLineSpaceSpan(lineHeight),
                    0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            ssb = new SpannableStringBuilder(text);
            // 设置LineHeightSpan
            ssb.setSpan(new ExcludeInnerLineSpaceSpan(lineHeight),
                    0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // 调用系统setText()方法
        textView.setText(ssb);
    }
}
