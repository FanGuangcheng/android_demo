package com.example.guangchengfan.myview.life;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guangchengfan.myview.R;

/**
 * Created by guangcheng.fan on 2016/4/19.
 */
public class LifeFragment extends Fragment {
    public static final String TAG = "LifeFragment_TAG";

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onInflate getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onInflate getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Log.d(TAG, "LifeFragment  onAttach activityv  " + getActivity());
        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onAttach activity getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onAttach activity getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "LifeFragment  onAttach");
        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onAttach getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onAttach getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "LifeFragment  onCreate");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onCreate getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onCreate getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        if (((DynamicLifeActivity)getActivity()).mTv_dynamic_tips != null)
//            ((DynamicLifeActivity)getActivity()).mTv_dynamic_tips.setText("fragment set text");
        Log.d(TAG, "LifeFragment  onCreateView");
        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onCreateView getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onCreateView getArguments() key: " + bundle.getInt("key", 0));
        }
        return inflater.inflate(R.layout.life_dynamic_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "LifeFragment  onActivityCreated " + getActivity());

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onActivityCreated getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onActivityCreated getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "LifeFragment  onViewCreated");
        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onViewCreated getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onViewCreated getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "LifeFragment  onStart");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onStart getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onStart getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "LifeFragment  onResume");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onResume getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onResume getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "LifeFragment  onPause");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onPause getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onPause getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "LifeFragment  onStop");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onStop getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onStop getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "LifeFragment  onDestroyView");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onDestroyView getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onDestroyView getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "LifeFragment  onDestroy");
        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onDestroy getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onDestroy getArguments() key: " + bundle.getInt("key", 0));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "LifeFragment  onDetach");

        Bundle bundle = getArguments();
        if (null == bundle) {
            Log.d(TAG, "LifeFragment  onDetach getArguments() == null");
        } else {
            Log.d(TAG, "LifeFragment  onDetach getArguments() key: " + bundle.getInt("key", 0));
        }
    }
}
