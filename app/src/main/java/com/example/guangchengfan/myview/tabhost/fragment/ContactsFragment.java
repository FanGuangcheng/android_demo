package com.example.guangchengfan.myview.tabhost.fragment;

import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;

/**
 * Created by guangcheng.fan on 2016/4/6.
 */
public class ContactsFragment extends Fragment {
    private ImageView mContactsImg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_layout, container, false);
        mContactsImg = (ImageView)view.findViewById(R.id.contacts_image);
        mContactsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "点击了联系人image", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
