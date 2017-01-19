package com.mall.service.impl;

import com.mall.mapper.TOrderItemMapper;
import com.mall.model.TOrderItem;
import com.mall.model.TOrderItemExample;
import com.mall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 19/01/2017.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    TOrderItemMapper orderItemMapper;

    @Override
    public void createOrderItem(TOrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }

    @Override
    public List<TOrderItem> selectOrderItemsByOrder(int orderId) {
        TOrderItemExample example = new TOrderItemExample();
        TOrderItemExample.Criteria criteria = example.createCriteria();

        criteria.andOrderIdEqualTo(orderId);

        return orderItemMapper.selectByExample(example);
    }
}
