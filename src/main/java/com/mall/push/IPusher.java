package com.mall.push;

import java.util.Map;

public interface IPusher {

    PushState pushToDevice(String pushToken, String payload, Map<String, Object> opts);

}
