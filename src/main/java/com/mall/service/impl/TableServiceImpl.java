package com.mall.service.impl;

import com.mall.mapper.TTableMapper;
import com.mall.model.TTable;
import com.mall.model.TTableExample;
import com.mall.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    TTableMapper tableMapper;

    @Override
    public List<TTable> selectTablesByCorp(int corpId) {
        TTableExample example = new TTableExample();
        TTableExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return tableMapper.selectByExample(example);
    }

    @Override
    public Map<Integer, TTable> selectTablesByCorpForMap(int corpId) {
        List<TTable> list = selectTablesByCorp(corpId);

        Map<Integer, TTable> map = new HashMap<>();

        for (TTable table : list) {
            map.put(table.getId(), table);
        }

        return map;
    }
}
