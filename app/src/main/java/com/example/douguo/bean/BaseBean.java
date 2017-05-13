package com.example.douguo.bean;

/**
 * Created by Administrator on 2016/11/5.
 */

public class BaseBean <T>{
    private String state;
    private T result;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
