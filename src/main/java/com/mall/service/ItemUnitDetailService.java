package com.mall.service;

import com.mall.model.TItemUnitDetail;

import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemUnitDetailService {

    List<TItemUnitDetail> selectUnitDetailByItem(int itemId);
}
