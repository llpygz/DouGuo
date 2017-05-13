package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

/**
 * Created by Administrator on 2016/11/5.
 */

public class User extends BaseModel {
    private String id;
    private String n;
    private String p;
    private int v;
    private int lv;
    private String wn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public String getWn() {
        return wn;
    }

    public void setWn(String wn) {
        this.wn = wn;
    }
}
