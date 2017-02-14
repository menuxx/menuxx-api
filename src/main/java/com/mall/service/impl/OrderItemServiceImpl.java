package com.mall.service.impl;

import com.mall.mapper.TOrderItemMapper;
import com.mall.model.TOrderItem;
import com.mall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    TOrderItemMapper orderItemMapper;

    @Override
    public void createOrderItem(TOrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }
}
