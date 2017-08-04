package com.mall.push;

import java.util.Map;

public interface PushDeviceMessage<T> {

    String getTitle();  // 消息标题，用于推送渠道显示消息名称

    String getName();   // 消息名称，用于区分消息

    String getPushToken();

    String getChannel();

    T getContent();

    Map<String, Object> getOpts();

}
