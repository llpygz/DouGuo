package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class M extends BaseModel {
    private int id;
    private String t;
    private User a;
    private String b;
    private List<IS> is;
    private String c;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public User getA() {
        return a;
    }

    public void setA(User a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public List<IS> getIs() {
        return is;
    }

    public void setIs(List<IS> is) {
        this.is = is;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

}
