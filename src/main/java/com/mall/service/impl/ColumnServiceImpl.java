package com.mall.service.impl;

import com.mall.mapper.TColumnMapper;
import com.mall.model.TColumn;
import com.mall.model.TColumnExample;
import com.mall.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
@Controller
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    TColumnMapper columnMapper;

    @Override
    public List<TColumn> selectAllColumns(int corpId) {
        TColumnExample example = new TColumnExample();
        TColumnExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("sort_id ASC");
        criteria.andCorpIdEqualTo(corpId);

        return columnMapper.selectByExample(example);
    }

    @Override
    public TColumn createColumn(TColumn column) {
        columnMapper.insert(column);
        return column;
    }

    @Override
    public int removeColumn(int columnId) {
        return columnMapper.deleteByPrimaryKey(columnId);
    }
}
