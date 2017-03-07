package com.mall.weixin;

import com.thoughtworks.xstream.XStream;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 * https://gist.github.com/andersonkxiass/bb86f0cd0910f243656d457a0ca45ec7
 */
public class XStreamXmlConverterFactory extends Converter.Factory {

	/** Create an instance using a default {@link XStream} instance for conversion. */
	public static XStreamXmlConverterFactory create() {
		return create(new XStream());
	}

	/** Create an instance using {@code xStream} for conversion. */
	public static XStreamXmlConverterFactory create(XStream xStream) {
		return new XStreamXmlConverterFactory(xStream);
	}

	private final XStream xStream;

	private XStreamXmlConverterFactory(XStream xStream) {
		if (xStream == null) throw new NullPointerException("xStream == null");
		this.xStream = xStream;
	}

	@Override
	public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

		if (!(type instanceof Class)) {
			return null;
		}

		Class<?> cls = (Class<?>) type;

		return new XStreamXmlResponseBodyConverter<>(cls, xStream);
	}

	@Override
	public Converter<?, RequestBody> requestBodyConverter(Type type,
																												Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {

		if (!(type instanceof Class)) {
			return null;
		}

		return new XStreamXmlRequestBodyConverter<>(xStream);
	}

}
