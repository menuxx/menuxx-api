package com.mall.wrapper.impl;

import com.mall.model.*;
import com.mall.service.*;
import com.mall.wrapper.ItemUnitWrapper;
import com.mall.wrapper.ItemWrapper;
import com.mall.wrapper.ShoppingCartWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    ItemUnitWrapper itemUnitWrapper;

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

        if (tempList.size() > 0) {
            for (TShoppingCart shoppingCart : tempList) {
                itemIdList.add(shoppingCart.getItemId());
            }
        }

        // 缓存 商品
        Map<Integer, Item> itemMap = itemWrapper.selectItemsForMap(itemIdList);

        // 获取商品相关规格 Map<fieldId, ItemUnit>
        Map<Integer, ItemUnit> itemUnitMap = itemUnitWrapper.getItemUnitForMap(itemIdList);

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

                //缓存SelectUnit
                List<ItemUnit> selectUnitList = new ArrayList<>();

                if (itemUnitDetail.getUnit1() != null) {
                    ItemUnit itemUnit = itemUnitMap.get(itemUnitDetail.getUnit1());
                    selectUnitList.add(itemUnit);
                }

                if (itemUnitDetail.getUnit2() != null) {
                    ItemUnit itemUnit = itemUnitMap.get(itemUnitDetail.getUnit2());
                    selectUnitList.add(itemUnit);
                }

                if (itemUnitDetail.getUnit3() != null) {
                    ItemUnit itemUnit = itemUnitMap.get(itemUnitDetail.getUnit3());
                    selectUnitList.add(itemUnit);
                }

                shoppingCart.setUnitList(selectUnitList);
            }
            shoppingCartList.add(shoppingCart);

        }
        return shoppingCartList;
    }
}
