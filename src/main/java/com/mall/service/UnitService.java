package com.mall.service;

import com.mall.model.TUnit;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface UnitService {

    List<TUnit> selectUnitsByCorp(int corpId);

    Map<Integer, TUnit> selectUnitsForMapByCorp(int corpId);

    List<TUnit> selectUnitsByIds(List<Integer> unitIdList);

    Map<Integer, TUnit> selectUnitsByIdsForMap(List<Integer> unitIdList);

}
