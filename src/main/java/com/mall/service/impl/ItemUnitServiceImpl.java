package com.mall.service.impl;

import com.mall.mapper.TItemUnitMapper;
import com.mall.model.TItemUnit;
import com.mall.model.TItemUnitExample;
import com.mall.service.ItemUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class ItemUnitServiceImpl implements ItemUnitService {

    @Autowired
    TItemUnitMapper itemUnitMapper;


    @Override
    public List<TItemUnit> selectItemUnits(int itemId) {
        TItemUnitExample example = new TItemUnitExample();
        TItemUnitExample.Criteria criteria = example.createCriteria();

        criteria.andItemIdEqualTo(itemId);

        return itemUnitMapper.selectByExample(example);
    }
}
