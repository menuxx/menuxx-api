package com.mall.service;

import com.mall.configure.AppConfiguration;
import com.mall.push.MyJacksonConverterFactory;
import com.mall.push.PayloadFactory;
import com.mall.push.PushState;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PushService {

    public static final String YUNBA_RETROFIT = "YUNBA_RETROFIT";

    Logger logger = LoggerFactory.getLogger(PushService.class);

    public OkHttpClient yunbaOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .connectTimeout(300, TimeUnit.MILLISECONDS)
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .build();
    }

    private HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(msg -> logger.debug("YunBaOkHttp", msg));
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    @Bean(name = YUNBA_RETROFIT, autowire = Autowire.BY_NAME)
    public Retrofit yunbaApiRetrofit() {
        return new Retrofit
                .Builder()
                .client(yunbaOkHttpClient())
                .addConverterFactory(MyJacksonConverterFactory.create())
                .baseUrl(appConfiguration.getYunBaPushEntryPointUrl())
                .build();
    }

    @Autowired
    AppConfiguration appConfiguration;

    OkHttpClient http;

    PayloadFactory payloadBuilderFactory;

    @PostConstruct
    private void init() throws MalformedURLException {
        http = new OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.MILLISECONDS)
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor())
                .build();
        payloadBuilderFactory = new PayloadFactory(appConfiguration.getYunBaAppKey(), appConfiguration.getYunBaSecretKey());
    }

    public Call<PushState> sendToAlias(String msg, String alias) {
        YunBaPushService service = yunBaServiceImpl();
        return service.sendEndPayload(payloadBuilderFactory.createEndToEnd(msg, alias));
    }

    public Call<PushState> sendToAliases(String msg, List<String> aliases) {
        YunBaPushService service = yunBaServiceImpl();
        return service.sendEndsPayload(payloadBuilderFactory.createEndToEnds(msg, aliases));
    }

    @DependsOn({YUNBA_RETROFIT})
    @Qualifier
    @Bean
    public YunBaPushService yunBaServiceImpl() {
        return yunbaApiRetrofit().create(YunBaPushService.class);
    }

}
