package com.example.guangchengfan.myview.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.guangchengfan.myview.R;
import com.example.guangchengfan.myview.fragment.Fragment1;
import com.example.guangchengfan.myview.fragment.Fragment2;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        setTitle("代码动态添加的");
        Display display = getWindowManager().getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            Fragment1 fragment1 = new Fragment1();
            getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit();
        } else {
            Fragment2 fragment2 = new Fragment2();
            getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commit();
        }
    }
}
