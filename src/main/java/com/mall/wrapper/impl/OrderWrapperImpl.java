package com.mall.wrapper.impl;

import com.mall.model.Order;
import com.mall.model.TOrderItem;
import com.mall.service.OrderItemService;
import com.mall.service.OrderService;
import com.mall.utils.MallUtil;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderWrapperImpl implements OrderWrapper {


    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @Override
    @Transactional
    public void createOrder(Order order) {
        // 先创建订单
        orderService.createOrder(order);

        // 创建订单项
        List<TOrderItem> orderItemList = order.getItemList();
        for (TOrderItem orderItem : orderItemList) {
            orderItem.setOrderId(order.getId());
            orderItemService.createOrderItem(orderItem);
        }


        // 创建订单号
        order.setOrderCode(MallUtil.getYearMonthDay() + (10000000 + order.getId()));

        //TODO 创建排序号
        order.setQueueId(order.getId());

        // 更新订单号、排序号
        orderService.updateOrder(order);
    }
}
