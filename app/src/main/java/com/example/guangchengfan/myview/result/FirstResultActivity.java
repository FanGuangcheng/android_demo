package com.example.guangchengfan.myview.result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guangchengfan.myview.R;

public class FirstResultActivity extends Activity implements View.OnClickListener {
    public static final String ACTIVITY_RESULT_TAG = "activity_result_tag";
    private static final int REQUEST_CODE = 1;
    Button btn_activity_for_result;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_result);

        tv_result = (TextView) findViewById(R.id.tv_result);
        btn_activity_for_result = (Button) findViewById(R.id.btn_activity_for_result);
        btn_activity_for_result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity_for_result:
                startActivityForResult();
                break;
            default:
                break;
        }
    }

    private void startActivityForResult() {
        Intent intent = new Intent();
        intent.setClass(this, SecondResultActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(ACTIVITY_RESULT_TAG, "FirstResultActivity onActivityResult");
        switch (requestCode) {
            case REQUEST_CODE:
                if (data == null || data.getExtras() == null)
                    return;

                String moment_id = data.getExtras().getString("moment_id");
                String price = data.getExtras().getString("price");
                tv_result.setText("moment_id : " + moment_id + "  price: " + price);
                break;
            default:
                break;
        }
    }
}
