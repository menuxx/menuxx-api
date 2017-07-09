package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mall.mapper.TOrderMapper;
import com.mall.mapper.TTakeawayShopMapper;
import com.mall.model.*;
import com.mall.service.ConfigService;
import com.mall.service.OrderService;
import com.yingtaohuo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.mall.utils.Util.onlyOne;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    TOrderMapper orderMapper;

    @Autowired
    TTakeawayShopMapper takeawayShopMapper;

    @Autowired
    ConfigService configService;

    @Autowired
    EventBus eventBus;

    @Autowired
    TransportService transportService;

    @PostConstruct
    public void onStart() {
        eventBus.register(this);
    }

    // 新订单支付完成
    @Subscribe
    public void onOrderPaid(TOrder order) {
        int corpId = order.getCorpId();
        TConfig transportChannelConfigEx = new TConfig();
        transportChannelConfigEx.setCorpId(corpId);
        transportChannelConfigEx.setName("transport_channel");
        transportChannelConfigEx.setValue("0");
        TConfig config = configService.selectMyConfigs(corpId).stream().filter(tConfig -> "transport_channel".equals(tConfig.getName())).findFirst().orElse(transportChannelConfigEx);
        Integer transportChannel = Integer.parseInt(config.getValue());
        // 配送渠道选用达达的时候
        if ( transportChannel == 1 ) {
            TTakeawayShopExample ex = new TTakeawayShopExample();
            ex.createCriteria().andDinerIdEqualTo(corpId);
            TTakeawayShop shop = onlyOne(takeawayShopMapper.selectByExample(ex));
            transportService.sendImdadaOrderTransportChannel(order, shop);
        }
    }

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
    public PageInfo<TOrder> selectAllPaidOrders(int corpId) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);
        criteria.andStatusEqualTo(Order.STATUS_PAID);

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
    public void updateOrderPaid(int orderId, int payType, Integer queueId) {
        TOrder order = new TOrder();
        order.setId(orderId);
        order.setStatus(Order.STATUS_PAID);
        order.setPayType(payType);

        if (null != queueId) {
            order.setQueueId(queueId);
        }

        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public TOrder selectOrderByCode(String orderCode) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();

        criteria.andOrderCodeEqualTo(orderCode);

        TOrder order = onlyOne(orderMapper.selectByExample(example));

        return order;
    }

    @Override
    public void updateOrderRemark(int orderId, String remark) {
        TOrder order = new TOrder();
        order.setId(orderId);
        order.setRemark(remark);

        orderMapper.updateByPrimaryKeySelective(order);
    }


}
