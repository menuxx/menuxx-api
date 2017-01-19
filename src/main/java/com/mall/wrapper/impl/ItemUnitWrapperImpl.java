package com.mall.wrapper.impl;

import com.mall.model.ItemUnit;
import com.mall.model.TItemUnit;
import com.mall.model.TUnit;
import com.mall.model.TUnitField;
import com.mall.service.ItemUnitService;
import com.mall.service.UnitFieldService;
import com.mall.service.UnitService;
import com.mall.wrapper.ItemUnitWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 19/01/2017.
 */
@Service
public class ItemUnitWrapperImpl implements ItemUnitWrapper {

    @Autowired
    ItemUnitService itemUnitService;

    @Autowired
    UnitService unitService;

    @Autowired
    UnitFieldService unitFieldService;

    @Override
    public Map<Integer, ItemUnit> getItemUnitForMap(List<Integer> itemIdList) {
        List<TItemUnit> itemUnitList = itemUnitService.selectItemUnitsByItemIds(itemIdList);

        List<Integer> unitIdList = new ArrayList<>();

        List<Integer> fieldIdList = new ArrayList<>();

        //以FieldID作为Key
        Map<Integer, ItemUnit> itemUnitMap = new HashMap<>();

        for (TItemUnit itemUnit : itemUnitList) {
            unitIdList.add(itemUnit.getUnitId());
            fieldIdList.add(itemUnit.getUnitFieldId());
        }

        Map<Integer, TUnit> unitMap = unitService.selectUnitsByIdsForMap(unitIdList);
        Map<Integer, TUnitField> fieldMap = unitFieldService.selectUnitFiledsByIdsForMap(fieldIdList);

        for (TItemUnit temp : itemUnitList) {
            ItemUnit itemUnit = new ItemUnit(temp);

            if (!itemUnitMap.containsKey(itemUnit.getUnitFieldId())) {
                itemUnit.setUnitName(unitMap.get(itemUnit.getUnitId()).getUnitName());
                itemUnit.setFieldName(fieldMap.get(itemUnit.getUnitFieldId()).getFieldName());

                itemUnitMap.put(itemUnit.getUnitFieldId(), itemUnit);

            }
        }

        return itemUnitMap;
    }
}
