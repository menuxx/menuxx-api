package com.mall.push;

import java.util.Map;

public interface IPusher {

    String getName();

    void initialize() throws ClientInitException;

    PushState pushToClient(String clientId, String payload, Map<String, Object> opts);

    PushState pushToDevice(String deviceId, String payload, Map<String, Object> opts);

    Map<String, Object> getDefaultOpts(Map<String, Object> commonOpts);

    void destroy();

}
