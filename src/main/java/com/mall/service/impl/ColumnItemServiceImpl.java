package com.mall.service.impl;

import com.mall.mapper.TColumnItemMapper;
import com.mall.model.TColumnItem;
import com.mall.model.TColumnItemExample;
import com.mall.service.ColumnItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class ColumnItemServiceImpl implements ColumnItemService {

    @Autowired
    TColumnItemMapper columnItemMapper;


    @Override
    public List<TColumnItem> selectColumnItems(int columnId) {
        TColumnItemExample example = new TColumnItemExample();
        TColumnItemExample.Criteria criteria = example.createCriteria();

        criteria.andColumnIdEqualTo(columnId);

        return columnItemMapper.selectByExample(example);
    }

    @Override
    public void createColumnItem(TColumnItem columnItem) {
        columnItemMapper.insert(columnItem);
    }

    @Override
    public int removeColumnItem(int columnItemId) {
        return columnItemMapper.deleteByPrimaryKey(columnItemId);
    }

    @Override
    public Map<Integer, List<TColumnItem>> selectColumnsByGroup(List<Integer> columnIdList) {
        TColumnItemExample example = new TColumnItemExample();
        TColumnItemExample.Criteria criteria = example.createCriteria();

        criteria.andColumnIdIn(columnIdList);

        List<TColumnItem> itemList = columnItemMapper.selectByExample(example);

        Map<Integer, List<TColumnItem>> groupMap = new HashMap<>();

        if (itemList.size() > 0) {
            for (TColumnItem columnItem : itemList) {
                int columnId = columnItem.getColumnId();

                if (groupMap.containsKey(columnId)) {
                    List<TColumnItem> tempList = groupMap.get(columnId);
                    tempList.add(columnItem);
                } else {
                    List<TColumnItem> tempList = new ArrayList<>();
                    tempList.add(columnItem);

                    groupMap.put(columnId, tempList);
                }
            }
        }

        return groupMap;
    }
}
