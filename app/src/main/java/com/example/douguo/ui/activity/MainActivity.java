package com.example.douguo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.douguo.R;
import com.example.douguo.api.MainService;
import com.example.douguo.bean.BaseBean;
import com.example.douguo.bean.main.Main;
import com.example.douguo.ui.activity.BaseActivity;
import com.example.douguo.ui.fragment.MainFragment;
import com.haibin.elegant.Elegant;
import com.haibin.elegant.Response;
import com.haibin.elegant.call.CallBack;
import com.haibin.httpnet.builder.Headers;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        addFragment(R.id.fl_content, MainFragment.newInstance());
    }

    @Override
    protected void initDate() {

    }
}
