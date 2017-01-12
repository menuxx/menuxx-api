package com.mall.configure;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 尹昶胜
 * @since 2016-07-19 16:36
 * 该类负责配置 Mybatis MapperFactoryBean 的制动扫描生成器 MybatisMapperScanner 的相关配置工作
 * 本配置参考：https://github.com/abel533/MyBatis-Spring-Boot
 */
@Configuration
//注意，由于MapperScannerConfigurer执行周期早于Spring的执行周期，所以必须有下面的注解，需要主动生命与Spring完成配置后再启动MapperScannerConfigurer
@AutoConfigureAfter(MyBatisConfiguration.class)
public class MyBatisMapperScannerConfiguration {

    /**
     * 创建者：尹昶胜
     * @return MapperScannerConfigurer
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        configurer.setBasePackage("com.mall.mapper");
        return configurer;
    }

}
