package com.mall.push;

import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;

/**
 * Created by yinchangsheng on 2017/5/20.
 */
public class MyJacksonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    private final ObjectWriter adapter;

    MyJacksonRequestBodyConverter(ObjectWriter adapter) {
        this.adapter = adapter;
    }

    public RequestBody convert(T value) throws IOException {
        byte[] bytes = this.adapter.writeValueAsBytes(value);
        return RequestBody.create(MEDIA_TYPE, bytes);
    }

}
