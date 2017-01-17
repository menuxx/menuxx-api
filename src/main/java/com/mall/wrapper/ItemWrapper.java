package com.mall.wrapper;

import com.github.pagehelper.PageInfo;
import com.mall.model.Item;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemWrapper {

    Item getItemDetail(int corpId, int itemId);

    List<Item> selectItems(List<Integer> itemIdList);

    Map<Integer, Item> selectItemsForMap(List<Integer> itemIdList);

    PageInfo<Item> selectItemsByCategory(int categoryId);
}
