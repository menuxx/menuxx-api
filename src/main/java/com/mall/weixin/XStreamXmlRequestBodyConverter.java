package com.mall.weixin;

import com.thoughtworks.xstream.XStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
public class XStreamXmlRequestBodyConverter<T> implements Converter<T, RequestBody> {

	private static final MediaType MEDIA_TYPE = MediaType.parse("application/xml; charset=UTF-8");
	private static final String CHARSET = "UTF-8";

	private final XStream xStream;

	XStreamXmlRequestBodyConverter(XStream xStream) {
		this.xStream = xStream;
	}

	@Override
	public RequestBody convert(T value) throws IOException {

		Buffer buffer = new Buffer();

		try {
			OutputStreamWriter osw = new OutputStreamWriter(buffer.outputStream(), CHARSET);
			xStream.toXML(value, osw);
			osw.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
	}

}
