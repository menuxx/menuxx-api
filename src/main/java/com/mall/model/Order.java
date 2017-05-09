package com.mall.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends TOrder {

    // 待付款
    public static final int STATUS_CREATED = 0;
    public static final String STATUS_CREATED_TEXT = "待付款";
    // 已付款
    public static final int STATUS_PAID = 1;
    public static final String STATUS_PAID_TEXT = "已付款";

    // 堂食
    public static final int ORDER_TYPE_EAT_IN = 0;
    public static final String ORDER_TYPE_EAT_IN_TEXT = "堂食";

    // 打包
    public static final int ORDER_TYPE_CARRY_OUT = 1;
    public static final String ORDER_TYPE_CARRY_OUT_TEXT = "打包";

    // 外卖
    public static final int ORDER_TYPE_DELIVERED = 2;
    public static final String ORDER_TYPE_DELIVERED_TEXT = "外卖";

    // 微信支付
    public static final int PAY_TYPE_WX = 0;
    public static final String PAY_TYPE_WX_TEXT = "微信支付";
    // 充值卡支付
    public static final int PAY_TYPE_RECHARGE = 1;
    public static final String PAY_TYPE_RECHARGE_TEXT = "充值卡支付";


    private String orderTypeText;

    private String statusText;

    private String payTypeText;

    private TTable table;

    private TAddress address;

    private List<OrderItem> itemList;

    private int userBalance; // 用户充值余额

    public Order() {
    }

    public Order(TOrder order) {
        BeanUtils.copyProperties(order, this);
    }

    public String getOrderTypeText() {
        if (getOrderType() == ORDER_TYPE_EAT_IN) {
            orderTypeText = ORDER_TYPE_EAT_IN_TEXT;
        } else if (getOrderType() == ORDER_TYPE_CARRY_OUT) {
            orderTypeText = ORDER_TYPE_CARRY_OUT_TEXT;
        } else if (getOrderType() == ORDER_TYPE_DELIVERED) {
            orderTypeText = ORDER_TYPE_DELIVERED_TEXT;
        }

        return orderTypeText;
    }

    public void setOrderTypeText(String orderTypeText) {
        this.orderTypeText = orderTypeText;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public TTable getTable() {
        return table;
    }

    public void setTable(TTable table) {
        this.table = table;
    }

    public String getStatusText() {
        statusText = STATUS_CREATED_TEXT;

        if (getStatus() == STATUS_PAID) {
            statusText = STATUS_PAID_TEXT;
        }

        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public void setAddress(TAddress address) {
        this.address = address;
    }

    public TAddress getAddress() {
        return address;
    }

    public void setPayTypeText(String payTypeText) {
        this.payTypeText = payTypeText;
    }

    public String getPayTypeText() {
        payTypeText = PAY_TYPE_WX_TEXT;

        if (null != getPayType() && getPayType() == PAY_TYPE_RECHARGE) {
            payTypeText = PAY_TYPE_RECHARGE_TEXT;
        }

        return payTypeText;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }
}
