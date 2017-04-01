package com.mall.service;

import com.mall.model.TCorp;

import java.util.List;
import java.util.Map;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */

public interface CorpService {

	TCorp selectCorpByCorpId(int corpId);

	TCorp selectCorpByMchId(String mchId);

	Map<String, Object> selectCorpForMap(int corpId);

	List<Map<String, Object>> selectEnterCorp();
}
