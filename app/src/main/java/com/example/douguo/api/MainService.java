package com.example.douguo.api;

import com.example.douguo.bean.BaseBean;
import com.example.douguo.bean.main.Main;
import com.haibin.elegant.call.Call;
import com.haibin.elegant.net.Form;
import com.haibin.elegant.net.Headers;
import com.haibin.elegant.net.POST;

/**
 * Created by Administrator on 2016/11/5.
 */

public interface MainService {

    @Headers({"cid:11523", "client:4", "sdk:23,6.0.1", "version:624.2", "duid:47396906", "Cookie:duid=47396906"})
    @POST("http://api.douguo.net/recipe/home/0/20/1654")
    Call<BaseBean<Main>> getMain(@Form("client") int client);
}
