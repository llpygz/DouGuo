package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

/**
 * Created by Administrator on 2016/11/5.
 */

public class BaseMainList extends BaseModel {
    private M m;
    private TA ta;
    private R r;
    protected String id;
    protected String type;
    protected String tc;

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public TA getTa() {
        return ta;
    }

    public void setTa(TA ta) {
        this.ta = ta;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
}
