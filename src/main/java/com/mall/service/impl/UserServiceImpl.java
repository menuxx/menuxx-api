package com.mall.service.impl;

import com.mall.mapper.TUserMapper;
import com.mall.model.TCorp;
import com.mall.model.TUser;
import com.mall.model.TUserExample;
import com.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mall.utils.Util.onlyOne;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	TUserMapper tUserMapper;

	@Override
	public int saveUser(TUser user, TCorp corp) {
		TUserExample ex = new TUserExample();
		ex.createCriteria().andOpenidEqualTo(user.getOpenid());
		TUser existsUser = onlyOne(tUserMapper.selectByExample(ex));
		// 用户不存在
		user.setCorpId(corp.getId());
		if ( existsUser == null ) {
			tUserMapper.insertSelective(user);
		} else {
			tUserMapper.updateByExampleSelective(user, ex);
		}
		return user.getId();
	}
}
