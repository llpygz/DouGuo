package com.example.douguo.ui.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.douguo.R;
import com.example.douguo.adapter.BaseRecyclerAdapter;
import com.example.douguo.adapter.MainMenuAdapter;
import com.example.douguo.bean.main.MainHeader;
import com.example.douguo.bean.main.MainMenu;
import com.huanghaibin_dev.widget.LinePagerIndicator;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainHeaderView extends LinearLayout {
    private LinePagerIndicator mIndicator;
    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;
    private MainMenuAdapter mAdapter;
    private List<MainHeader> mHeaders;
    private ViewPagerAdapter mViewAdapter;

    public MainHeaderView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_main_header, this, true);

        init(context);
    }

    private void init(Context context) {
        mIndicator = (LinePagerIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewAdapter = new ViewPagerAdapter();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new MainMenuAdapter(context, BaseRecyclerAdapter.NEITHER);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initData(List<MainMenu> menus, List<MainHeader> headers) {
        mAdapter.addAll(menus);
        this.mHeaders = headers;
        mViewPager.setAdapter(mViewAdapter);
        mIndicator.bindViewPager(mViewPager);
    }

    private class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mHeaders.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            MainCookBookView view = new MainCookBookView(getContext());
            view.initDate(mHeaders.get(position));
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (object instanceof MainCookBookView) {
                container.removeView((MainCookBookView) object);
            }
        }
    }
}
