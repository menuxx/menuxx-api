package com.mall.push;

import com.mall.model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderMessage implements PushDeviceMessage<Order> {

    private String pushToken;

    private String channel;

    private Order content;

    private Map<String, Object> opts = new HashMap<>();

    public OrderMessage(String pushToken, String channel, Order content) {
        this.pushToken = pushToken;
        this.content = content;
        this.channel = channel;
    }

    @Override
    public String getPushToken() {
        return pushToken;
    }

    @Override
    public String getChannel() {
        return channel;
    }

    @Override
    public Order getContent() {
        return content;
    }

    @Override
    public Map<String, Object> getOpts() {
        return opts;
    }

    public void setOpts(Map<String, Object> opts) {
        this.opts = opts;
    }
}
