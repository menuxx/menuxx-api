package com.mall.service;

import com.mall.model.TColumnItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface ColumnItemService {

    List<TColumnItem> selectColumnItems(int columnId);

    void createColumnItem(TColumnItem columnItem);

    int removeColumnItem(int columnItemId);

    Map<Integer, List<TColumnItem>> selectColumnsByGroup(List<Integer> columnIdList);
}
