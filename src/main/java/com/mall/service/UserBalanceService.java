package com.mall.service;

import com.mall.model.TUserBalance;

/**
 * Created by Supeng on 09/05/2017.
 */
public interface UserBalanceService {

    TUserBalance selectUserBalance(int userId, int corpId);

    int increaseBalance(int userId, int corpId, int amount);

    int reduceBalance(int userId, int corpId, int amount);
}
