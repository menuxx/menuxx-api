package com.mall.wrapper.impl;

import com.github.pagehelper.PageInfo;
import com.mall.model.*;
import com.mall.service.ItemService;
import com.mall.service.ItemUnitService;
import com.mall.service.UnitFieldService;
import com.mall.service.UnitService;
import com.mall.wrapper.ItemUnitDetailWrapper;
import com.mall.wrapper.ItemWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class ItemWrapperImpl implements ItemWrapper {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemUnitService itemUnitService;

    @Autowired
    UnitService unitService;

    @Autowired
    UnitFieldService unitFieldService;

    @Autowired
    ItemUnitDetailWrapper itemUnitDetailWrapper;

    @Override
    public Item getItemDetail(int corpId, int itemId) {
        TItem tItem = itemService.selectItem(itemId);

        if (null == tItem) {
            return null;
        }

        Item item = new Item(tItem);

        List<Unit> unitList = buildUnit(corpId, itemId);
        item.setUnitList(unitList);

        List<ItemUnitDetail> detailList = itemUnitDetailWrapper.selectItemUnitDetailByItem(itemId);
        item.setDetailList(detailList);

        return item;
    }

    private List<Unit> buildUnit(int corpId, int itemId) {
        // 获取ItemUnit
        List<TItemUnit> itemUnitList = itemUnitService.selectItemUnits(itemId);

        if (itemUnitList.size() > 0) {
            // 获取规格定义
            Map<Integer, TUnit> unitMap = unitService.selectUnitsForMapByCorp(corpId);

            // 缓存规格编号
            List<Integer> unitIdList = new ArrayList<>();

            // 缓存规格属性编号
            List<Integer> fieldIdList = new ArrayList<>();

            for (TItemUnit itemUnit : itemUnitList) {
                int unitId = itemUnit.getUnitId();
                int unitFieldId = itemUnit.getUnitFieldId();

                unitIdList.add(unitId);
                fieldIdList.add(unitFieldId);
            }

            // 获取规格属性
            Map<Integer, TUnitField> fieldMap = unitFieldService.selectUnitFiledsByIdsForMap(fieldIdList);

            // 规格属性分组
            Map<Integer, List<TUnitField>> fieldGroupMap = new LinkedHashMap<>();

            for (TItemUnit itemUnit : itemUnitList) {
                int unitId = itemUnit.getUnitId();
                int unitFieldId = itemUnit.getUnitFieldId();

                TUnitField unitField = fieldMap.get(unitFieldId);

                if (fieldGroupMap.containsKey(unitId)) {
                    List<TUnitField> tempFieldList = fieldGroupMap.get(unitId);
                    tempFieldList.add(unitField);
                } else {
                    List<TUnitField> tempFieldList = new ArrayList<>();
                    tempFieldList.add(unitField);

                    fieldGroupMap.put(unitId, tempFieldList);
                }

            }

            List<Unit> unitList = new ArrayList<>();

            for (Map.Entry<Integer, List<TUnitField>> entry : fieldGroupMap.entrySet()) {
                int unitId = entry.getKey();
                List<TUnitField> tempFieldList = entry.getValue();

                TUnit tempUnit = unitMap.get(unitId);
                Unit unit = new Unit(tempUnit);

                if (null != tempFieldList) {
                    unit.setFieldList(tempFieldList);
                }

                unitList.add(unit);
            }

            return unitList;

        }

        return new ArrayList<>();
    }

    @Override
    public List<Item> selectItems(List<Integer> itemIdList) {
        List<TItem> tempList = itemService.selectItems(itemIdList);

        if (tempList.size() > 0) {
            List<Item> itemList = new ArrayList<>();

            for (TItem temp : tempList) {
                Item item = new Item(temp);
                itemList.add(item);
            }

            return itemList;
        }

        return null;
    }

    @Override
    public PageInfo<Item> selectItemsByCategory(int categoryId) {
        PageInfo<TItem> tempPageInfo = itemService.selectItemsByCategory(categoryId);

        PageInfo<Item> pageInfo = new PageInfo<>();

        BeanUtils.copyProperties(tempPageInfo, pageInfo);

        List<TItem> tempItemList = tempPageInfo.getList();

        if (tempItemList.size() > 0) {
            List<Item> itemList = new ArrayList<>();

            for (TItem tempItem : tempItemList) {
                Item item = new Item(tempItem);
                itemList.add(item);
            }

            pageInfo.setList(itemList);
        }

        return pageInfo;
    }
}
