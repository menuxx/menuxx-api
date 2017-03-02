package com.mall.model;


import com.tencent.protocol.pay_protocol.ScanPayReqData;
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

    // 支付请求
    private ScanPayReqData scanPayReqData;

    private String orderTypeText;

    private String statusText;

    private TTable table;

    private List<OrderItem> itemList;

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

    public void setScanPayReqData(ScanPayReqData scanPayReqData) {
        this.scanPayReqData = scanPayReqData;
    }

    public ScanPayReqData getScanPayReqData() {
        return scanPayReqData;
    }
}
