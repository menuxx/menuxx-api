package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mall.mapper.TItemMapper;
import com.mall.model.TItem;
import com.mall.model.TItemExample;
import com.mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TItemMapper itemMapper;

    @Override
    public List<TItem> selectItems(List<Integer> itemIdList) {
        TItemExample example = new TItemExample();
        TItemExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(itemIdList);

        List<TItem> itemList = itemMapper.selectByExample(example);

        return itemList;
    }

    @Override
    public Map<Integer, TItem> selectItemsForMap(List<Integer> itemIdList) {
        List<TItem> list = selectItems(itemIdList);

        Map<Integer, TItem> map = new HashMap<>();

        for (TItem item : list) {
            map.put(item.getId(), item);
        }

        return map;
    }

    @Override
    public PageInfo<TItem> selectItemsByCategory(int categoryId) {
        TItemExample example = new TItemExample();
        TItemExample.Criteria criteria = example.createCriteria();

        criteria.andCategoryIdEqualTo(categoryId);

        PageInfo<TItem> pageInfo = new PageInfo<>(itemMapper.selectByExample(example));

        return pageInfo;
    }

    @Override
    public TItem selectItem(int itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }
}
