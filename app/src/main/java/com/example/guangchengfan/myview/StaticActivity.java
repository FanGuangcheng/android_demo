package com.example.guangchengfan.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("静态布局文件添加的Fragment");
        setContentView(R.layout.activity_static);
    }
}
