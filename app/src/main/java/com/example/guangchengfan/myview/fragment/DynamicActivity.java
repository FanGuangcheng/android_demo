package com.example.guangchengfan.myview.fragment;

import android.os.Bundle;
import android.view.Display;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guangchengfan.myview.R;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        setTitle("代码动态添加的");
        Display display = getWindowManager().getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            Fragment1 fragment1 = new Fragment1();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit();
        } else {
            Fragment2 fragment2 = new Fragment2();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commit();
        }
    }
}
