package com.mall.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends TOrder {

    // 待付款
    public static final int STATUS_CREATED = 0;
    public static final String STATUS_CREATED_TEXT = "待付款";

    // 与店主协商结算
    public static final int STATUS_OFFLINE = 3;
    public static final String STATUS_OFFLINE_TEXT = "其他方式结算";

    // 已付款
    public static final int STATUS_PAID = 1;
    public static final String STATUS_PAID_TEXT = "已付款";

    public static final int STATUS_CONFIRM = 2;
    public static final String STATUS_CONFIRM_TEXT = "已下单";

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

    // 卡券支付
    public static final int PAY_TYPE_COUPON = 2;
    public static final String PAY_TYPE_COUPON_TEXT = "卡券支付";

    // 别名配置
    private Map<Integer, String> tabNameMap;

    private Integer activityAmount;

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

    public String getOrderItemNames() {
        StringBuilder names = new StringBuilder();
        for (OrderItem item : itemList) {
            names.append(item.getItem().getItemName()).append(" x").append(item.getQuantity()).append(", ");
        }
        return names.toString();
    }

    public String getOrderTypeText() {
        if (null != getTabNameMap() && getTabNameMap().size() > 0) {
           orderTypeText = getTabNameMap().get(getOrderType());
        } else if (getOrderType() == ORDER_TYPE_EAT_IN) {
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
        } else if (getStatus() == STATUS_CONFIRM) {
            statusText = STATUS_CONFIRM_TEXT;
        } else if (getStatus() == STATUS_OFFLINE) {
            statusText = STATUS_OFFLINE_TEXT;
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

        if ( getPayType() == PAY_TYPE_COUPON ) {
            payTypeText = PAY_TYPE_COUPON_TEXT;
        }

        return payTypeText;
    }

    public Integer getActivityAmount() {
        return activityAmount;
    }

    public void setActivityAmount(Integer activityAmount) {
        this.activityAmount = activityAmount;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public Map<Integer, String> getTabNameMap() {
        return tabNameMap;
    }

    public void setTabNameMap(Map<Integer, String> tabNameMap) {
        this.tabNameMap = tabNameMap;
    }
}
