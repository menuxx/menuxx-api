package com.mall.push;

import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

public class MyJacksonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final ObjectReader adapter;

    MyJacksonResponseBodyConverter(ObjectReader adapter) {
        this.adapter = adapter;
    }

    public T convert(ResponseBody value) throws IOException {
        Object var2;
        try {
            var2 = this.adapter.readValue(value.charStream());
        } finally {
            value.close();
        }

        return (T) var2;
    }
}
