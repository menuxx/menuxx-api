package com.mall.service.impl;

import com.mall.mapper.TItemMapper;
import com.mall.model.Item;
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
    public List<TItem> selectItemsByCorp(int corpId) {
        TItemExample example = new TItemExample();
        TItemExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return itemMapper.selectByExample(example);
    }

    @Override
    public List<TItem> selectSellItemsByCorp(int corpId) {
        TItemExample example = new TItemExample();
        TItemExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);
        criteria.andSoldoutEqualTo(Item.SELLING);

        return itemMapper.selectByExample(example);
    }

    @Override
    public List<TItem> selectItems(List<Integer> itemIdList) {
        TItemExample example = new TItemExample();
        TItemExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(itemIdList);

        return itemMapper.selectByExample(example);
    }

    @Override
    public Map<Integer, TItem> selectItemsForMap(List<Integer> itemIdList) {
        List<TItem> itemList = selectItems(itemIdList);

        Map<Integer, TItem> map = new HashMap<>();

        if (itemList.size() > 0) {
            for (TItem item : itemList) {
                map.put(item.getId(), item);
            }
        }

        return map;
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKey(item);
    }

    @Override
    public void updateItemSoldout(int itemId, int soldout) {
        Item item = new Item();
        item.setId(itemId);
        item.setSoldout(soldout);

        itemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public TItem selectItem(int itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public void createItem(Item item) {
        itemMapper.insert(item);
    }

}
