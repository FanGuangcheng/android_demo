package com.example.guangchengfan.myview.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by guangcheng.fan on 2016/4/19.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mList;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

}
