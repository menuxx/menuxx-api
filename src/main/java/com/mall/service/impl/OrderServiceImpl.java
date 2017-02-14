package com.mall.service.impl;

import com.mall.mapper.TOrderMapper;
import com.mall.model.Order;
import com.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    TOrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateByPrimaryKey(order);
    }
}
