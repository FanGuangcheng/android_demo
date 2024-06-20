package com.example.guangchengfan.myview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * 解决Webview在ViewPager中滑动冲突的问题
 * https://blog.csdn.net/weixin_40855673/article/details/123618532
 * 另外，有些H5页面，无法正常加载的问题：https://ih5.cztv.com/batrix-h5/h5/songyun/#/
 * BrowserWebview逻辑太多，因此未改动相关代码，单独抽离出来
 */
public class ZmgCustomWebView extends WebView {

    public ZmgCustomWebView(Context context) {
        super(context);
    }

    public ZmgCustomWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){
            super.requestDisallowInterceptTouchEvent(true);
        }else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() ==MotionEvent.ACTION_CANCEL){
            super.requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        if (clampedX || clampedY){
            super.requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }
}
