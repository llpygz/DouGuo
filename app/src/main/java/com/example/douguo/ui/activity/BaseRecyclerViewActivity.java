package com.example.douguo.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.douguo.R;
import com.example.douguo.adapter.BaseRecyclerAdapter;
import com.example.douguo.widget.SuperRefreshLayout;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/11/5.
 */

public abstract class BaseRecyclerViewActivity<T> extends BaseActivity implements SuperRefreshLayout.SuperRefreshLayoutListener ,BaseRecyclerAdapter.OnItemClickListener{
    @Bind(R.id.refreshLayout)
    SuperRefreshLayout mRefreshLayout;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    protected BaseRecyclerAdapter<T> mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_recycler_view;
    }

    @Override
    protected void initView() {
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        mAdapter = getAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mRefreshLayout.setColorSchemeResources(R.color.app_color, R.color.light_blue, R.color.red);
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
                onRefreshing();
            }
        });
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onItemClick(int position, long itemId) {

    }

    @Override
    public void onRefreshing() {

    }

    @Override
    public void onLoadMore() {

    }

    protected abstract BaseRecyclerAdapter<T> getAdapter();
}
