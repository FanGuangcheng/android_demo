package com.example.guangchengfan.myview.tabhost;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;
import com.example.guangchengfan.myview.tabhost.fragment.ContactsFragment;
import com.example.guangchengfan.myview.tabhost.fragment.MessageFragment;
import com.example.guangchengfan.myview.tabhost.fragment.NewsFragment;
import com.example.guangchengfan.myview.tabhost.fragment.SettingFragment;

import org.w3c.dom.Text;

/**
 * 所有的tabhost相关的Fragment都嵌在这里
 */

public class TabHostActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "TabHostActivity";

    //展示消息
    MessageFragment mMessageFragment;

    //展示联系人
    ContactsFragment mContactsFragment;

    //展示动态
    NewsFragment mNewsFragment;

    //展示设置
    SettingFragment mSettingFragment;

    //消息界面布局
    private View mMessageLayout;

    //联系人界面布局
    private View mContactsLayout;

    //动态界面布局
    private View mNewsLayout;

    //设置界面布局
    private View mSettingLayout;

    //在tab布局中显示消息图标控件
    private ImageView mMessageImage;

    //在tab布局中显示联系人图标控件
    private ImageView mContactsImage;

    //在tab布局中显示动态图标控件
    private ImageView mNewsImage;

    //在tab布局中显示设置图标控件
    private ImageView mSettingImage;

    //在tab布局中显示消息文字的控件
    private TextView mMessageText;

    //在tab布局中显示联系人文字的控件
    private TextView mContactsText;

    //在tab布局中显示动态文字的控件
    private TextView mNewsText;

    //在tab布局中显示设置文字的控件
    private TextView mSettingText;

    //对Fragment进行管理
    private FragmentManager mFragmentManager;

    //当前Fragment页面的次序
    private int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab_host);

        //初始化布局元素
        initViews();
        mFragmentManager = getFragmentManager();
        mIndex = 0;
        setTabSelection(mIndex);
    }

    private void initViews() {
        mMessageLayout = findViewById(R.id.message_layout);
        mContactsLayout = findViewById(R.id.contacts_layout);
        mNewsLayout = findViewById(R.id.news_layout);
        mSettingLayout = findViewById(R.id.setting_layout);

        mMessageImage = (ImageView)findViewById(R.id.message_image);
        mContactsImage = (ImageView)findViewById(R.id.contacts_image);
        mNewsImage = (ImageView)findViewById(R.id.news_image);
        mSettingImage = (ImageView)findViewById(R.id.setting_image);

        mMessageText = (TextView)findViewById(R.id.message_text);
        mContactsText = (TextView)findViewById(R.id.contacts_text);
        mNewsText = (TextView)findViewById(R.id.news_text);
        mSettingText = (TextView)findViewById(R.id.setting_text);
        mMessageLayout.setOnClickListener(this);
        mContactsLayout.setOnClickListener(this);
        mNewsLayout.setOnClickListener(this);
        mSettingLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                mIndex = 0;
                break;
            case R.id.contacts_layout:
                mIndex = 1;
                break;
            case R.id.news_layout:
                mIndex = 2;
                break;
            case R.id.setting_layout:
                mIndex = 3;
                break;
        }
        setTabSelection(mIndex);
    }

    private void setTabSelection(int index) {
        clearSelection();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);

        switch (index) {
            case 0:
                mMessageImage.setImageResource(R.drawable.message_selected);
                mMessageText.setTextColor(Color.WHITE);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    transaction.add(R.id.content, mMessageFragment);
                } else {
                    transaction.show(mMessageFragment);
                }
                break;
            case 1:
                mContactsImage.setImageResource(R.drawable.contacts_selected);
                mContactsText.setTextColor(Color.WHITE);
                if (mContactsFragment == null) {
                    mContactsFragment = new ContactsFragment();
                    transaction.add(R.id.content, mContactsFragment);
                } else {
                    transaction.show(mContactsFragment);
                }
                break;
            case 2:
                mNewsImage.setImageResource(R.drawable.news_selected);
                mNewsText.setTextColor(Color.WHITE);
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.content, mNewsFragment);
                } else {
                    transaction.show(mNewsFragment);
                }
                break;
            case 3:
                mSettingImage.setImageResource(R.drawable.setting_selected);
                mSettingText.setTextColor(Color.WHITE);
                if (mSettingFragment == null) {
                    mSettingFragment = new SettingFragment();
                    transaction.add(R.id.content, mSettingFragment);
                } else {
                    transaction.show(mSettingFragment);
                }
                break;
            default:
                break;
        }

        transaction.commit();
    }

    //清除所有选中状态
    private void clearSelection() {
        mMessageImage.setImageResource(R.drawable.message_unselected);
        mMessageText.setTextColor(Color.parseColor("#82858b"));
        mContactsImage.setImageResource(R.drawable.contacts_unselected);
        mContactsText.setTextColor(Color.parseColor("#82858b"));
        mNewsImage.setImageResource(R.drawable.news_unselected);
        mNewsText.setTextColor(Color.parseColor("#82858b"));
        mSettingImage.setImageResource(R.drawable.setting_unselected);
        mSettingText.setTextColor(Color.parseColor("#82858b"));
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }

        if (mContactsFragment != null) {
            transaction.hide(mContactsFragment);
        }

        if (mNewsFragment != null) {
            transaction.hide(mNewsFragment);
        }

        if (mSettingFragment != null) {
            transaction.hide(mSettingFragment);
        }
    }

    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();
            float deltX = Math.abs(x2 - x1);
            float deltY = Math.abs(y2 - y1);
            if (deltX > deltY) {
                if(x1 - x2 > 50) {
                    Toast.makeText(TabHostActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
                    mIndex++;
                    if (mIndex > 3)
                        mIndex = 3;
                    setTabSelection(mIndex);
                    Log.d(TAG, "向左滑");
                } else if(x2 - x1 > 50) {
                    Toast.makeText(TabHostActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
                    mIndex--;
                    if (mIndex < 0)
                        mIndex = 0;
                    setTabSelection(mIndex);
                    Log.d(TAG, "向右滑");
                }
            } else {
                if(y1 - y2 > 50) {
                    Toast.makeText(TabHostActivity.this, "", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "向上滑");
                } else if(y2 - y1 > 50) {
                    Toast.makeText(TabHostActivity.this, "", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "向下滑");
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
