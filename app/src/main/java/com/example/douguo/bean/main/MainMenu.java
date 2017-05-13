package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/5.
 */

public class MainMenu extends BaseModel {
    private String i;
    private String u;
    private String t;
    private String content;
    private String id;

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
