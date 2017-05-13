package com.example.douguo.ui.fragment;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.douguo.adapter.BaseRecyclerAdapter;
import com.example.douguo.adapter.MainListAdapter;
import com.example.douguo.api.API;
import com.example.douguo.api.HttpNetAPI;
import com.example.douguo.bean.BaseBean;
import com.example.douguo.bean.main.BaseMainList;
import com.example.douguo.bean.main.Main;
import com.example.douguo.ui.view.MainHeaderView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haibin.elegant.Response;
import com.haibin.elegant.call.CallBack;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainFragment extends BaseRecyclerViewFragment<BaseMainList> {

     private String mUrl;
      private int size = 0;
      private String tid = "1654";
    private MainHeaderView mHeaderView;
    private Handler handler = new Handler();
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected void initView() {
        super.initView();
        mHeaderView = new MainHeaderView(getActivity());
        mAdapter.setHeaderView(mHeaderView);
        resetUrl();
    }

    @Override
    public void onRefreshing() {
       super.onRefreshing();
        size = 0;
        tid = "1654";
        resetUrl();
        request();
  /*      API.getMain(new CallBack<BaseBean<Main>>() {
            @Override
            public void onResponse(Response<BaseBean<Main>> response) {
                if (response.getBody() != null) {
                    mAdapter.addAll(response.getBody().getResult().getList());
                    mHeaderView.initData(response.getBody().getResult().getHeader().getFs(), response.getBody().getResult().getHeader().getTrs());
//                    size += mAdapter.getItems().size();
//                    tid = response.getBody().getResult().getTid();
//                    resetUrl();
//                }
//                if (mAdapter.getItems().size() < 20) {
//                    mAdapter.setState(BaseRecyclerAdapter.STATE_NO_MORE, true);
//                } else {
//                    mAdapter.setState(BaseRecyclerAdapter.STATE_LOADING, true);
                }
                onComplete();
            }
            //
            @Override
            public void onFailure(Exception e) {
                onComplete();
            }
        });*/
    }

    @Override
    public void onLoadMore() {
        // super.onLoadMore();
        // request();
    }

   private void request() {
        HttpNetAPI.getMain(mUrl, new com.haibin.httpnet.core.call.CallBack() {
            @Override
            public void onResponse(com.haibin.httpnet.core.Response response) {
                try {
                    Type type = new TypeToken<BaseBean<Main>>() {
                    }.getType();
                    final BaseBean<Main> baseBean = new Gson().fromJson(response.getBody(), type);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (baseBean.getResult() != null) {
                                if (mIsRefresh) {
                                    mAdapter.resetItem(baseBean.getResult().getList());
                                    mHeaderView.initData(baseBean.getResult().getHeader().getFs(), baseBean.getResult().getHeader().getTrs());
                                } else {
                                    mAdapter.addAll(baseBean.getResult().getList());
                                }
                                mIsRefresh = false;
                                size += mAdapter.getItems().size();
                                tid = baseBean.getResult().getTid();
                                resetUrl();
                            }
                            if (mAdapter.getItems().size() < 20) {
                                mAdapter.setState(BaseRecyclerAdapter.STATE_NO_MORE, true);
                            } else {
                                mAdapter.setState(BaseRecyclerAdapter.STATE_LOADING, true);
                            }
                            onComplete();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Exception e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onComplete();
                    }
                });
            }
        });
    }

    private void resetUrl() {
        mUrl = "http://api.douguo.net/recipe/home/" + size + "/20/" + tid;
    }

    @Override
    protected BaseRecyclerAdapter<BaseMainList> getAdapter() {
        return new MainListAdapter(getActivity(), BaseRecyclerAdapter.BOTH_HEADER_FOOTER);
    }
}
