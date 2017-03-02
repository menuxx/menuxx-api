package com.mall.weixin;

import com.mall.service.WXMiniService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
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
public class WeixinClientConfiguration {

	public static final String WX_OK_HTTP = "WX_OK_HTTP";
	public static final String WX_RETROFIT = "WX_RETROFIT";

	static final Logger logger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);

	@Bean(name = WX_OK_HTTP, autowire = Autowire.BY_NAME)
	public OkHttpClient wxOkHttpClient() {
		return new OkHttpClient.Builder()
				.addInterceptor(loggingInterceptor())
				.connectTimeout(300, TimeUnit.MILLISECONDS)
				.readTimeout(500, TimeUnit.MILLISECONDS)
				.build();
	}

	private HttpLoggingInterceptor loggingInterceptor() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
			@Override
			public void log(String msg) {
				logger.debug("WeixinOkHttp", msg);
			}
		});
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
		return logging;
	}

	@Bean(name = WX_RETROFIT, autowire = Autowire.BY_NAME)
	public Retrofit wxApiRetrofit() {
		return new Retrofit
				.Builder()
				.addConverterFactory(JacksonConverterFactory.create())
				.baseUrl("https://api.weixin.qq.com/sns/")
				.build();
	}

	@DependsOn({WX_RETROFIT})
	@Bean(name = "wxMiniServiceImpl", autowire = Autowire.BY_NAME)
	public WXMiniService wxMiniServiceImpl(Retrofit wxApiRetrofit) {
		return wxApiRetrofit.create(WXMiniService.class);
	}

}
