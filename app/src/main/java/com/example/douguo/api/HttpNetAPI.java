package com.example.douguo.api;

import com.haibin.httpnet.HttpNetClient;
import com.haibin.httpnet.builder.Headers;
import com.haibin.httpnet.builder.Request;
import com.haibin.httpnet.builder.RequestParams;
import com.haibin.httpnet.core.call.CallBack;

/**
 */

public class HttpNetAPI {
    private static HttpNetClient mClient = new HttpNetClient();
    private static Headers.Builder headers = new Headers.Builder()
            .addHeader("cid", "11523")
            .addHeader("client", "4")
            .addHeader("sdk", "23,6.0.1")
            .addHeader("version", "624.2")
            .addHeader("duid", "47396906")
            .addHeader("Cookie", "duid=47396906");

    public static void getMain(String url, CallBack callBack) {

        RequestParams params = new RequestParams()
                .put("client", 4);

        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .params(params)
                .method("POST")
                .build();

        mClient.newCall(request).execute(callBack);
    }
}
