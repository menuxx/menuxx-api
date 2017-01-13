package com.mall.service.impl;

import com.mall.mapper.TUnitFieldMapper;
import com.mall.model.TUnitField;
import com.mall.model.TUnitFieldExample;
import com.mall.service.UnitFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class UnitFieldServiceImpl implements UnitFieldService {

    @Autowired
    TUnitFieldMapper unitFieldMapper;

    @Override
    public Map<Integer, TUnitField> selectUnitFieldsForMap(List<Integer> unitIdList) {
        Map<Integer, TUnitField> map = new HashMap<>();

        List<TUnitField> list = selectUnitFields(unitIdList);

        if (list.size() > 0) {
            for (TUnitField unitField : list) {
                map.put(unitField.getId(), unitField);
            }
        }

        return map;
    }

    @Override
    public List<TUnitField> selectUnitFields(List<Integer> unitIdList) {
        TUnitFieldExample example = new TUnitFieldExample();
        TUnitFieldExample.Criteria criteria = example.createCriteria();

        criteria.andUnitIdIn(unitIdList);

        List<TUnitField> list = unitFieldMapper.selectByExample(example);

        return list;
    }

    @Override
    public List<TUnitField> selectUnitFiledsByIds(List<Integer> fieldIdList) {
        TUnitFieldExample example = new TUnitFieldExample();
        TUnitFieldExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(fieldIdList);

        List<TUnitField> list = unitFieldMapper.selectByExample(example);

        return list;
    }

    @Override
    public Map<Integer, TUnitField> selectUnitFiledsByIdsForMap(List<Integer> fieldIdList) {
        Map<Integer, TUnitField> map = new HashMap<>();

        List<TUnitField> list = selectUnitFiledsByIds(fieldIdList);

        if (list.size() > 0) {
            for (TUnitField unitField : list) {
                map.put(unitField.getId(), unitField);
            }
        }

        return map;
    }
}
