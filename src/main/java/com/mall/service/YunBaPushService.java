package com.mall.service;

import com.mall.push.EndToEndPayload;
import com.mall.push.EndToEndsPayload;
import com.mall.push.PushState;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface YunBaPushService {

    @POST("/")
    Call<PushState> sendEndPayload(@Body EndToEndPayload payload);

    @POST("/")
    Call<PushState> sendEndsPayload(@Body EndToEndsPayload payload);

}
