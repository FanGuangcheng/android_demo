package com.example.guangchengfan.myview.imageload;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.guangchengfan.myview.R;

public class LoadBigImgActivity extends Activity {

    ImageView iv_big_img;
    TextView tv_load_img;
    @Override
    protected void onCreate(@Nullable @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_big_img);
        iv_big_img = (ImageView) findViewById(R.id.iv_big_img);
        tv_load_img = findViewById(R.id.tv_load_img);
        tv_load_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(LoadBigImgActivity.this).load(R.drawable.ic_main_bar0).into(iv_big_img);
//                int size = dip2px(LoadBigImgActivity.this, 200f);
//                Glide.with(LoadBigImgActivity.this).load(R.drawable.test_middle_img).override(size, size).into(iv_big_img);

//                iv_big_img.setImageDrawable(getDrawable(R.drawable.ic_main_bar0));
            }
        });
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
