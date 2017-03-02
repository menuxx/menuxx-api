package com.mall.weixin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
public interface WXPayService {

	@POST("pay/unifiedorder")
	Call<WXPayResult> unifiedorder(@Body WXPayOrder payOrder);

}
