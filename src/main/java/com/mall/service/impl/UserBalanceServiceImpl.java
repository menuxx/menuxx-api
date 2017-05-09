package com.mall.service.impl;

import com.mall.mapper.TUserBalanceMapper;
import com.mall.model.TUserBalance;
import com.mall.model.TUserBalanceExample;
import com.mall.service.UserBalanceService;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 09/05/2017.
 */
@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    @Autowired
    TUserBalanceMapper userBalanceMapper;

    @Override
    public TUserBalance selectUserBalance(int userId, int corpId) {
        TUserBalanceExample example = new TUserBalanceExample();
        TUserBalanceExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId).andCorpIdEqualTo(corpId);

        TUserBalance userBalance = Util.onlyOne(userBalanceMapper.selectByExample(example));
        return userBalance;
    }

    @Override
    public int increaseBalance(int userId, int corpId, int amount) {
        TUserBalance balance = selectUserBalance(userId, corpId);

        if (balance == null) {
            balance = new TUserBalance();
            balance.setBalance(amount);
            balance.setUserId(userId);
            balance.setCorpId(corpId);
            userBalanceMapper.insert(balance);
        } else {
            balance.setBalance(balance.getBalance() + amount);
            userBalanceMapper.updateByPrimaryKey(balance);
        }

        return balance.getBalance();
    }

    @Override
    public int reduceBalance(int userId, int corpId, int amount) {
        TUserBalance balance = selectUserBalance(userId, corpId);

        if (balance != null) {
            int k = balance.getBalance() - amount;

            if (k < 0) {
                k = 0;
            }

            balance.setBalance(k);

            userBalanceMapper.updateByPrimaryKey(balance);
        }

        return balance.getBalance();
    }
}
