package com.mall.push;

import java.util.Map;

public interface PushDeviceMessage<T> {

    String getPushToken();

    String getChannel();

    T getContent();

    Map<String, Object> getOpts();

}
