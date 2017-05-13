package com.example.douguo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/11/5.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Fragment mContent;

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initDate();
    }

    protected abstract void initView();

    protected abstract void initDate();

    protected void addFragment(int frameLayoutId, Fragment fragment) {
        if (mContent == null) {
            mContent = new Fragment();
        }

        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                transaction.hide(mContent).show(fragment);
            } else {
                transaction.hide(mContent).add(frameLayoutId, fragment);
            }
            mContent = fragment;
            transaction.commit();
        }
    }
}
