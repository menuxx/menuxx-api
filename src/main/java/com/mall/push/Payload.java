package com.mall.push;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Payload {

    @JsonProperty("method")
    String getMethod();

    @JsonProperty("appkey")
    String getAppkey();

    @JsonProperty("seckey")
    String getSeckey();

    @JsonProperty("msg")
    String getMsg();

}
