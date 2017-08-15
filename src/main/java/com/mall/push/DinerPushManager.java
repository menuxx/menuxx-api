package com.mall.push;

import com.google.common.eventbus.EventBus;
import com.mall.model.Order;
import com.yingtaohuo.eventbus.OrderAddItems;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DinerPushManager {

    EventBus eventBus;

    IPushTokenStore pushTokenStore;

    public DinerPushManager(EventBus eventBus, IPushTokenStore pushTokenStore) {
        this.eventBus = eventBus;
        this.pushTokenStore = pushTokenStore;
    }

    @Deprecated
    public void pushOrderToDinerUser(String userPushKey, Order order) {
        pushOrderToShopReceiver(userPushKey, order);
    }

    public void pushOrderToShopReceiver(String userPushKey, Order order) {
        Map<String, String> tokenGroup = pushTokenStore.getTokens(userPushKey);
        if (tokenGroup != null) {
            pushOrder(tokenGroup, order);
        }
    }

    public Map<String, String> putToken(String userPushKey, String pushChannelName, String pushToken) {
        return pushTokenStore.putToken(userPushKey, pushChannelName, pushToken);
    }

    public void pushOrder(Map<String, String> pushDevices, Order order) {
        for (Map.Entry<String, String> pushDevice : pushDevices.entrySet()) {
            OrderMessage msg = new OrderMessage(pushDevice.getValue(), pushDevice.getKey(), order);
            eventBus.post(msg);
        }
    }

    public void pushOrderAddItems(Map<String, String> pushDevices, OrderAddItems items) {
        for (Map.Entry<String, String> pushDevice : pushDevices.entrySet()) {
            OrderAddItemsMessage msg = new OrderAddItemsMessage(pushDevice.getValue(), pushDevice.getKey(), items, new HashMap<>());
            eventBus.post(msg);
        }
    }

    public void pushOrderAddItemsToShopReceiver(String userPushKey, OrderAddItems items) {
        Map<String, String> tokenGroup = pushTokenStore.getTokens(userPushKey);
        if (tokenGroup != null) {
            pushOrderAddItems(tokenGroup, items);
        }
    }

}