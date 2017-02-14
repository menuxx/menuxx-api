package com.mall.service.impl;

import com.mall.mapper.TTableMapper;
import com.mall.model.TTable;
import com.mall.model.TTableExample;
import com.mall.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
