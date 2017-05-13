package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class Main extends BaseModel{
    private Header header;
    private String murl;
    private List<BaseMainList> list;
    private int ed;
    private String tid;
    private String btmid;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public List<BaseMainList> getList() {
        return list;
    }

    public void setList(List<BaseMainList> list) {
        this.list = list;
    }

    public int getEd() {
        return ed;
    }

    public void setEd(int ed) {
        this.ed = ed;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBtmid() {
        return btmid;
    }

    public void setBtmid(String btmid) {
        this.btmid = btmid;
    }
}
