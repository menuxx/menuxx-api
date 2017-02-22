package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@SpringBootApplication
@EnableAsync
public class RootApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        System.out.println("**********************RootApplication start************************");
        final ApplicationContext applicationContext = SpringApplication.run(RootApplication.class, args);
        System.out.println("**********************RootApplication end************************");
    }

}
