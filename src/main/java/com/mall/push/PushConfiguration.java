package com.mall.push;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;
import com.mall.configure.properties.PushConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class PushConfiguration {

    @Autowired
    @NotNull
    PushConfigProperties pushProps;

    Map<String, IPusher> channels = new HashMap<>();

    @Bean
    public IPushTokenStore pushTokenStore(ValueOperations<String, Object> objOpts) {
        return new RedisPushTokenStore(objOpts);
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
        channels.put(Consts.CAHNNEL_XINGE, initXinGePush());
        channels.put(Consts.CAHNNEL_GETUI, initGeTuiPush());
    }

    // 信鸽推送客户端
    private XGPusher initXinGePush() {
        return new XGPusher(pushProps.getXingeAccessId(), pushProps.getXingeSecretKey());
    }

    // 个推推送客户端
    private GeTuiPuser initGeTuiPush() {
        return new GeTuiPuser(pushProps.getGetuiPushUrl(), pushProps.getGetuiAppKey(), pushProps.getGetuiAppId(), pushProps.getGetuiMasterSecret(), false);
    }

}
