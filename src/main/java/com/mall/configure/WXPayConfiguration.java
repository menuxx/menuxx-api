package com.mall.configure;

import com.mall.weixin.WXPayService;
import com.mall.weixin.XStreamXmlConverterFactory;
import com.thoughtworks.xstream.XStream;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.oxm.xstream.XStreamMarshaller;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
@Configuration
public class WXPayConfiguration {

	static final Logger logger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);

	private HttpLoggingInterceptor loggingInterceptor() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
			@Override
			public void log(String msg) {
				logger.debug("WeixinPayOkHttp", msg);
			}
		});
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
		return logging;
	}

	public OkHttpClient wxPayClient() {
		return new OkHttpClient.Builder()
				.addInterceptor(loggingInterceptor())
				.readTimeout(500, TimeUnit.MILLISECONDS)
				.connectTimeout(300, TimeUnit.MILLISECONDS)
				.build();
	}

	@DependsOn("xStreamMarshaller")
	@Bean
	public Retrofit wxPayRetrofit(XStreamMarshaller marshaller) {
		XStream xStream = marshaller.getXStream();
		xStream.autodetectAnnotations(true);
		return new Retrofit.Builder()
				.baseUrl("https://api.mch.weixin.qq.com/")
				.addConverterFactory(XStreamXmlConverterFactory.create(xStream))
				.client(wxPayClient())
				.build();
	}

	@DependsOn("wxPayRetrofit")
	@Bean
	public WXPayService wxPayService(Retrofit wxPayRetrofit) {
		return wxPayRetrofit.create(WXPayService.class);
	}

}
