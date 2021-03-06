package com.mall.service;

import com.mall.model.TOrderItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderItemService {

    void createOrderItem(TOrderItem orderItem);

    List<TOrderItem> selectOrderItemByOrders(List<Integer> orderIdList);

    List<TOrderItem> selectOrderItemByOrderId(int orderId);

    List<TOrderItem> selectOrderItemByOrderNo(String orderNo);

}
