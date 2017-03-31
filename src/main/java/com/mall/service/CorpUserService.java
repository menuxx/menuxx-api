package com.mall.service;

import com.mall.model.TCorpUser;

import java.util.List;

/**
 * Created by Supeng on 15/03/2017.
 */
public interface CorpUserService {

    List<TCorpUser> selectCorpUsersByCorpId(int corpId);

    TCorpUser selectCorpUserByMobile(String mobile);

    void updateCorpUser(TCorpUser corpUser);

    TCorpUser selectCorpUser(int corpUserId);

    void createCorpUser(TCorpUser corpUser);

}
