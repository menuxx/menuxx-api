package com.mall.service.impl;

import com.mall.mapper.TUnitMapper;
import com.mall.model.TUnit;
import com.mall.model.TUnitExample;
import com.mall.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    TUnitMapper unitMapper;

    @Override
    public List<TUnit> selectUnitsByCorp(int corpId) {
        TUnitExample example = new TUnitExample();
        TUnitExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return unitMapper.selectByExample(example);
    }

    @Override
    public Map<Integer, TUnit> selectUnitsForMapByCorp(int corpId) {
        List<TUnit> list = selectUnitsByCorp(corpId);

        Map<Integer, TUnit> map = new HashMap<>();

        if (list.size() > 0) {
            for (TUnit unit : list) {
                map.put(unit.getId(), unit);
            }
        }

        return map;
    }
}
