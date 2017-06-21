package com.mall.push;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class PushEventListener {

    static final Logger logger = LoggerFactory.getLogger(PushEventListener.class);

    private IPushTokenStore tokenStore;

    private Map<String, IPusher> pushChannels;

    private ThreadPoolExecutor threadExecutor;

    private ObjectMapper objectMapper;

    public PushEventListener(ThreadPoolExecutor threadExecutor, IPushTokenStore tokenStore, ObjectMapper objectMapper, Map<String, IPusher> channels) {
        this.threadExecutor = threadExecutor;
        this.tokenStore = tokenStore;
        this.pushChannels = channels;
        this.objectMapper = objectMapper;
    }

    // 订单推送
    @Subscribe
    public void onOrderPush(OrderMessage orderMsg) {
        IPusher pusher = pushChannels.get(orderMsg.getChannel());
        try {
            String payloadStr = objectMapper.writeValueAsString(orderMsg.getContent());
            threadExecutor.execute(() -> {
                PushState state = pusher.pushToDevice(orderMsg.getPushToken(), payloadStr, orderMsg.getOpts());
                if (!state.isOk()) {
                    logger.error("push error: " + state.getErrorMsg());
                }
            });
        } catch (JsonProcessingException e) {
            logger.error("PushEventListener", e);
            e.printStackTrace();
        }
    }

}
