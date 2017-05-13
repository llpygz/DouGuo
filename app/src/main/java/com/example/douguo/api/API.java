package com.example.douguo.api;

import android.util.Log;

import com.example.douguo.bean.BaseBean;
import com.example.douguo.bean.main.Main;
import com.haibin.elegant.Elegant;
import com.haibin.elegant.Response;
import com.haibin.elegant.call.CallBack;
import com.haibin.httpnet.builder.Headers;

/**
 * Created by Administrator on 2016/11/5.
 */

public final class API {
    private static Elegant elegant = new Elegant();

    public static void getMain(CallBack<BaseBean<Main>> callBack) {
        elegant.from(MainService.class)
                .getMain(4)
                .execute(callBack);
    }

    public static Elegant getElegant() {
        return elegant;
    }
}
