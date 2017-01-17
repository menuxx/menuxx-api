package com.mall.service;

import com.mall.model.TItemUnitDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemUnitDetailService {

    List<TItemUnitDetail> selectUnitDetailByItem(int itemId);

    List<TItemUnitDetail> selectUnitDetailByItemIds(List<Integer> itemIdList);

    Map<Integer, TItemUnitDetail> selectUnitDetailByItemIdsForMap(List<Integer> itemIdList);
}
