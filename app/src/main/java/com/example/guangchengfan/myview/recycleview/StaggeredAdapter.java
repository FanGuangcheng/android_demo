package com.example.guangchengfan.myview.recycleview;

/**
 * Created by guangcheng.fan on 2016/5/6.
 */

import java.util.List;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guangchengfan.myview.R;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.ItemViewHolder> {
    private List<Item> items;
    private int mSelectItemIndex = 0;
    //点击监听事件
    public interface OnRecyclerViewItemClickListener{
        void onClick(View view, int position);
    };
    private OnRecyclerViewItemClickListener listener;
    //设置监听器
    public void setListener(OnRecyclerViewItemClickListener listener) {
        this.listener = listener;
    }
    //构造函数，将数据赋值给成员变量
    public StaggeredAdapter(List<Item> items, int selectIndex) {
        this.items = items;
        mSelectItemIndex = selectIndex;
    }
    //获得数据大小
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //将布局进行绑定
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.brand_filter_item_layout, viewGroup, false);
        return new ItemViewHolder(view);
    }
    //绑定数据
    @Override
    public void onBindViewHolder(final ItemViewHolder viewHolder,final int position) {
        Item item = items.get(position);
        viewHolder.title.setText(item.getTitle());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            //如果监听器非空，则回调
            @Override
            public void onClick(View v) {
                if (listener!=null) {
                    listener.onClick(viewHolder.itemView, position);
                }
            }
        });

        if (position == mSelectItemIndex){
            viewHolder.title.setTextColor(Color.RED);
        }
        else {
            viewHolder.title.setTextColor(Color.BLACK);
        }
    }

    public void setSelectIndex(int index) {
        mSelectItemIndex = index;
    }

    //ViewHolder，用于缓存，提高效率
    public final static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}