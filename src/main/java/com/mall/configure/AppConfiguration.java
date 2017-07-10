package com.mall.configure;

import com.google.common.eventbus.EventBus;
import com.mall.push.DinerPushManager;
import com.mall.push.IPushTokenStore;
import com.mall.push.PushEventListener;
import com.mall.push.RedisPushTokenStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfiguration {

    @Bean
    public EventBus globalEventBus() {
        return new EventBus();
    }

}
