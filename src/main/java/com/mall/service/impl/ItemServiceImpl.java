package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mall.mapper.TItemMapper;
import com.mall.model.TItem;
import com.mall.model.TItemExample;
import com.mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
