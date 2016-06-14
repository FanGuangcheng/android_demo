package com.example.guangchengfan.myview.pop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;

public class PopupWindowsActivity extends Activity implements OnClickListener {

    Button om,om1;
    private PopupWindow mPopupWindow;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_windows);
        mContext = this;

        om = (Button) findViewById(R.id.om);
        om.setOnClickListener(this);
        om1 = (Button) findViewById(R.id.om1);
        om1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.om) {
            showPopWindow();
        }else
        if (v.getId() == R.id.om1) {
            dismiss();
        }
    }


    public void dismiss() {
        Log.d("PopWin", "dismiss");
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
            mPopupWindow = null;
            Log.d("PopWin", "dismiss ok");
        }
    }

    TextView tv_showText = null;
    ImageView in1 = null;
    ImageView in2 = null;
    TextView tv = null;
    TextView tv1 = null;

    private void showPopWindow(){
        dismiss();
        View foot_popunwindwow = null;

        LayoutInflater LayoutInflater = (LayoutInflater) mContext
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        foot_popunwindwow = LayoutInflater
                .inflate(R.layout.foot_map_view, null);

        mPopupWindow = new PopupWindow(foot_popunwindwow,
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
//        mPopupWindow.setAnimationStyle(R.style.WindowAnimation);
        mPopupWindow.showAtLocation(this.findViewById(R.id.layout),
                Gravity.LEFT | Gravity.TOP, 100, 200);
//        mPopupWindow.update();
        in1 = (ImageView) foot_popunwindwow.findViewById(R.id.in1);
        in2 = (ImageView) foot_popunwindwow.findViewById(R.id.in2);
        tv = (TextView) foot_popunwindwow.findViewById(R.id.text1);

        tv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "text1", Toast.LENGTH_SHORT).show();
            }
        });
        in1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "in1", Toast.LENGTH_SHORT).show();
            }
        });
        in2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "in2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}