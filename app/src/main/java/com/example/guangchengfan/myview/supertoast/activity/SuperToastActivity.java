package com.example.guangchengfan.myview.supertoast.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guangchengfan.myview.R;
import com.example.guangchengfan.myview.supertoast.util.ToastHelper;

public class SuperToastActivity extends AppCompatActivity {

    Button btn_show_super_toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_toast);

        btn_show_super_toast = (Button)findViewById(R.id.btn_show_super_toast);
        btn_show_super_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastHelper.makeText(SuperToastActivity.this, "hello world 你好，哈拉雷速度发说得对",
                                ToastHelper.LENGTH_SHORT).setAnimation(R.style.PopToast).show();
            }
        });
    }
}
