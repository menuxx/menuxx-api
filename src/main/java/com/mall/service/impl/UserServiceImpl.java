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

	public TUser getUserOfCorp(String userOpenid, Integer corpId) {
		TUserExample ex = new TUserExample();
		ex.createCriteria().andCorpIdEqualTo(corpId).andOpenidEqualTo(userOpenid);
		return onlyOne(tUserMapper.selectByExample(ex));
	}

	@Override
	public int saveUser(TUser user, TCorp corp) {
		TUserExample ex = new TUserExample();
		ex.createCriteria().andCorpIdEqualTo(corp.getId()).andOpenidEqualTo(user.getOpenid());
		TUser existsUser = onlyOne(tUserMapper.selectByExample(ex));
		// 用户不存在
		user.setCorpId(corp.getId());
		if ( existsUser == null ) {
			user.setBalance(0);
			tUserMapper.insertSelective(user);
		} else {
			tUserMapper.updateByExampleSelective(user, ex);
			TUser _user = onlyOne(tUserMapper.selectByExample(ex));
			user.setId(_user.getId());
		}
		return user.getId();
	}

	@Override
	public int updateUserToConsume(int userId) {
		TUser user = new TUser();
		user.setConsumed(1);
		user.setId(userId);
		return tUserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public TUser selectUser(int userId) {
		return tUserMapper.selectByPrimaryKey(userId);
	}

}
