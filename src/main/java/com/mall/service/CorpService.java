package com.mall.service;

import com.mall.model.TCorp;
import com.mall.model.TShopConfig;

import java.util.List;
import java.util.Map;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */

public interface CorpService {

	TShopConfig selectShopConfig(int shopId);

	TCorp selectCorpByCorpId(int corpId);

	TCorp selectCorpByMchId(String mchId);

	Map<String, Object> selectCorpForMap(int corpId);

	List<Map<String, Object>> selectEnterCorp();

	List<Map<String, Object>> selectEnterCorp(int corpId);

	List<TCorp> selectAllCorps();

	Map<String, Object> getByAppkey(String appid);

	Map<String, Object> getByAppid(String appkey);

	List<Map<String, ?>> getAuthorizerDiners();

	void updateByAppid(String appid, TCorp corp);

	void updateByAppkey(String appkey, TCorp corp);

}
