package com.mall.service;

import com.mall.model.TTopup;

import java.util.List;

/**
 * Created by Supeng on 08/05/2017.
 */
public interface TopupService {

    List<TTopup> selectTopups(int corpId);
}
