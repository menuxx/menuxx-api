package com.mall.model;

import org.springframework.beans.BeanUtils;

/**
 * Created by Supeng on 15/02/2017.
 */
public class OrderItem extends TOrderItem {

    private TItem item;

    public OrderItem() {
    }

    public OrderItem(TOrderItem orderItem) {
        BeanUtils.copyProperties(orderItem, this);
    }

    public OrderItem(TOrderItem orderItem, TItem item) {
        this(orderItem);
        this.item = item;
    }

    public TItem getItem() {
        return item;
    }

    public void setItem(TItem item) {
        this.item = item;
    }
}
