package com.example.guangchengfan.myview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guangchengfan.myview.animation.AnimActivity;
import com.example.guangchengfan.myview.life.DynamicLifeActivity;
import com.example.guangchengfan.myview.life.StaticLifeActivity;
import com.example.guangchengfan.myview.recycleview.RecycleActivity;
import com.example.guangchengfan.myview.result.FirstResultActivity;
import com.example.guangchengfan.myview.show_dialog.ShowDialogActivity;
import com.example.guangchengfan.myview.tabhost.TabHostActivity;
import com.example.guangchengfan.myview.viewpager.ViewPagerActivity;
import com.example.guangchengfan.myview.window_leak.LeakActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_static;
    Button btn_dynamic;
    Button btn_tabhost;
    Button btn_dynamic_life_add;
    Button btn_dynamic_life_replace;
    Button btn_static_life;
    Button btn_viewpager;
    Button btn_start_for_result;
    Button btn_start_leak_activity;
    Button btn_start_show_dialog_activity;
    Button btn_start_anim_activity;
    Button btn_start_div_activity;
    Button btn_start_recycle_view_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_static = (Button) findViewById(R.id.btn_static);
        btn_static.setOnClickListener(this);
        btn_dynamic = (Button) findViewById(R.id.btn_dynamic);
        btn_dynamic.setOnClickListener(this);
        btn_tabhost = (Button) findViewById(R.id.btn_tabhost);
        btn_tabhost.setOnClickListener(this);
        btn_dynamic_life_add = (Button) findViewById(R.id.btn_dynamic_life_add);
        btn_dynamic_life_add.setOnClickListener(this);
        btn_dynamic_life_replace = (Button) findViewById(R.id.btn_dynamic_life_replace);
        btn_dynamic_life_replace.setOnClickListener(this);
        btn_static_life = (Button) findViewById(R.id.btn_static_life);
        btn_static_life.setOnClickListener(this);
        btn_viewpager = (Button) findViewById(R.id.btn_viewpager);
        btn_viewpager.setOnClickListener(this);
        btn_start_for_result = (Button) findViewById(R.id.btn_start_for_result);
        btn_start_for_result.setOnClickListener(this);
        btn_start_leak_activity = (Button) findViewById(R.id.btn_start_leak_activity);
        btn_start_leak_activity.setOnClickListener(this);
        btn_start_show_dialog_activity = (Button) findViewById(R.id.btn_start_show_dialog_activity);
        btn_start_show_dialog_activity.setOnClickListener(this);
        btn_start_anim_activity = (Button) findViewById(R.id.btn_start_anim_activity);
        btn_start_anim_activity.setOnClickListener(this);
        btn_start_div_activity = (Button) findViewById(R.id.btn_start_div_activity);
        btn_start_div_activity.setOnClickListener(this);
        btn_start_recycle_view_activity = (Button) findViewById(R.id.btn_start_recycle_view_activity);
        btn_start_recycle_view_activity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_static:
                startStaticActivity();
                break;
            case R.id.btn_dynamic:
                startDynamicActivity();
                break;
            case R.id.btn_tabhost:
                startTabHostActivity();
                break;
            case R.id.btn_dynamic_life_add:
                startDynamicLifeActivity(true);
                break;
            case R.id.btn_dynamic_life_replace:
                startDynamicLifeActivity(false);
                break;
            case R.id.btn_static_life:
                startStaticLifeActivity();
                break;
            case R.id.btn_viewpager:
                startViewPagerActivity();
                break;
            case R.id.btn_start_for_result:
                startResultActivityTest();
                break;
            case R.id.btn_start_leak_activity:
                startLeakActivity();
                break;
            case R.id.btn_start_show_dialog_activity:
                startShowDialogActivity();
                break;
            case R.id.btn_start_anim_activity:
                startAnimActivity();
                break;
            case R.id.btn_start_div_activity:
                startDivActivty();
                break;
            case R.id.btn_start_recycle_view_activity:
                startRecycleViewActivty();
                break;
            default:
                break;
        }
    }

    private void startStaticActivity() {
        Intent intent = new Intent();
        intent.setClass(this, StaticActivity.class);
        startActivity(intent);
    }

    private void startDynamicActivity() {
        Intent intent = new Intent();
        intent.setClass(this, DynamicActivity.class);
        startActivity(intent);
    }

    private void startTabHostActivity() {
        Intent intent = new Intent();
        intent.setClass(this, TabHostActivity.class);
        startActivity(intent);
    }

    public static final String IS_ADD_FRAGMENT = "is_add_frament";
    private void startDynamicLifeActivity(boolean isAdd) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_ADD_FRAGMENT, isAdd);
        intent.putExtras(bundle);
        intent.setClass(this, DynamicLifeActivity.class);
        startActivity(intent);
    }

    private void startStaticLifeActivity() {
        Intent intent = new Intent();
        intent.setClass(this, StaticLifeActivity.class);
        startActivity(intent);
    }

    private void startViewPagerActivity() {
        Intent intent = new Intent();
        intent.setClass(this, ViewPagerActivity.class);
        startActivity(intent);
    }

    private void startResultActivityTest() {
        Intent intent = new Intent();
        intent.setClass(this, FirstResultActivity.class);
        startActivity(intent);
    }

    private void startLeakActivity() {
        Intent intent = new Intent();
        intent.setClass(this, LeakActivity.class);
        startActivity(intent);
    }

    private void startShowDialogActivity() {
        Intent intent = new Intent();
        intent.setClass(this, ShowDialogActivity.class);
        startActivity(intent);
    }

    private void startAnimActivity() {
        Intent intent = new Intent();
        intent.setClass(this, AnimActivity.class);
        startActivity(intent);
    }

    private void startDivActivty() {
        Intent intent = new Intent();
        intent.setClass(this, DivActivty.class);
        startActivity(intent);
    }

    private void startRecycleViewActivty() {
        Intent intent = new Intent();
        intent.setClass(this, RecycleActivity.class);
        startActivity(intent);
    }
}
