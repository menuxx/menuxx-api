package com.mall.wrapper.impl;

import com.mall.model.Category;
import com.mall.model.Item;
import com.mall.model.TCategory;
import com.mall.model.TItem;
import com.mall.service.CategoryService;
import com.mall.service.ItemService;
import com.mall.utils.Constants;
import com.mall.wrapper.ItemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class ItemWrapperImpl implements ItemWrapper {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @Override
    public Map<Integer, List<TItem>> selectItemsByCorp(int corpId) {
        Map<Integer, List<TItem>> map = new HashMap<>();

        List<TItem> list = itemService.selectItemsByCorp(corpId);

        if (list.size() > 0) {
            for (TItem item : list) {
                int categoryId = item.getCategoryId();

                if (map.containsKey(categoryId)) {
                    map.get(categoryId).add(item);
                } else {
                    List<TItem> tempList = new ArrayList<>();
                    tempList.add(item);
                    map.put(categoryId, tempList);
                }
            }
        }

        return map;
    }


    @Override
    public List<Item> selectItems(int corpId) {
        List<TItem> tItemList = itemService.selectItemsByCorp(corpId);

        List<Item> itemList = new ArrayList<>();

        Map<Integer, TCategory> categoryMap = categoryService.selectCategoriesByCorpForMap(corpId);

        if (tItemList.size() > 0) {
            for (TItem tItem : tItemList) {
                Item item = new Item(tItem);

                TCategory category = categoryMap.get(item.getCategoryId());
                item.setCategory(category);

                itemList.add(item);
            }
        }

        return itemList;
    }

    @Override
    public void setSoldout(int itemId) {
        itemService.updateItemSoldout(itemId, Constants.ONE);
    }

    @Override
    public void cancelSoldout(int itemId) {
        itemService.updateItemSoldout(itemId, Constants.ZERO);
    }

    @Override
    public Item selectItem(int itemId) {
        TItem titem = itemService.selectItem(itemId);

        if (null != titem) {
            Item item = new Item(titem);

            TCategory category = categoryService.selectCategory(item.getCategoryId());
            item.setCategory(category);

            return item;
        }

        return null;
    }
}
