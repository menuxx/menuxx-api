package com.mall.wrapper.impl;

import com.mall.model.TItem;
import com.mall.service.ItemService;
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
}
