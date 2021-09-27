package com.example.guangchengfan.myview.viewpager;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.guangchengfan.myview.R;

/**
 * Created by guangcheng.fan on 2016/4/19.
 */
public class ButtonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.button_fragment_layout, container, false);
        Button btn_click = (Button)rootView.findViewById(R.id.mybutton);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ButtonFragment button onclick!!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d("ButtonFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ButtonFragment", "onDestroy");
    }
}
