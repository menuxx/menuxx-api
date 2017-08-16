package com.mall.service.impl;

import com.mall.mapper.TOrderItemMapper;
import com.mall.mapper.TOrderMapper;
import com.mall.model.TOrder;
import com.mall.model.TOrderExample;
import com.mall.model.TOrderItem;
import com.mall.model.TOrderItemExample;
import com.mall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.mall.utils.Util.onlyOne;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    TOrderItemMapper orderItemMapper;

    @Autowired
    TOrderMapper orderMapper;

    @Override
    public void createOrderItem(TOrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }

    @Override
    public List<TOrderItem> selectOrderItemByOrders(List<Integer> orderIdList) {
        TOrderItemExample example = new TOrderItemExample();
        TOrderItemExample.Criteria criteria = example.createCriteria();

        criteria.andOrderIdIn(orderIdList);

        return orderItemMapper.selectByExample(example);
    }

    @Override
    public List<TOrderItem> selectOrderItemByOrderId(int orderId) {
        TOrderItemExample example = new TOrderItemExample();
        TOrderItemExample.Criteria criteria = example.createCriteria();

        criteria.andOrderIdEqualTo(orderId);

        return orderItemMapper.selectByExample(example);
    }

    @Override
    public List<TOrderItem> selectOrderItemByOrderNo(String orderNo) {
        TOrderExample orderEx = new TOrderExample();
        orderEx.createCriteria().andOrderCodeEqualTo(orderNo);
        TOrder order = onlyOne(orderMapper.selectByExample(orderEx));
        return selectOrderItemByOrderId(order.getId());
    }
}
