package com.mall.model;


import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public class Order extends TOrder {

    // 待付款
    public static final int STATUS_CREATED = 0;
    public static final String STATUS_CREATED_TEXT = "待付款";
    // 待发货
    public static final int STATUS_PAID = 1;
    public static final String STATUS_PAID_TEXT = "已付款";

    // 堂食
    public static final int ORDER_TYPE_EAT_IN = 0;
    public static final String ORDER_TYPE_EAT_IN_TEXT = "堂食";

    // 打包
    public static final int ORDER_TYPE_CARRY_OUT = 1;
    public static final String ORDER_TYPE_CARRY_OUT_TEXT = "打包";

    private String orderTypeText;

    private List<TOrderItem> itemList;

    public Order() {
    }

    public Order(TOrder order) {
        BeanUtils.copyProperties(order, this);
    }

    public List<TOrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TOrderItem> itemList) {
        this.itemList = itemList;
    }

    public String getOrderTypeText() {
        if (getOrderType() == ORDER_TYPE_EAT_IN) {
            orderTypeText = ORDER_TYPE_EAT_IN_TEXT;
        } else if (getOrderType() == ORDER_TYPE_CARRY_OUT) {
            orderTypeText = ORDER_TYPE_CARRY_OUT_TEXT;
        }

        return orderTypeText;
    }

    public void setOrderTypeText(String orderTypeText) {
        this.orderTypeText = orderTypeText;
    }
}
