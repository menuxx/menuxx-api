package com.mall.wrapper;

import com.github.pagehelper.PageInfo;
import com.mall.model.Order;
import com.tencent.protocol.pay_protocol.ScanPayReqData;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderWrapper {

    ScanPayReqData createOrder(String appid, String mchid, Order order, List<Integer> itemIdList);

    PageInfo<Order> selectPaidOrders(int userId, int corpId);

    PageInfo<Order> selectPaidOrders(int corpId);

    PageInfo<Order> selectAllOrders(int corpId);

    Order selectOrder(int orderId);
}
