package com.example.guangchengfan.myview.result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.guangchengfan.myview.R;

public class SecondResultActivity extends Activity implements View.OnClickListener {
    Button btn_back_to_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_result);

        btn_back_to_first = (Button) findViewById(R.id.btn_back_to_first);
        btn_back_to_first.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_to_first:
                Intent intent = new Intent();
                intent.putExtra("moment_id", "1234");
                intent.putExtra("price", "14.54");
                setResult(RESULT_OK, intent);
                Log.e(FirstResultActivity.ACTIVITY_RESULT_TAG, "SecondResultActivity finish before ");
                finish();
                Log.e(FirstResultActivity.ACTIVITY_RESULT_TAG, "SecondResultActivity finish after");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(FirstResultActivity.ACTIVITY_RESULT_TAG, "SecondResultActivity onDestroy");
        super.onDestroy();
    }
}
