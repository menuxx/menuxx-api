package com.mall.service.impl;

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
    public List<TItem> selectItemsByCorp(int corpId) {
        TItemExample example = new TItemExample();
        TItemExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return itemMapper.selectByExample(example);
    }
}
