package com.example.guangchengfan.myview.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guangchengfan.myview.R;

/**
 * Created by guangcheng.fan on 2016/4/19.
 */
public class TestViewPagerFragment extends Fragment {
    private static final String TAG ="TestViewPagerFragment";
    private String hello;
    private static final String DEFAULT_HELLO = "default hello!";

    static TestViewPagerFragment newInstance(String str) {
        TestViewPagerFragment newFragment = new TestViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hello", str);
        newFragment.setArguments(bundle);

        return newFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "TestViewPagerFragment -- onCreateView");
        Bundle args = getArguments();
        hello = args == null ? DEFAULT_HELLO : args.getString("hello");
        View view = inflater.inflate(R.layout.test_fragment, container, false);
        TextView tv = (TextView)view.findViewById(R.id.tv);
        tv.setText(hello);
        return view;
    }
}
