package com.mall.wrapper;

import com.mall.model.ItemUnitDetail;

import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemUnitDetailWrapper {

    List<ItemUnitDetail> selectItemUnitDetailByItem(int itemId);
}
