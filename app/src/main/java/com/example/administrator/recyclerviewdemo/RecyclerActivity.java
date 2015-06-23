package com.example.administrator.recyclerviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class RecyclerActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerGridViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showOverflowAlways();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        initListView(true);

        //add or remove func
        initGridViewData();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                mAdapter.addData(1);
                break;
            case R.id.menu_delete:
                mAdapter.removeData(1);
                break;
            case R.id.menu_v_listview:
                initListView(true);
                break;
            case R.id.menu_h_listview:
                initListView(false);
                break;
            case R.id.menu_v_gridview:
                initGridView(true);
                break;
            case R.id.menu_h_gridview:
                initGridView(false);
                break;
            case R.id.menu_v_staggered:
                initStaggered(true);
                break;
            case R.id.menu_h_staggered:
                initStaggered(false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initStaggered(boolean flag) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, flag ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new RecyclerStaggeredAdapter(this, flag));
    }

    private void initListView(boolean flag) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(flag ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //添加布局动画
        addLayoutAnimation();

        mRecyclerView.setAdapter(new RecyclerListViewAdapter(this, flag));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setBackgroundColor(Color.WHITE);
    }

    private void addLayoutAnimation() {
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        fadeIn.setDuration(500L);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(fadeIn);
        this.mRecyclerView.setLayoutAnimation(layoutAnimationController);
        this.mRecyclerView.startLayoutAnimation();
    }

    private void initGridView(boolean flag) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, flag ? 3 : 4);
        layoutManager.setOrientation(flag ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setBackgroundColor(Color.WHITE);
    }


    /**
     * 1.屏蔽Menu按键
     */
    private void showOverflowAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field key = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            key.setAccessible(true);
            key.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2.显示Overflow按钮
     *
     * @param featureId
     * @param menu
     * @return
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        try {
            if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
                if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onMenuOpened(featureId, menu);
    }


    private void initGridViewData() {
        ArrayList<GridItem> mDatas = new ArrayList<GridItem>();
        mDatas.add(new GridItem(R.drawable.g1, "浏览器"));
        mDatas.add(new GridItem(R.drawable.g2, "输入法"));
        mDatas.add(new GridItem(R.drawable.g3, "健康"));
        mDatas.add(new GridItem(R.drawable.g4, "效率"));
        mDatas.add(new GridItem(R.drawable.g5, "教育"));
        mDatas.add(new GridItem(R.drawable.g6, "理财"));
        mDatas.add(new GridItem(R.drawable.g7, "阅读"));
        mDatas.add(new GridItem(R.drawable.g8, "个性化"));
        mDatas.add(new GridItem(R.drawable.g9, "购物"));
        mDatas.add(new GridItem(R.drawable.g10, "资讯"));
        mDatas.add(new GridItem(R.drawable.g11, "生活"));
        mDatas.add(new GridItem(R.drawable.g12, "工具"));
        mDatas.add(new GridItem(R.drawable.g13, "出行"));
        mDatas.add(new GridItem(R.drawable.g14, "通讯"));
        mDatas.add(new GridItem(R.drawable.g15, "拍照"));
        mDatas.add(new GridItem(R.drawable.g16, "社交"));
        mDatas.add(new GridItem(R.drawable.g17, "影音"));
        mDatas.add(new GridItem(R.drawable.g18, "安全"));
        mDatas.add(new GridItem(R.drawable.g19, "休闲"));
        mDatas.add(new GridItem(R.drawable.g20, "棋牌"));
        mDatas.add(new GridItem(R.drawable.g21, "益智"));
        mDatas.add(new GridItem(R.drawable.g22, "射击"));
        mDatas.add(new GridItem(R.drawable.g23, "体育"));
        mDatas.add(new GridItem(R.drawable.g24, "儿童"));
        mDatas.add(new GridItem(R.drawable.g25, "网游"));
        mDatas.add(new GridItem(R.drawable.g26, "角色"));
        mDatas.add(new GridItem(R.drawable.g27, "策略"));
        mDatas.add(new GridItem(R.drawable.g28, "经营"));
        mDatas.add(new GridItem(R.drawable.g29, "竞速"));

        mAdapter = new RecyclerGridViewAdapter(this,mDatas);
    }

}
