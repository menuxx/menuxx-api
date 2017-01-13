package com.mall.service;

import com.mall.model.TUnitField;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface UnitFieldService {

    Map<Integer, TUnitField> selectUnitFieldsForMap(List<Integer> unitIdList);

    List<TUnitField> selectUnitFields(List<Integer> unitIdList);

    List<TUnitField> selectUnitFiledsByIds(List<Integer> fieldIdList);

    Map<Integer, TUnitField> selectUnitFiledsByIdsForMap(List<Integer> fieldIdList);
}
