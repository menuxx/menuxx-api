package com.mall.service;

import com.mall.model.TCorp;
import com.mall.model.TUser;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
public interface UserService {

	int saveUser(TUser user, TCorp corp);

	int updateUserToConsume(int userId);

	TUser selectUser(int userId);

}
