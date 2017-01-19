package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 19/01/2017.
 */
public class OrderItem extends TOrderItem {

    // 交易正常
    public static final Integer STATUS_SECCEED = 0;

    private Item item;

    private List<ItemUnit> itemUnitList;

    public OrderItem() {
    }

    public OrderItem(TOrderItem orderItem) {
        BeanUtils.copyProperties(orderItem, this);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<ItemUnit> getItemUnitList() {
        return itemUnitList;
    }

    public void setItemUnitList(List<ItemUnit> itemUnitList) {
        this.itemUnitList = itemUnitList;
    }
}
