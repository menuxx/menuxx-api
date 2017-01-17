package com.mall.service.impl;

import com.mall.mapper.TItemUnitDetailMapper;
import com.mall.model.TItemUnitDetail;
import com.mall.model.TItemUnitDetailExample;
import com.mall.service.ItemUnitDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class ItemUnitDetailServiceImpl implements ItemUnitDetailService {

    @Autowired
    TItemUnitDetailMapper itemUnitDetailMapper;

    @Override
    public List<TItemUnitDetail> selectUnitDetailByItem(int itemId) {
        TItemUnitDetailExample example = new TItemUnitDetailExample();
        TItemUnitDetailExample.Criteria criteria = example.createCriteria();

        criteria.andItemIdEqualTo(itemId);

        return itemUnitDetailMapper.selectByExample(example);
    }

    @Override
    public List<TItemUnitDetail> selectUnitDetailByItemIds(List<Integer> itemIdList) {
        TItemUnitDetailExample example = new TItemUnitDetailExample();
        TItemUnitDetailExample.Criteria criteria = example.createCriteria();

        criteria.andItemIdIn(itemIdList);

        return itemUnitDetailMapper.selectByExample(example);
    }

    @Override
    public Map<Integer, TItemUnitDetail> selectUnitDetailByItemIdsForMap(List<Integer> itemIdList) {
        List<TItemUnitDetail> list = selectUnitDetailByItemIds(itemIdList);

        Map<Integer, TItemUnitDetail> map = new HashMap<>();

        for (TItemUnitDetail detail : list) {
            map.put(detail.getId(), detail);
        }

        return map;
    }
}
