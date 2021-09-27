package com.example.guangchengfan.myview.tabhost.fragment;

import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guangchengfan.myview.R;

/**
 * Created by guangcheng.fan on 2016/4/6.
 */
public class MessageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_layout, container, false);
    }
}
