package com.example.guangchengfan.myview.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPager2Adapter extends FragmentStateAdapter {

    public MyPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 返回一个新实例的 Fragment
        return new MyPage2Fragment();
    }

    @Override
    public int getItemCount() {
        // 返回页面的数量
        return 12;
    }
}
