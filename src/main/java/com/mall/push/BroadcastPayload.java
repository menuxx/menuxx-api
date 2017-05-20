package com.mall.push;

public class BroadcastPayload implements Payload {

    private String method;

    private String appkey;

    private String seckey;

    private String msg;

    public BroadcastPayload(String method, String appkey, String seckey, String msg) {
        this.method = method;
        this.appkey = appkey;
        this.seckey = seckey;
        this.msg = msg;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getAppkey() {
        return appkey;
    }

    @Override
    public String getSeckey() {
        return seckey;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public void setSeckey(String seckey) {
        this.seckey = seckey;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
