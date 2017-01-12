package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Supeng on 11/01/2017.
 */
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
public class RootApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("**********************RootApplication start************************");
        final ApplicationContext applicationContext = SpringApplication.run(RootApplication.class, args);
        System.out.println("**********************RootApplication end************************");
    }
}
