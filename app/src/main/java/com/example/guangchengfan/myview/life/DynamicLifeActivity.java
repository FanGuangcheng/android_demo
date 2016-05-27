package com.example.guangchengfan.myview.life;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.guangchengfan.myview.MainActivity;
import com.example.guangchengfan.myview.R;

public class DynamicLifeActivity extends Activity {
    public TextView mTv_dynamic_tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        mTv_dynamic_tips = (TextView)findViewById(R.id.tv_dynamic_tips);

        Intent intent  = getIntent();
        boolean isAdd = true;
        if (intent != null && intent.getExtras() != null)
            isAdd = intent.getExtras().getBoolean(MainActivity.IS_ADD_FRAGMENT, true);
        LifeFragment lifeFragment = new LifeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", 111);
        lifeFragment.setArguments(bundle);
        if (isAdd) {
            getFragmentManager().beginTransaction().add(R.id.main_container, lifeFragment, "life_fragment").commit();
        } else {
            getFragmentManager().beginTransaction().replace(R.id.main_container, lifeFragment, "life_fragment").commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onDestroy");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d(LifeFragment.TAG, "DynamicLifeActivity onAttachFragment");
    }

}
