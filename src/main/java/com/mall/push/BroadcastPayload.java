package com.mall.push;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class BroadcastPayload implements Payload {

    private String method;

    private String appkey;

    private String seckey;

    private String msg;

    @JsonProperty("opts")
    private Map<String, Object> opts = new HashMap<>();

    public BroadcastPayload(String method, String appkey, String seckey, String msg) {
        this.method = method;
        this.appkey = appkey;
        this.seckey = seckey;
        this.msg = msg;
        this.opts.put("qos", 1);
        this.opts.put("time_to_live", 300);
    }

    public Map<String, Object> getOpts() {
        return opts;
    }

    public void setOpts(Map<String, Object> opts) {
        this.opts = opts;
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
