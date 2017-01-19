package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 16/01/2017.
 */
public class ShoppingCart extends TShoppingCart {

    private Item item;

    private List<ItemUnit> unitList;

    public ShoppingCart() {
    }

    public ShoppingCart(TShoppingCart shoppingCart) {
        BeanUtils.copyProperties(shoppingCart, this);
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public List<ItemUnit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<ItemUnit> unitList) {
        this.unitList = unitList;
    }
}
