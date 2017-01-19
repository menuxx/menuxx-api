package com.mall.service;

import com.mall.model.TOrder;

/**
 * Created by Supeng on 18/01/2017.
 */
public interface OrderService {

    void createOrder(TOrder order);

    void updateOrder(TOrder order);

    TOrder selectOrder(int orderId);

}
