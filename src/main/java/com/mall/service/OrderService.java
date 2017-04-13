package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.model.Item;
import com.mall.model.Order;
import com.mall.model.TOrder;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderService {

    void createOrder(Order order);

    void updateOrder(Order order);

    PageInfo<TOrder> selectPaidOrders(int userId, int corpId);

    PageInfo<TOrder> selectPaidOrders(int corpId);

    PageInfo<TOrder> selectAllOrders(int corpId);

    PageInfo<TOrder> selectAllPaidOrders(int corpId);

    TOrder selectOrder(int orderId);

    void updateOrderPaid(int orderId);

    TOrder selectOrderByCode(String orderCode);

    void updateOrderRemark(int orderId, String remark);
}
