package com.example.guangchengfan.myview.customview.hotLabel;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;

public class HotLabelActivity extends Activity implements View.OnClickListener{

    Button btn_simple_flow_layout;
    Button btn_second_flow_layout;

    private String mNames[] = {
            "welcome","android","TextView",
            "apple","jamy","kobe bryant",
            "jordan","layout","viewgroup",
            "margin","padding","text",
            "name","type","search","logcat"
    };

    private SimpleFlowLayout mSimpleFlowLayout;
    private FlowLayout mSecondFlowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_label);

        btn_simple_flow_layout = (Button)findViewById(R.id.btn_simple_flow_layout);
        btn_simple_flow_layout.setOnClickListener(this);
        btn_second_flow_layout = (Button)findViewById(R.id.btn_second_flow_layout);
        btn_second_flow_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple_flow_layout:
                initChildViews();
                break;
            case R.id.btn_second_flow_layout:
                initSecondChildViews();
                break;
            default:
                break;
        }
    }

    private void initChildViews() {
        // TODO Auto-generated method stub
        mSecondFlowLayout = (FlowLayout) findViewById(R.id.second_flow_layout);
        mSecondFlowLayout.setVisibility(View.VISIBLE);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for(int i = 0; i < mNames.length; i ++){
            final TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(HotLabelActivity.this, "文字是 " + view.getText(), Toast.LENGTH_LONG).show();
                }
            });
            mSecondFlowLayout.addView(view,lp);
        }
    }

    private void initSecondChildViews() {
        // TODO Auto-generated method stub
        mSimpleFlowLayout = (SimpleFlowLayout) findViewById(R.id.simple_flow_layout);
        mSimpleFlowLayout.setVisibility(View.VISIBLE);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for(int i = 0; i < mNames.length; i ++){
            final TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(HotLabelActivity.this, "second 文字是 " + view.getText(), Toast.LENGTH_LONG).show();
                }
            });
            mSimpleFlowLayout.addView(view,lp);
        }
    }
}
