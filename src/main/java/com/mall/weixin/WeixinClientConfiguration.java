package com.mall.weixin;

import com.mall.configure.WebConfiguration;
import com.mall.service.WXMiniService;
import com.mall.weixin.component.WXComponentApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@Configuration
@AutoConfigureAfter(WebConfiguration.class)
public class WeixinClientConfiguration {

	public static final String WX_OK_HTTP = "WX_OK_HTTP";
	public static final String WX_RETROFIT = "WX_RETROFIT";

	static final Logger logger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);

	public OkHttpClient wxOkHttpClient() {
		return new OkHttpClient.Builder()
				.addInterceptor(loggingInterceptor())
				.connectTimeout(300, TimeUnit.MILLISECONDS)
				.readTimeout(500, TimeUnit.MILLISECONDS)
				.build();
	}

	private HttpLoggingInterceptor loggingInterceptor() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor(msg -> logger.debug("WeixinOkHttp", msg));
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		return logging;
	}

	@Bean(name = WX_RETROFIT, autowire = Autowire.BY_NAME)
	public Retrofit wxApiRetrofit() {
		return new Retrofit
				.Builder()
				.client(wxOkHttpClient())
				.addConverterFactory(JacksonConverterFactory.create())
				.baseUrl("https://api.weixin.qq.com/sns/")
				.build();
	}

	@DependsOn({WX_RETROFIT})
	@Qualifier
	@Bean
	public WXMiniService wxMiniServiceImpl() {
		return wxApiRetrofit().create(WXMiniService.class);
	}

	@DependsOn({WX_RETROFIT})
	@Qualifier
	@Bean
	public WXComponentApiService wxComponentServiceImpl() {
		return wxApiRetrofit().create(WXComponentApiService.class);
	}

}
