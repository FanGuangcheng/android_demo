package com.example.guangchengfan.myview;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class DivActivty extends Activity {

    TextView mTv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_activty);

        mTv_result = (TextView)findViewById(R.id.tv_result);

        setDivResult();
    }

    private void setDivResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n243438/10000 = ");
        BigDecimal b   =   new   BigDecimal((double)243438/10000);
        double   f1   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
        sb.append(f1);

        sb.append("\n243538/10000 = ");
        b   =   new   BigDecimal((double)243538/10000);
        f1   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
        sb.append(f1);

        sb.append("\n43538/10000 = ");
        b   =   new   BigDecimal((double)43538/10000);
        f1   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
        sb.append(f1);

        sb.append("\n10538/10000 = ");
        b   =   new   BigDecimal((double)10538/10000);
        f1   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
        sb.append(f1);

        sb.append("\n10038/10000 = ");
        b   =   new   BigDecimal((double)10038/10000);
        f1   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
        sb.append(f1);

        sb.append("\n119638/10000 = ");
        b   =   new   BigDecimal((double)119638/10000);
        f1   =   b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
        sb.append(f1);

        mTv_result.setText(sb.toString());
    }
}
