package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 18/01/2017.
 */
public class Order extends TOrder {

    // 待付款
    public static final int STATUS_CREATED = 0;
    public static final String STATUS_CREATED_TEXT = "待付款";

    // 待发货
    public static final int STATUS_PAID = 1;
    public static final String STATUS_PAID_TEXT = "已付款";

    // 待收货
    public static final int STATUS_DELEVERED = 2;
    public static final String STATUS_DELEVERED_TEXT = "已发货";

    // 订单取消
    public static final int STATUS_CANCEL = 3;
    public static final String STATUS_CANCEL_TEXT = "交易关闭";

    // 订单删除
    public static final int STATUS_DELETED = 4;
    public static final String STATUS_DELETED_TEXT = "交易删除";

    // 交易成功
    public static final int STATUS_SUCCEED = 5;
    public static final String STATUS_SUCCEED_TEXT = "交易成功";


    private List<OrderItem> orderItemList;

    private List<ShoppingCart> shoppingCartList;

    private TAddress address;

    private String statusText;

    public Order() {
    }


    public Order(TOrder order) {
        BeanUtils.copyProperties(order, this);
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setAddress(TAddress address) {
        this.address = address;
    }

    public TAddress getAddress() {
        return address;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        switch (getStatus()) {
            case STATUS_PAID:
                statusText = STATUS_PAID_TEXT;
                break;
            case STATUS_DELEVERED:
                statusText = STATUS_DELEVERED_TEXT;
                break;
            case STATUS_CANCEL:
                statusText = STATUS_CANCEL_TEXT;
                break;
            case STATUS_DELETED:
                statusText = STATUS_DELETED_TEXT;
                break;
            case STATUS_SUCCEED:
                statusText = STATUS_SUCCEED_TEXT;
                break;

            default:
                statusText = STATUS_CREATED_TEXT;
                break;
        }

        return statusText;
    }

    public List<ShoppingCart> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
}
