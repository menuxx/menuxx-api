package com.mall.wrapper;

import com.mall.model.Order;

/**
 * Created by Supeng on 18/01/2017.
 */
public interface OrderWrapper {

    void createOrderByItem(Order order);

    Order selectOrder(int orderId);

    void createOrderByShoppingCart(Order order);
}
