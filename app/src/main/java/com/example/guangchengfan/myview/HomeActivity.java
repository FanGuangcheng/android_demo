package com.example.guangchengfan.myview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_old_main_activity;
    Button btn_2021_main_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_2021_main_activity = findViewById(R.id.btn_2021_main_activity);
        btn_2021_main_activity.setOnClickListener(this);

        btn_old_main_activity = findViewById(R.id.btn_old_main_activity);
        btn_old_main_activity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_2021_main_activity:
                startTargetActivity(MainActivity2021.class);
                break;
            case R.id.btn_old_main_activity:
                startTargetActivity(OldMainActivity.class);
                break;
        }
    }

    private void startTargetActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
}