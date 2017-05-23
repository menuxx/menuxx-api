package com.mall.push;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EndToEndsPayload implements Payload {

    private String method;

    private String appkey;

    private String seckey;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("aliases")
    private List<String> aliases;

    @JsonProperty("opts")
    private Map<String, Object> opts = new HashMap<>();

    public EndToEndsPayload(String method, String appkey, String seckey, String msg, List<String> aliases) {
        this.method = method;
        this.appkey = appkey;
        this.seckey = seckey;
        this.msg = msg;
        this.aliases = aliases;
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

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }
}
