package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.mall.mapper.TOrderMapper;
import com.mall.model.Order;
import com.mall.model.TOrder;
import com.mall.model.TOrderExample;
import com.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<TOrder> selectPaidOrders(int userId, int corpId) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andCorpIdEqualTo(corpId);

        criteria.andStatusEqualTo(Order.STATUS_PAID);
        example.setOrderByClause("id desc");

        PageInfo<TOrder> pageInfo = new PageInfo<>(orderMapper.selectByExample(example));

        return pageInfo;
    }

    @Override
    public PageInfo<TOrder> selectPaidOrders(int corpId) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        criteria.andStatusEqualTo(Order.STATUS_PAID);
        example.setOrderByClause("id desc");

        PageInfo<TOrder> pageInfo = new PageInfo<>(orderMapper.selectByExample(example));

        return pageInfo;
    }

    @Override
    public PageInfo<TOrder> selectAllOrders(int corpId) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        example.setOrderByClause("id desc");

        PageInfo<TOrder> pageInfo = new PageInfo<>(orderMapper.selectByExample(example));

        return pageInfo;
    }

    @Override
    public TOrder selectOrder(int orderId) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(orderId);

        List<TOrder> list = orderMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public void updateOrderPaid(int orderId) {
        TOrder order = new TOrder();
        order.setId(orderId);
        order.setStatus(Order.STATUS_PAID);

        orderMapper.updateByPrimaryKeySelective(order);
    }
}
