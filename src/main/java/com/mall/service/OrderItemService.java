package com.mall.service;

import com.mall.model.TOrderItem;

import java.util.List;

/**
 * Created by Supeng on 19/01/2017.
 */
public interface OrderItemService {

    void createOrderItem(TOrderItem orderItem);

    List<TOrderItem> selectOrderItemsByOrder(int orderId);
}
