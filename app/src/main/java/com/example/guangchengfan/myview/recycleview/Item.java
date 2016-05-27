package com.example.guangchengfan.myview.recycleview;

/**
 * Created by guangcheng.fan on 2016/5/6.
 */
public class Item {

    //标题
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Item  title=" + title;
    }
}
