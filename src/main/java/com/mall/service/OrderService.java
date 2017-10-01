package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.model.Order;
import com.mall.model.TItem;
import com.mall.model.TOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderService {

    void createOrder(Order order);

    void updateOrder(Order order);

    PageInfo<TOrder> selectPaidOrders(int userId, int corpId);

    PageInfo<TOrder> selectPaidOrders(int corpId);

    PageInfo<TOrder> selectAllOrders(int corpId);

    PageInfo<TOrder> selectOrdersByStatus(int corpId, List<Integer> status);

    PageInfo<TOrder> selectAllPaidOrders(int corpId);

    TOrder selectOrder(int orderId);

    int updateOrderPaid(int orderId, int payType, Integer queueId);

    TOrder selectOrderByCode(String orderCode);

    void updateOrderRemark(int orderId, String remark);

    void updateOrderTransportStatus(int orderId, int status);


}
