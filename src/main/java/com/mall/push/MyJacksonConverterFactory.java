package com.mall.push;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by yinchangsheng on 2017/5/20.
 */
public class MyJacksonConverterFactory extends Factory {
    private final ObjectMapper mapper;

    public static MyJacksonConverterFactory create() {
        return create(new ObjectMapper());
    }

    public static MyJacksonConverterFactory create(ObjectMapper mapper) {
        return new MyJacksonConverterFactory(mapper);
    }

    private MyJacksonConverterFactory(ObjectMapper mapper) {
        if(mapper == null) {
            throw new NullPointerException("mapper == null");
        } else {
            this.mapper = mapper;
        }
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        JavaType javaType = this.mapper.getTypeFactory().constructType(type);
        ObjectReader reader = this.mapper.readerFor(javaType);
        return new MyJacksonResponseBodyConverter<>(reader);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        JavaType javaType = this.mapper.getTypeFactory().constructType(type);
        ObjectWriter writer = this.mapper.writerFor(javaType);
        return new MyJacksonRequestBodyConverter<>(writer);
    }
}
