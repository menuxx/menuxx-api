package com.mall.service;

import com.mall.model.Order;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderService {

    void createOrder(Order order);

    void updateOrder(Order order);

}
