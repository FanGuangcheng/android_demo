package com.example.guangchengfan.myview.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.guangchengfan.myview.R;

import java.util.ArrayList;

public class RecycleActivity extends Activity implements View.OnClickListener {

    Button btn_show_recycle_view;
    Button btn_show_linear_recycle_view;
    Button btn_show_stagger_grid_recycle_view;
    RelativeLayout rl_filter_recycle_container;
    RelativeLayout rl_staggered_grid_recycle_container;
    RecyclerView recyclerview;
    RecyclerView staggered_recyclerview;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Item> staggeredItems = new ArrayList<Item>();
    private boolean mIsViewHasShow = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initDatas();
        initStaggeredDatas();
        initViews();
        initStaggeredViews();
    }

    @Override
    public void onClick(View v) {
        int visiable = mIsViewHasShow ? View.GONE: View.VISIBLE;
        if (v.getId() == R.id.btn_show_grid_recycle_view) {
            if (null != recyclerview) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
                gridLayoutManager.scrollToPosition(3);
                recyclerview.setLayoutManager(gridLayoutManager);
            }
            rl_filter_recycle_container.setVisibility(visiable);
            mIsViewHasShow = !mIsViewHasShow;
        } else if (v.getId() == R.id.btn_show_linear_recycle_view) {
            if (null != recyclerview) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                linearLayoutManager.scrollToPosition(8);
                recyclerview.setLayoutManager(linearLayoutManager);
            }
            rl_filter_recycle_container.setVisibility(visiable);
            mIsViewHasShow = !mIsViewHasShow;
        } else if (v.getId() == R.id.btn_show_stagger_grid_recycle_view) {
            if (null != staggered_recyclerview) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                staggered_recyclerview.setLayoutManager(staggeredGridLayoutManager);
            }
            if (rl_staggered_grid_recycle_container.getVisibility() == View.GONE)
                rl_staggered_grid_recycle_container.setVisibility(View.VISIBLE);
            else
                rl_staggered_grid_recycle_container.setVisibility(View.GONE);
        }
    }

    private void initViews() {
        btn_show_recycle_view = (Button)findViewById(R.id.btn_show_grid_recycle_view);
        btn_show_recycle_view.setOnClickListener(this);
        btn_show_linear_recycle_view = (Button)findViewById(R.id.btn_show_linear_recycle_view);
        btn_show_linear_recycle_view.setOnClickListener(this);
        btn_show_stagger_grid_recycle_view = (Button)findViewById(R.id.btn_show_stagger_grid_recycle_view);
        btn_show_stagger_grid_recycle_view.setOnClickListener(this);

        rl_filter_recycle_container = (RelativeLayout)findViewById(R.id.rl_filter_recycle_container);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        //新建适配器
        final MyRecycleAdapter adapter = new MyRecycleAdapter(items, 1);
        //设置监听器
        adapter.setListener(new MyRecycleAdapter.OnRecyclerViewItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), items.get(position).getTitle(), Toast.LENGTH_LONG).show();
                adapter.setSelectIndex(position);
                adapter.notifyDataSetChanged();
            }
        });
        //设置适配器
        recyclerview.setAdapter(adapter);
        //默认动画效果
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器，第三个参数为是否逆向布局
//        recyclerview.setLayoutManager(new GridLayoutManager(this,3));
        //可以提高效率
        recyclerview.setHasFixedSize(true);
    }
    private void initStaggeredViews() {
        rl_staggered_grid_recycle_container = (RelativeLayout)findViewById(R.id.rl_staggered_grid_recycle_container);
        staggered_recyclerview = (RecyclerView)findViewById(R.id.staggered_recyclerview);
        //新建适配器
        final StaggeredAdapter adapter = new StaggeredAdapter(staggeredItems, 1);
        //设置监听器
        adapter.setListener(new StaggeredAdapter.OnRecyclerViewItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), items.get(position).getTitle(), Toast.LENGTH_LONG).show();
                adapter.setSelectIndex(position);
                adapter.notifyDataSetChanged();
            }
        });
        //设置适配器
        staggered_recyclerview.setAdapter(adapter);
        //默认动画效果
        staggered_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器，第三个参数为是否逆向布局
//        recyclerview.setLayoutManager(new GridLayoutManager(this,3));
        //可以提高效率
        staggered_recyclerview.setHasFixedSize(true);
    }

    private void initStaggeredDatas() {
        Item item = new Item();
        item.setTitle("微信");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("支付宝");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("QQ");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("易到用车");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("有道");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("哈哈哈");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("啊");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("zuixin");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("最新版本啊的");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("支付7");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("微撒大声大声道7");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("的付7");
        staggeredItems.add(item);

        item = new Item();
        item.setTitle("打豆豆7");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle("信支付7");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle(" 付7");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle("微");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle("微啊");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle("微信7");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle("微付7");
        staggeredItems.add(item);
        item = new Item();
        item.setTitle("微啊啊7");
        staggeredItems.add(item);
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
