package com.mall.service;

import com.mall.model.TItemUnit;

import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemUnitService {

    List<TItemUnit> selectItemUnits(int itemId);

    List<TItemUnit> selectItemUnitsByItemIds(List<Integer> itemIdList);

}
