package com.mall.configure;

import com.mall.bind.CurrentDinerMethodArgumentResolver;
import com.mall.bind.SessionKeyMethodArgumentResolver;
import com.mall.interceptor.CorpsInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * @author 尹昶胜
 * @since 2016/7/19
 * 对 Spring MVC 进行配置
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter implements AsyncConfigurer {

    static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Autowired
    CorpsInterceptor corpsInterceptor;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(1);
        executor.setCorePoolSize(1);
        executor.setThreadNamePrefix("CUSTOM-");
        // Initialize the executor
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            if ( logger.isDebugEnabled() ) {
                String params = Arrays.asList(objects).stream().map(String::valueOf).collect(Collectors.joining(" "));
                logger.debug("AsyncUncaughtException", throwable.getMessage() + ", Method name - " + method.getName() + ", Parameter value - " + params);
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corpsInterceptor);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentDinerMethodArgumentResolver());
        resolvers.add(new SessionKeyMethodArgumentResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
