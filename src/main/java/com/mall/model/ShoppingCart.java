package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 16/01/2017.
 */
public class ShoppingCart extends TShoppingCart {

    private Item item;

    private List<SelectUnit> unitList;

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

    public List<SelectUnit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<SelectUnit> unitList) {
        this.unitList = unitList;
    }
}
