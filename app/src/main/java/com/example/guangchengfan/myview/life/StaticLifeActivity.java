package com.example.guangchengfan.myview.life;

import android.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guangchengfan.myview.R;

public class StaticLifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifeFragment.TAG, "StaticLifeActivity onCreate");
        setContentView(R.layout.activity_static_life);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifeFragment.TAG, "StaticLifeActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifeFragment.TAG, "StaticLifeActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifeFragment.TAG, "StaticLifeActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifeFragment.TAG, "StaticLifeActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifeFragment.TAG, "StaticLifeActivity onDestroy");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d(LifeFragment.TAG, "StaticLifeActivity onAttachFragment");
    }
}
