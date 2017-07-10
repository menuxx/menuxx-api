package com.mall.push;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.Subscribe;
import com.mall.model.Order;
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
            Order order = orderMsg.getContent();
            String payloadStr = objectMapper.writeValueAsString(order);
            Map<String, Object> opts = orderMsg.getOpts();
            // 组装一条推送消息的 标题
            String msgTitle = order.getQueueId() + " " + order.getOrderTypeText() + " " + order.getOrderCode();
            opts.put(PushConst.OPTS_MSG_EXTRA_TITLE, msgTitle);
            // 合并所有的选项
            opts.putAll(pusher.getDefaultOpts(opts));
            threadExecutor.execute(() -> {
                try {
                    PushState state = pusher.pushToClient(orderMsg.getPushToken(), payloadStr, opts);
                    if (!state.isOk()) {
                        logger.error("push error: " + state.getErrorMsg());
                    }
                } catch (PushException e) {
                    logger.error("push error: " + e.getMessage());
                }
            });
        } catch (JsonProcessingException e) {
            logger.error("PushEventListener", e);
        }
    }

}
