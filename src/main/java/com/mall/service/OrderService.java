package com.mall.service;

import com.github.pagehelper.PageInfo;
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

    TOrder selectOrder(int orderId);
}
