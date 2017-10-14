package com.mall;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.service.WXComponentService;
import com.yingtaohuo.configure.Publisher;
import com.yingtaohuo.service.PushKeyService;
import com.yingtaohuo.wxmsg.WXTokenCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackageClasses = {WXComponentTokenRunner.class}, scanBasePackages = {"com.mall.*", "com.yingtaohuo.*"})
@EnableAsync
@EnableRabbit
@EnableScheduling
public class RootApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        System.out.println("********************** RootApplication start ************************");
        final ApplicationContext applicationContext = SpringApplication.run(RootApplication.class, args);
        System.out.println("********************** RootApplication end ************************");
    }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder()
            .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
            .timeZone("GMT+8")
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .modulesToInstall(new KotlinModule());
    }

}

@Component
@Order(value=1)
class WXComponentTokenRunner implements CommandLineRunner {

    final static Logger logger = LoggerFactory.getLogger(WXComponentTokenRunner.class);

    @Autowired
    WXComponentService componentService;

    @Autowired
    WXTokenCachedClient cachedClient;

    @Autowired
    AppConfigureProperties appConfig;

    @Autowired
    PushKeyService pushKeyService;

    @Autowired
    Publisher publisher;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        String token = cachedClient.getComponentToken(appConfig.getWxComponent().getAppId());
        logger.debug("component token : " + token);
        componentService.setAccessToken(token);
    }

}