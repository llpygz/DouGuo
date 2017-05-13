package com.example.douguo.app;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by Administrator on 2016/11/5.
 */

public class AppContext extends Application{
    private static RequestManager mLoader;
    @Override
    public void onCreate() {
        super.onCreate();
        mLoader = Glide.with(this);
    }

    public static RequestManager getLoader() {
        return mLoader;
    }
}

