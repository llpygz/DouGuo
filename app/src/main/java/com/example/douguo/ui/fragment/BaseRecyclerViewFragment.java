package com.example.douguo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;

import com.example.douguo.R;
import com.example.douguo.adapter.BaseRecyclerAdapter;
import com.example.douguo.bean.BaseBean;
import com.example.douguo.widget.SuperRefreshLayout;
import com.haibin.elegant.Response;
import com.haibin.elegant.call.CallBack;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/11/5.
 */

public abstract class BaseRecyclerViewFragment<T> extends BaseFragment implements SuperRefreshLayout.SuperRefreshLayoutListener, BaseRecyclerAdapter.OnItemClickListener {
    @Bind(R.id.refreshLayout)
    SuperRefreshLayout mRefreshLayout;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    protected boolean mIsRefresh;
    protected BaseRecyclerAdapter<T> mAdapter;

    protected CallBack<BaseBean<T>> mCallBack;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base_recycler_view;
    }

    @Override
    protected void initView() {
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        mAdapter = getAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mAdapter.setOnItemClickListener(this);
        mRefreshLayout.setColorSchemeResources(R.color.app_color, R.color.light_blue, R.color.red);

    }

    @Override
    protected void initDate() {
        mCallBack = new CallBack<BaseBean<T>>() {
            @Override
            public void onResponse(Response<BaseBean<T>> response) {
                if (response.getBody() != null) {
                    setListData(response);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        };
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
                onRefreshing();
            }
        });
    }

    @Override
    public void onItemClick(int position, long itemId) {

    }

    @Override
    public void onRefreshing() {
        mIsRefresh = true;
    }

    @Override
    public void onLoadMore() {
        mIsRefresh = false;
    }

    protected void setListData(Response<BaseBean<T>> response) {

    }

    protected void onComplete(){
        mRefreshLayout.setRefreshing(false);
        mRefreshLayout.onComplete();
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    protected abstract BaseRecyclerAdapter<T> getAdapter();
}
