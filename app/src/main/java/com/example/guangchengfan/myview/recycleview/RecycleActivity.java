package com.example.guangchengfan.myview.recycleview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.guangchengfan.myview.R;

import java.util.ArrayList;

public class RecycleActivity extends Activity implements View.OnClickListener {

    Button btn_show_recycle_view;
    RelativeLayout rl_filter_recycle_container;
    RecyclerView recyclerview;
    private ArrayList<Item> items = new ArrayList<Item>();
    private boolean mIsViewHasShow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initDatas();//初始化数据
        initViews();//初始化recyclerview
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_recycle_view) {
            int visiable = mIsViewHasShow ? View.VISIBLE : View.GONE;
            rl_filter_recycle_container.setVisibility(visiable);
            mIsViewHasShow = !mIsViewHasShow;
        }
    }

    private void initViews() {
        btn_show_recycle_view = (Button)findViewById(R.id.btn_show_recycle_view);
        btn_show_recycle_view.setOnClickListener(this);

        rl_filter_recycle_container = (RelativeLayout)findViewById(R.id.rl_filter_recycle_container);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        //新建适配器
        BrandRecycleAdapter adapter = new BrandRecycleAdapter(items);
        //设置监听器
        adapter.setListener(new BrandRecycleAdapter.OnRecyclerViewItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), items.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        //设置适配器
        recyclerview.setAdapter(adapter);
        //默认动画效果
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器，第三个参数为是否逆向布局
        recyclerview.setLayoutManager(new GridLayoutManager(this,3));
        //可以提高效率
        recyclerview.setHasFixedSize(true);
    }
    private void initDatas() {
        Item item = new Item();
        item.setTitle("微信支付1");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付2");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付3");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付4");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付5");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付6");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);

        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);
        item = new Item();
        item.setTitle("微信支付7");
        items.add(item);


    }
}
