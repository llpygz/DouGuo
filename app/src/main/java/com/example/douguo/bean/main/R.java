package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/11/5.
 */

public class R extends BaseModel {
    @SerializedName("id")
    private long lId;
    private String cookstory;
    private String n;
    private String img;
    private int stc;
    private int sti;
    private int dc;
    private int fc;
    private User a;
    private String an;
    private int ecs;
    private String p;
    private int vc;

    public long getlId() {
        return lId;
    }

    public void setlId(long lId) {
        this.lId = lId;
    }

    public String getCookstory() {
        return cookstory;
    }

    public void setCookstory(String cookstory) {
        this.cookstory = cookstory;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStc() {
        return stc;
    }

    public void setStc(int stc) {
        this.stc = stc;
    }

    public int getSti() {
        return sti;
    }

    public void setSti(int sti) {
        this.sti = sti;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public User getA() {
        return a;
    }

    public void setA(User a) {
        this.a = a;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public int getEcs() {
        return ecs;
    }

    public void setEcs(int ecs) {
        this.ecs = ecs;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public int getVc() {
        return vc;
    }

    public void setVc(int vc) {
        this.vc = vc;
    }
}
