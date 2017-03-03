package com.mall.weixin;

import com.mall.configure.WebConfiguration;
import com.mall.utils.Constants;
import com.thoughtworks.xstream.XStream;
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
import org.springframework.oxm.xstream.XStreamMarshaller;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
@Configuration
@AutoConfigureAfter(WebConfiguration.class)
public class WXPayConfiguration {

	public static final String WX_PAY_OK_HTTP = "WX_PAY_OK_HTTP";
	public static final String WX_PAY_RETROFIT = "WX_PAY_RETROFIT";

	static final Logger logger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);

	private HttpLoggingInterceptor loggingInterceptor() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor(msg -> logger.debug("WeixinPayOkHttp", msg));
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

	@Bean(name = WX_PAY_RETROFIT, autowire = Autowire.BY_NAME)
	public Retrofit wxPayRetrofit() {
		XStreamMarshaller xStreamMarshaller = Constants.getXStreamMarshaller();
		XStream xStream = xStreamMarshaller.getXStream();
		xStream.autodetectAnnotations(true);
		// CustomTrust trust = new CustomTrust();
		return new Retrofit.Builder()
				.baseUrl("https://api.mch.weixin.qq.com/")
				.addConverterFactory(XStreamXmlConverterFactory.create(xStream))
				.client(wxPayClient())
				.build();
	}

	@Bean
	public WXPayService wxPayService() {
		return wxPayRetrofit().create(WXPayService.class);
	}

}
