package com.mall;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.push.DinerPushManager;
import com.mall.service.WXComponentService;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.mall.*", "com.yingtaohuo.*"})
@EnableAsync
@EnableScheduling
public class RootApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        System.out.println("********************** RootApplication start ************************");
        final ApplicationContext applicationContext = SpringApplication.run(RootApplication.class, args);
        System.out.println("********************** RootApplication end ************************");
    }

}

@Component
@Order(value=1)
class WXComponentTokenRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(WXComponentTokenRunner.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WXComponentService componentService;

    @Autowired
    AppConfigureProperties appConfig;

    @Override
    public void run(String... args) throws Exception {

        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request
                .Builder()
                .get()
                .url(appConfig.getWxComponent().getWx3rdApi() + "component_cache")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                // 获取失败就退出
                System.exit(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    HashMap<String, String> componentCache = (HashMap<String, String>) objectMapper.readValue(response.body().bytes(), HashMap.class);
                    componentService.updateCache(componentCache);
                } else {
                    logger.error(response.toString());
                    System.exit(1);
                }
            }
        });

    }

}