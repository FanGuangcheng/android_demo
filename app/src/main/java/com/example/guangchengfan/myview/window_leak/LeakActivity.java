package com.example.guangchengfan.myview.window_leak;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.guangchengfan.myview.R;

public class LeakActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        new MyThread().start();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.d("tag", "leak test");
            }
        }
    };
}
