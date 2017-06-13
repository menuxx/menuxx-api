package com.mall.service.impl;

import com.mall.mapper.TCorpMapper;
import com.mall.model.TCorp;
import com.mall.model.TCorpExample;
import com.mall.service.CorpService;
import com.mall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
	public TCorp selectCorpByCorpId(int corpId) {
		return tCorpMapper.selectByPrimaryKey(corpId);
	}

	@Override
	public TCorp selectCorpByMchId(String mchId) {
		TCorpExample example = new TCorpExample();
		TCorpExample.Criteria criteria = example.createCriteria();
		
		criteria.andMchIdEqualTo(mchId);
		
		TCorp corp = onlyOne(tCorpMapper.selectByExample(example));
		
		return corp;
	}

	@Override
	public Map<String, Object> selectCorpForMap(int corpId) {
		TCorp corp = selectCorpByCorpId(corpId);
		return buildCorp2Map(corp);
	}

	@Override
	public List<Map<String, Object>> selectEnterCorp() {
		TCorpExample example = new TCorpExample();
		TCorpExample.Criteria criteria = example.createCriteria();

		criteria.andCorpTypeEqualTo(Constants.CORP_TYPE_ENTER);

		List<TCorp> list =  tCorpMapper.selectByExample(example);

		return buildCorp2Map(list);
	}

	@Override
	public List<Map<String, Object>> selectEnterCorp(int corpId) {
		TCorpExample example = new TCorpExample();
		TCorpExample.Criteria criteria = example.createCriteria();

		criteria.andCorpTypeEqualTo(Constants.CORP_TYPE_ENTER);
		criteria.andPlatformIdEqualTo(corpId);

		List<TCorp> list =  tCorpMapper.selectByExample(example);

		return buildCorp2Map(list);
	}

	private List<Map<String, Object>> buildCorp2Map(List<TCorp> list) {
		List<Map<String, Object>> mapList = new ArrayList<>();

		for (TCorp corp : list) {
			mapList.add(buildCorp2Map(corp));
		}

		return mapList;
	}

	private Map<String, Object> buildCorp2Map(TCorp corp) {
		Map<String, Object> map = new HashMap();
		if (null != corp) {
			map.put("id", corp.getId());
			map.put("appKey", corp.getAppKey());
			map.put("address", corp.getAddress());
			map.put("corpPhone", corp.getCorpPhone());
			map.put("email", corp.getEmail());
			map.put("businessHours", corp.getBusinessHours());
			map.put("shopName", corp.getShopName());
			map.put("masterName", corp.getMasterName());
			map.put("corpType", corp.getCorpType());
			map.put("lat", corp.getLat());
			map.put("lon", corp.getLon());
			map.put("logoPath", corp.getLogoPath());
		}
		return map;
	}

	private Map<String, Object> buildCorp23rdMap(TCorp corp) {
		Map<String, Object> map = new HashMap<>();
		if (null != corp) {
			map.put("shopName", corp.getShopName());
			map.put("masterName", corp.getMasterName());
			map.put("masterPhone", corp.getMasterPhone());
			map.put("appKey", corp.getAppKey());
			map.put("authorizerAppid", corp.getAuthorizerAppid());
			map.put("authorizerStatus", corp.getAuthorizerStatus());
			map.put("wxliteTemplateId", corp.getWxliteTemplateId());
			map.put("wxliteVersion", corp.getWxliteVersion());
			map.put("wxliteStatus", corp.getWxliteStatus());
			map.put("originAppId", corp.getOriginAppId());
		}
		return map;
	}


	@Override
	public List<TCorp> selectAllCorps() {
		return tCorpMapper.selectByExample(new TCorpExample());
	}

	@Override
	public Map<String, Object> getByAppkey(String appkey) {
		TCorpExample ex = new TCorpExample();
		ex.createCriteria().andAppKeyEqualTo(appkey);
		List<TCorp> corps = tCorpMapper.selectByExample(ex);
		if (corps != null && corps.size() > 0) {
			return buildCorp23rdMap(corps.get(0));
		}
		return null;
	}

	@Override
	public Map<String, Object> getByAppid(String appid) {
		TCorpExample ex = new TCorpExample();
		ex.createCriteria().andAuthorizerAppidEqualTo(appid);
		List<TCorp> corps = tCorpMapper.selectByExample(ex);
		if (corps != null && corps.size() > 0) {
			return buildCorp23rdMap(corps.get(0));
		}
		return null;
	}

	@Override
	public List<Map<String, ?>> getAuthorizerDiners() {
		TCorpExample ex = new TCorpExample();
		ex.createCriteria().andCorpTypeEqualTo(0);
		List<TCorp> corps = tCorpMapper.selectByExample(ex);
		List<Map<String, ?>> _corps = new ArrayList<>();
		for (TCorp corp : corps) {
			_corps.add(buildCorp23rdMap(corp));
		}
		return _corps;
	}

	@Override
	public void updateByAppid(String appid, TCorp corp) {
		TCorpExample ex = new TCorpExample();
		ex.createCriteria().andAuthorizerAppidEqualTo(appid);
		TCorp corp1 = new TCorp();
		corp1.setWxliteStatus(corp.getWxliteStatus());
		corp1.setWxliteVersion(corp.getWxliteVersion());
		corp1.setAuthorizerAppid(corp.getAuthorizerAppid());
		corp1.setAuthorizerStatus(corp.getAuthorizerStatus());
		tCorpMapper.updateByExampleSelective(corp1, ex);
	}

	@Override
	public void updateByAppkey(String appkey, TCorp corp) {
		TCorpExample ex = new TCorpExample();
		ex.createCriteria().andAppKeyEqualTo(appkey);
		TCorp corp1 = new TCorp();
		corp1.setWxliteStatus(corp.getWxliteStatus());
		corp1.setWxliteVersion(corp.getWxliteVersion());
		corp1.setAuthorizerAppid(corp.getAuthorizerAppid());
		corp1.setAuthorizerStatus(corp.getAuthorizerStatus());
		tCorpMapper.updateByExampleSelective(corp1, ex);
	}
}
