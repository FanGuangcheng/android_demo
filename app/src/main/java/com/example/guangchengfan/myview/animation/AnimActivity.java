package com.example.guangchengfan.myview.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.guangchengfan.myview.R;

public class AnimActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn_start_anim;
    private View mPopupWindowView;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        btn_start_anim = (Button)findViewById(R.id.btn_start_anim);
        btn_start_anim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_anim:
                startPopupWindow();
                break;
            case R.id.brand_filter_btn_done:
                dismissPopupWindow();
                break;
            default:
                break;
        }
    }


    Button brand_filter_btn_done;
    private void startPopupWindow() {
        mPopupWindowView = LayoutInflater.from(this).inflate(R.layout.pupup_window_layout, null);

        popupWindow = new PopupWindow(mPopupWindowView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout rl = (RelativeLayout) mPopupWindowView.findViewById(R.id.rl_pop_container);
        //setClippingEnabled(true);
//        popupWindow.setAnimationStyle(R.style.BrandWindowAnimation);//
        popupWindow.showAsDropDown(btn_start_anim);
//        Animation animation= AnimationUtils.loadAnimation(this, R.anim.martshow_brand_push_top_in);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation arg0) {}   //在动画开始时使用
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {}  //在动画重复时使用
//
//            @Override
//            public void onAnimationEnd(Animation arg0) {
//            }
//        });
//        rl.startAnimation(animation);


//        popupWindow.setAnimationStyle(R.style.BrandWindowAnimation);//
        brand_filter_btn_done = (Button)mPopupWindowView.findViewById(R.id.brand_filter_btn_done);
        brand_filter_btn_done.setOnClickListener(this);

    }

    private void dismissPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();
    }
}
