package com.example.guangchengfan.myview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.guangchengfan.myview.R

/**
 *  Android 关于Activity的销毁和重建
 *  https://www.jianshu.com/p/067209fd887d
 */
class RestoreActivity : AppCompatActivity() {
    private val TAG = "RestoreActivity"
    private val TIME_STAMP = "time_stamp"
    private var timeStamp: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore)
        if (savedInstanceState == null) {
            timeStamp = System.currentTimeMillis().toString()
        } else {
            timeStamp = "-1"
        }
        Log.d(TAG,"onCreate: " + timeStamp)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart: " + timeStamp)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState: " + timeStamp)
        outState?.putString(TIME_STAMP, timeStamp)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        timeStamp = savedInstanceState?.getString(TIME_STAMP)
        Log.d(TAG,"onRestoreInstanceState: " + timeStamp)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause: " + timeStamp)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop: " + timeStamp)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy: " + timeStamp)
    }
}