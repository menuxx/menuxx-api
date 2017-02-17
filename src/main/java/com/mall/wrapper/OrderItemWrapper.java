package com.mall.wrapper;

import com.mall.model.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 15/02/2017.
 */
public interface OrderItemWrapper {

    List<OrderItem> selectOrderItemByOrderId(int orderId);

    List<OrderItem> selectOrderItemByOrders(List<Integer> orderIdList);

    Map<Integer, List<OrderItem>> groupOrderItemsByOrder(List<Integer> orderIdList);
}
