package com.example.guangchengfan.myview.viewpager;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mPager;
    private ArrayList<Fragment> fragmentArrayList;
    private ImageView image;
    private int curIndex;
    private int bmpW;
    private int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        initTextView();
        initImageView();
        initViewPager();
    }

    private void initTextView() {
        ((TextView)findViewById(R.id.tv_guid1)).setOnClickListener(new txListener(0));
        ((TextView)findViewById(R.id.tv_guid2)).setOnClickListener(new txListener(1));
        ((TextView)findViewById(R.id.tv_guid3)).setOnClickListener(new txListener(2));
        ((TextView)findViewById(R.id.tv_guid4)).setOnClickListener(new txListener(3));

    }

    public class txListener implements View.OnClickListener{
        private int index;

        public txListener(int i){
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }

    private void initImageView() {
        image = (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.cursor).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 4 - bmpW) / 2;

        //imageview 设置平移，使下划线平移到初始位置，（平移一个offset
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        image.setImageMatrix(matrix);
    }

    public void initViewPager() {
        mPager = (ViewPager)findViewById(R.id.viewpager);
        fragmentArrayList = new ArrayList<Fragment>();
        Fragment btnFragment = new ButtonFragment();
        Fragment second = TestViewPagerFragment.newInstance("second fragment");
        Fragment third = TestViewPagerFragment.newInstance("third fragment");
        Fragment fourth = TestViewPagerFragment.newInstance("fourth fragment");
        fragmentArrayList.add(btnFragment);
        fragmentArrayList.add(second);
        fragmentArrayList.add(third);
        fragmentArrayList.add(fourth);

        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentArrayList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        private int distance = offset * 2 + bmpW;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Animation animation = new TranslateAnimation(curIndex * distance, position * distance, 0, 0);

            curIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(150);
            image.startAnimation(animation);

            int i = curIndex + 1;
            Log.d("ViewPagerActivity", "当前是" + i + "页面");
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
