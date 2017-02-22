package com.mall.service.impl;

import com.mall.mapper.TCorpMapper;
import com.mall.model.TCorp;
import com.mall.service.CorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@Service
public class CorpsServiceImpl implements CorpsService {

	@Autowired
	TCorpMapper tCorpMapper;

	@Override
	public TCorp findByCorpId(int corpId) {
		return tCorpMapper.selectByPrimaryKey(corpId);
	}
}
