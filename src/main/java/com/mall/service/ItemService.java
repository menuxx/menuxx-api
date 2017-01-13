package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.model.TItem;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface ItemService {

    List<TItem> selectItems(List<Integer> itemIdList);

    PageInfo<TItem> selectItemsByCategory(int categoryId);

    TItem selectItem(int itemId);
}
