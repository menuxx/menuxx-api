package com.mall.weixin;

import com.thoughtworks.xstream.XStream;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
public class XStreamXmlResponseBodyConverter <T> implements Converter<ResponseBody, T> {

	private final Class<T> cls;
	private final XStream xStream;

	XStreamXmlResponseBodyConverter(Class<T> cls, XStream xStream) {
		this.cls = cls;
		this.xStream = xStream;
	}

	@Override
	public T convert(ResponseBody value) throws IOException {

		try {

			this.xStream.processAnnotations(cls);
			Object object =  this.xStream.fromXML(value.byteStream());
			return (T) object;

		}finally {
			value.close();
		}
	}

}
