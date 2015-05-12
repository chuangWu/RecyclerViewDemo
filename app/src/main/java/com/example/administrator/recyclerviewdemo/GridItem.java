package com.example.administrator.recyclerviewdemo;

/**
 * Created by Administrator on 2015/5/9.
 */
public class GridItem {
    private int imgRes;
    private String desc;

    public GridItem(int imgRes, String desc) {
        this.imgRes = imgRes;
        this.desc = desc;
    }

    public int getImgRes() {
        return imgRes;
    }

    public String getDesc() {
        return desc;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
