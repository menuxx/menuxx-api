package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mall.mapper.TDeliveryShopMapper;
import com.mall.mapper.TOrderMapper;
import com.mall.model.*;
import com.mall.service.*;
import com.yingtaohuo.mode.ShopConfig;
import com.yingtaohuo.service.ShopConfigService;
import com.yingtaohuo.service.TransportService;
import com.yingtaohuo.service.WXMsgPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static com.mall.utils.Constants.*;
import static com.mall.utils.Util.onlyOne;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

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

    @Autowired
    ShopConfigService shopConfigService;

    @Autowired
    UserService userService;

    @Autowired
    WXMsgPush wxMsgPush;

    @PostConstruct
    public void onStart() {
        eventBus.register(this);
    }

    // 新订单支付完成
    @Subscribe
    public void onOrderPaid(Order order) {
        try {
            wxMsgPush.pushOrderPaid(order);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 获取订单对应的 店铺 配置
        // 是否自动发送第三方配送
        ShopConfig shopConfig = shopConfigService.getShopConfig(order.getId());
        if ( order.getOrderType() == Order.ORDER_TYPE_DELIVERED && shopConfig.getTransportAuto3rd() == 1 ) {
            transportService.transportOrderToChannel(order, shopConfig.getTransportChannel());
        }
        // 更新用户为消费用户
        userService.updateUserToConsume(order.getUserId());
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
    public void updatePrepayId(Integer orderId, String prepayId) {
        TOrder order = new TOrder();
        order.setId(orderId);
        order.setPrepayId(prepayId);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int updateOrderPaid(int orderId, int payType, Integer queueId) {
        TOrder order = new TOrder();
        order.setId(orderId);
        order.setStatus(Order.STATUS_PAID);
        order.setPayType(payType);

        if (null != queueId) {
            order.setQueueId(queueId);
        }

        return orderMapper.updateByPrimaryKeySelective(order);
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

    @Override
    public void updateOrderTransportStatus(int orderId, int status) {
        TOrder order = new TOrder();
        order.setId(orderId);
        order.setTransportStatus(status);
        orderMapper.updateByPrimaryKeySelective(order);
    }

}
