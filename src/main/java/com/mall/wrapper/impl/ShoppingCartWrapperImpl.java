package com.mall.wrapper.impl;

import com.mall.model.*;
import com.mall.service.*;
import com.mall.wrapper.ItemWrapper;
import com.mall.wrapper.ShoppingCartWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 16/01/2017.
 */
@Service
public class ShoppingCartWrapperImpl implements ShoppingCartWrapper {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ItemWrapper itemWrapper;

    @Autowired
    ItemUnitService itemUnitService;

    @Autowired
    UnitService unitService;

    @Autowired
    UnitFieldService unitFieldService;

    @Autowired
    ItemUnitDetailService itemUnitDetailService;

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        TShoppingCart exist = shoppingCartService.selectHasAdd(shoppingCart);

        if (exist == null ) {
            // 直接添加
            shoppingCartService.createShoppingCart(shoppingCart);
            return shoppingCart;
        } else {
            // 修改数量
            int quantily =  exist.getQuantity() + shoppingCart.getQuantity();
            exist.setQuantity(quantily);

            shoppingCartService.updateShppingCart(exist);

            return new ShoppingCart(exist);
        }

    }



    @Override
    public List<ShoppingCart> getShoppingCart(int corpId, int userId) {
        List<TShoppingCart> tempList = shoppingCartService.selectShoppingCartByUser(corpId, userId);

        List<Integer> itemIdList = new ArrayList<>();

        List<Integer> unitIdList = new ArrayList<>();

        List<Integer> fieldIdList = new ArrayList<>();

        if (tempList.size() > 0) {
            for (TShoppingCart shoppingCart : tempList) {
                itemIdList.add(shoppingCart.getItemId());
            }
        }


        if (itemIdList.size() > 0) {
            // 缓存 商品
            Map<Integer, Item> itemMap = itemWrapper.selectItemsForMap(itemIdList);

            List<TItemUnit> itemUnitList = itemUnitService.selectItemUnitsByItemIds(itemIdList);

            // 把规格按商品分组: Map<ItemId, Map<fieldId, ItemUnit>>
            Map<Integer, Map<Integer, TItemUnit>> itemUnitGroupMap = new HashMap<>();

            for (TItemUnit itemUnit : itemUnitList) {
                unitIdList.add(itemUnit.getUnitId());
                fieldIdList.add(itemUnit.getUnitFieldId());

                if (itemUnitGroupMap.containsKey(itemUnit.getItemId())) {
                    Map<Integer, TItemUnit> itemUnitMap = itemUnitGroupMap.get(itemUnit.getItemId());

                    if (!itemUnitMap.containsKey(itemUnit.getUnitFieldId())) {
                        itemUnitMap.put(itemUnit.getUnitFieldId(), itemUnit);
                    }

                } else {
                    Map<Integer, TItemUnit> itemUnitMap = new HashMap<>();
                    itemUnitMap.put(itemUnit.getUnitFieldId(), itemUnit);

                    itemUnitGroupMap.put(itemUnit.getItemId(), itemUnitMap);
                }
            }

            Map<Integer, TUnit> unitMap = unitService.selectUnitsByIdsForMap(unitIdList);
            Map<Integer, TUnitField> fieldMap = unitFieldService.selectUnitFiledsByIdsForMap(fieldIdList);
            Map<Integer, TItemUnitDetail> detailMap = itemUnitDetailService.selectUnitDetailByItemIdsForMap(itemIdList);

            List<ShoppingCart> shoppingCartList = new ArrayList<>();

            for (TShoppingCart tempCart : tempList) {
                ShoppingCart shoppingCart = new ShoppingCart(tempCart);

                //构造Item
                Item item = itemMap.get(tempCart.getItemId());
                shoppingCart.setItem(item);

                //构造SelectUnit
                if (tempCart.getDetailId() != null) {
                    TItemUnitDetail itemUnitDetail = detailMap.get(tempCart.getDetailId());

                    Map<Integer, TItemUnit> itemUnitMap = itemUnitGroupMap.get(tempCart.getItemId());

                    //缓存SelectUnit
                    List<SelectUnit> selectUnitList = new ArrayList<>();

                    if (itemUnitDetail.getUnit1() != null) {
                        int fieldId = itemUnitDetail.getUnit1();

                        TItemUnit itemUnit = itemUnitMap.get(fieldId);

                        SelectUnit selectUnit = new SelectUnit();
                        selectUnit.setUnitId(itemUnit.getUnitId());
                        selectUnit.setFieldId(itemUnit.getUnitFieldId());
                        selectUnit.setUnitName(unitMap.get(itemUnit.getUnitId()).getUnitName());
                        selectUnit.setFieldName(fieldMap.get(itemUnit.getUnitFieldId()).getFieldName());
                        selectUnitList.add(selectUnit);
                    }

                    if (itemUnitDetail.getUnit2() != null) {
                        int fieldId = itemUnitDetail.getUnit2();

                        TItemUnit itemUnit = itemUnitMap.get(fieldId);

                        SelectUnit selectUnit = new SelectUnit();
                        selectUnit.setUnitId(itemUnit.getUnitId());
                        selectUnit.setFieldId(itemUnit.getUnitFieldId());
                        selectUnit.setUnitName(unitMap.get(itemUnit.getUnitId()).getUnitName());
                        selectUnit.setFieldName(fieldMap.get(itemUnit.getUnitFieldId()).getFieldName());
                        selectUnitList.add(selectUnit);
                    }

                    if (itemUnitDetail.getUnit3() != null) {
                        int fieldId = itemUnitDetail.getUnit3();

                        TItemUnit itemUnit = itemUnitMap.get(fieldId);

                        SelectUnit selectUnit = new SelectUnit();
                        selectUnit.setUnitId(itemUnit.getUnitId());
                        selectUnit.setFieldId(itemUnit.getUnitFieldId());
                        selectUnit.setUnitName(unitMap.get(itemUnit.getUnitId()).getUnitName());
                        selectUnit.setFieldName(fieldMap.get(itemUnit.getUnitFieldId()).getFieldName());
                        selectUnitList.add(selectUnit);
                    }

                    shoppingCart.setUnitList(selectUnitList);
                }
                shoppingCartList.add(shoppingCart);

            }
            return shoppingCartList;

        }


        return null;
    }
}
