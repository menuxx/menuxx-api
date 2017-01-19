package com.mall.service.impl;

import com.mall.mapper.TOrderMapper;
import com.mall.model.TOrder;
import com.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 18/01/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    TOrderMapper orderMapper;

    @Override
    public void createOrder(TOrder order) {
        orderMapper.insert(order);
    }

    @Override
    public void updateOrder(TOrder order) {
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public TOrder selectOrder(int orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
