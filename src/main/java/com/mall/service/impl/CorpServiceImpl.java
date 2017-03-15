package com.mall.service.impl;

import com.mall.mapper.TCorpMapper;
import com.mall.model.TCorp;
import com.mall.model.TCorpExample;
import com.mall.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mall.utils.Util.onlyOne;
/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@Service
public class CorpServiceImpl implements CorpService {

	@Autowired
	TCorpMapper tCorpMapper;

	@Override
	public TCorp findByCorpId(int corpId) {
		return tCorpMapper.selectByPrimaryKey(corpId);
	}

	@Override
	public TCorp findByMchId(String mchId) {
		TCorpExample example = new TCorpExample();
		TCorpExample.Criteria criteria = example.createCriteria();
		
		criteria.andMchIdEqualTo(mchId);
		
		TCorp corp = onlyOne(tCorpMapper.selectByExample(example));
		
		return corp;
	}
}
