package com.mall.service.impl;

import cn.imdada.ImDadaException;
import com.github.pagehelper.PageInfo;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mall.mapper.TOrderMapper;
import com.mall.mapper.TTakeawayShopMapper;
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
    TTakeawayShopMapper takeawayShopMapper;

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
            int corpId = order.getCorpId();

            Map<String, TConfig> corpConfig = Util.getConfigs(configService.selectMyConfigs(corpId));

            Integer transportChannel = Integer.parseInt(corpConfig.getOrDefault(TransportChannel, getDefaultTransportChannel(corpId)).getValue());

            // 免配送费阈值
            //Integer takeoutNofeeLimit = Integer.parseInt(corpConfig.getOrDefault(TakeoutNofeeLimit, getDefaultTakeoutNofeeLimit(corpId)).getValue());

            // 打包费
            //Integer takeoutPackFee = Integer.parseInt(corpConfig.getOrDefault(TakeoutPackFee, getDefaultTakeoutNofeeLimit(corpId)).getValue());

            // 商家补贴的配送费
            Integer takeoutFee = Integer.parseInt(corpConfig.getOrDefault(TakeoutFee, getDefaultTakeoutNofeeLimit(corpId)).getValue());

            // 配送渠道选用达达的时候
            if ( transportChannel == 1 ) {

                // 找到该订单绑定的配送店铺
                TTakeawayShopExample ex = new TTakeawayShopExample();
                ex.createCriteria().andDinerIdEqualTo(corpId);
                TTakeawayShop shop = onlyOne(takeawayShopMapper.selectByExample(ex));

                try {
                    transportService.sendImdadaOrderTransportChannel(order, shop, takeoutFee / 100);
                } catch (ImDadaException e) {
                    e.printStackTrace();
                }

                // 支付在总价 = 商品价格 + 打包费 不加邮费
//                int totalAmount = takeoutPackFee;
//
//                if (shop != null) {
//
//                    List<TOrderItem> orderItemList = orderItemService.selectOrderItemByOrderId(order.getId());
//
//                    for (TOrderItem orderItem : orderItemList) {
//                        totalAmount += orderItem.getPayAmount();
//                    }
//
//                    // 满足满减配送费
//                    if ( totalAmount > takeoutNofeeLimit ) {
//                        try {
//                            transportService.sendImdadaOrderTransportChannel(order, shop, takeoutFee / 100);
//                        } catch (ImDadaException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    else{
//                        try {
//                            transportService.sendImdadaOrderTransportChannel(order, shop, 0.0);
//                        } catch (ImDadaException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }
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
