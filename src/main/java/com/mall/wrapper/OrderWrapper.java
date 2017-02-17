package com.mall.wrapper;

import com.github.pagehelper.PageInfo;
import com.mall.model.Order;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderWrapper {

    void createOrder(Order order);

    PageInfo<Order> selectPaidOrders(int userId, int corpId);

    Order selectOrder(int orderId);
}
