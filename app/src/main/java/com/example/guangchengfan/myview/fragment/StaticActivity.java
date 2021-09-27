package com.example.guangchengfan.myview.fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guangchengfan.myview.R;

public class StaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("静态布局文件添加的Fragment");
        setContentView(R.layout.activity_static);
    }
}
