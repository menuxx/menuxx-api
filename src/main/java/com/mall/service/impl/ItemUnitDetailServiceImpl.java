package com.mall.service.impl;

import com.mall.mapper.TItemUnitDetailMapper;
import com.mall.model.TItemUnitDetail;
import com.mall.model.TItemUnitDetailExample;
import com.mall.service.ItemUnitDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
