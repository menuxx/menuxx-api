package com.mall.push;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;
import com.mall.configure.properties.MqttOrderConfigureProperties;
import com.mall.configure.properties.MqttWxLiteConfigureProperties;
import com.mall.configure.properties.PushConfigProperties;
import com.mall.push.pusher.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class PushConfiguration {

    static final Logger logger = LoggerFactory.getLogger(PushConfiguration.class);

    @Autowired
    @NotNull
    PushConfigProperties pushConfig;

    @Autowired
    @NotNull
		MqttOrderConfigureProperties mqttOrderConfig;

    @Autowired
    @NotNull
    MqttWxLiteConfigureProperties mqttWxLiteConfig;

    Map<String, IPusher> channels = new HashMap<>();

    @Bean
    public IPushTokenStore pushTokenStore(@Autowired @Qualifier("objRedisTemplate") RedisTemplate<String, Object> objRedisTemplate) {
        return new RedisPushTokenStore(objRedisTemplate);
    }

    private ThreadPoolExecutor ioExecutor() {
        int corePoolSize = 10; // 线程池维护线程的最少数量
        int maximumPoolSize = 20; // 线程池维护线程的最大数量
        long keepAliveTime = 10; // 线程池维护线程所允许的空闲时间
        TimeUnit unit = TimeUnit.SECONDS;  // 线程池维护线程所允许的空闲时间的单位
        BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(maximumPoolSize); // 线程池所使用的缓冲队列
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, blockingDeque);
    }

    @Bean
    public PushEventListener dinerOrderEventListener(EventBus eventBus, IPushTokenStore pushTokenStore, ObjectMapper jsonMapper) {
        PushEventListener listener = new PushEventListener(ioExecutor(), pushTokenStore, jsonMapper, channels);
        eventBus.register(listener);
        return listener;
    }

    @Bean
    public DinerPushManager dinerPushManager(EventBus eventBus, IPushTokenStore pushTokenStore) {
        return new DinerPushManager(eventBus, pushTokenStore);
    }

    @PostConstruct
    public void init() {

        channels.put(PushConst.CAHNNEL_ALIPUSH, initAliPush());
        channels.put(PushConst.CAHNNEL_XINGE, initXinGePush());
        channels.put(PushConst.CAHNNEL_GETUI, initGeTuiPush());
        // channels.put(PushConst.CAHNNEL_BAIDUPUSH, initBaiduPusher());
        channels.put(PushConst.CAHNNEL_BAIDUMQTT, initBaiduMqttOrderPusher());

        for (Map.Entry<String, IPusher> channelPusher : channels.entrySet()) {
            IPusher pusher = channelPusher.getValue();
            if ( pusher != null ) {
                try {
                    pusher.initialize();
                } catch (ClientInitException e) {
                    logger.error(pusher.getName() + " pusher initialize failed .", e);
                    System.exit(0);
                }
            }
        }
    }

    @PreDestroy
    public void destroy() {
        for (Map.Entry<String, IPusher> channelPusher : channels.entrySet()) {
            IPusher pusher = channelPusher.getValue();
            if ( pusher != null ) {
                pusher.destroy();
            }
        }
    }

    // 信鸽推送客户端
    private XGPusher initXinGePush() {
        return new XGPusher(pushConfig.getXingeAccessId(), pushConfig.getXingeSecretKey());
    }

    // 个推推送客户端
    private GeTuiPusher initGeTuiPush() {
        return new GeTuiPusher(pushConfig.getGetuiPushUrl(), pushConfig.getGetuiAppKey(), pushConfig.getGetuiAppId(), pushConfig.getGetuiMasterSecret(), false);
    }

    // 阿里推送
    private AliPusher initAliPush() {
        return new AliPusher(pushConfig.getAlipushAccessKeyId(), pushConfig.getAlipushAccessKeySecret(), pushConfig.getAlipushAppkey());
    }

    // 百度推送
    private BaiduPusher initBaiduPusher() {
        return new BaiduPusher(pushConfig.getBaidupushApiKey(), pushConfig.getBaidupushSecretKey());
    }

    // 百度mqtt推送
    private BaiduMqttPusher initBaiduMqttOrderPusher() {
        return new BaiduMqttPusher(
            mqttOrderConfig.getBroker(),
                "api_server_order" + System.currentTimeMillis(),
            mqttOrderConfig.getUsername(), mqttOrderConfig.getPassword(),
            mqttOrderConfig.getTimeout(),
            mqttOrderConfig.getKeepalive()
        );
    }

    @Bean("wxLitePusher")
    public BaiduMqttPusher initBaiduMqttWxLitePusher() {
        BaiduMqttPusher pusher = new BaiduMqttPusher(
            mqttWxLiteConfig.getBroker(),
            "api_server_wxLite" + System.currentTimeMillis(),
            mqttWxLiteConfig.getUsername(), mqttWxLiteConfig.getPassword(),
            mqttWxLiteConfig.getTimeout(),
            mqttWxLiteConfig.getKeepalive()
        );
        pusher.initialize();
        return pusher;
    }

}