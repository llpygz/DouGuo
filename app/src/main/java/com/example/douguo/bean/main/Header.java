package com.example.douguo.bean.main;

import com.example.douguo.bean.BaseModel;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */

public class Header extends BaseModel{
    private List<MainHeader> trs;
    private List<MainMenu> fs;
    private int[] q;

    public List<MainHeader> getTrs() {
        return trs;
    }

    public void setTrs(List<MainHeader> trs) {
        this.trs = trs;
    }

    public List<MainMenu> getFs() {
        return fs;
    }

    public void setFs(List<MainMenu> fs) {
        this.fs = fs;
    }

    public int[] getQ() {
        return q;
    }

    public void setQ(int[] q) {
        this.q = q;
    }
}
