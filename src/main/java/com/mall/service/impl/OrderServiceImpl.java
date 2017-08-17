package com.mall.service.impl;

import cn.imdada.ImDadaException;
import com.github.pagehelper.PageInfo;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mall.mapper.TDeliveryShopMapper;
import com.mall.mapper.TOrderMapper;
import com.mall.model.*;
import com.mall.service.ConfigService;
import com.mall.service.ItemService;
import com.mall.service.OrderItemService;
import com.mall.service.OrderService;
import com.mall.utils.Util;
import com.yingtaohuo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.mall.utils.Constants.*;
import static com.mall.utils.Util.onlyOne;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    public static TConfig getDefaultTransportChannel(Integer corpId) {
        TConfig config = new TConfig();
        config.setCorpId(corpId);
        config.setName(TransportChannel);
        config.setValue("0");
        return config;
    }

    public static TConfig getDefaultTakeoutNofeeLimit(Integer corpId) {
        TConfig config = new TConfig();
        config.setCorpId(corpId);
        config.setName(TakeoutNofeeLimit);
        config.setValue("8000");
        return config;
    }

    @Autowired
    TOrderMapper orderMapper;

    @Autowired
    TDeliveryShopMapper takeawayShopMapper;

    @Autowired
    ConfigService configService;

    @Autowired
    EventBus eventBus;

    @Autowired
    TransportService transportService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    ItemService itemService;

    @PostConstruct
    public void onStart() {
        eventBus.register(this);
    }

    // 新订单支付完成
    @Subscribe
    public void onOrderPaid(TOrder order) {
        // 当订单是外卖单，并且存在地址
        if (order.getOrderType() == Order.ORDER_TYPE_DELIVERED && order.getAddressId() != null) {
            int shopId = order.getCorpId();

            Map<String, TConfig> corpConfig = Util.getConfigs(configService.selectMyConfigs(shopId));

            Integer transportChannel = Integer.parseInt(corpConfig.getOrDefault(TransportChannel, getDefaultTransportChannel(shopId)).getValue());

            // 配送渠道选用达达的时候
            if ( transportChannel == TransportService.ChannelTypeOfImDada ) {

                // 找到该订单绑定的配送店铺
                TDeliveryShopExample ex = new TDeliveryShopExample();
                ex.createCriteria().andShopIdEqualTo(shopId);
                TDeliveryShop shop = onlyOne(takeawayShopMapper.selectByExample(ex));

                try {
                    // 目前配送费 统一按照4块来算
                    transportService.sendImdadaOrderTransportChannel(order, shop, 400);
                } catch (ImDadaException e) {
                    e.printStackTrace();
                }

            }
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

        criteria.andStatusIn(Arrays.asList(Order.STATUS_PAID, Order.STATUS_OFFLINE));
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
    public PageInfo<TOrder> selectOrdersByStatus(int corpId, List<Integer> status) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCorpIdEqualTo(corpId);
        if (status != null) criteria.andStatusIn(status);
        example.setOrderByClause("id desc");
        return new PageInfo<>(orderMapper.selectByExample(example));
    }

    @Override
    public PageInfo<TOrder> selectAllPaidOrders(int corpId) {
        TOrderExample example = new TOrderExample();
        TOrderExample.Criteria criteria = example.createCriteria();
        criteria.andCorpIdEqualTo(corpId);
        criteria.andStatusEqualTo(Order.STATUS_PAID);
        example.setOrderByClause("id desc");
        return new PageInfo<>(orderMapper.selectByExample(example));
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
