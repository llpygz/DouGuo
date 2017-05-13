package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainHeader extends BaseModel {
    private String t;
    private CookBook b;
    private User u;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public CookBook getB() {
        return b;
    }

    public void setB(CookBook b) {
        this.b = b;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
