package com.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mall.mapper.TDeliveryShopMapper;
import com.mall.mapper.TOrderMapper;
import com.mall.model.*;
import com.mall.service.*;
import com.yingtaohuo.mode.Coupon;
import com.yingtaohuo.mode.ShopConfig;
import com.yingtaohuo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mall.utils.Util.onlyOne;
import static com.yingtaohuo.mode.CouponKt.CouponTypeOfCutback;
import static com.yingtaohuo.mode.CouponKt.CouponTypeOfNewUser;

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

    @Autowired
    PushKeyService pushKeyService;

    @Autowired
    CouponService couponService;

    @PostConstruct
    public void onStart() {
        eventBus.register(this);
    }

    // 新订单支付完成
    @Subscribe
    public void onOrderPaid(Order order) {
        // 给该用户推送下单成功通知
        try {
            TPushKey pushKey =  pushKeyService.getUserAvailableKey(order.getUserId());
            TUser tUser = userService.selectUser(order.getUserId());
            wxMsgPush.pushOrderPaid(pushKey.getPushKey(), tUser.getOpenid(), order);
            pushKeyService.timesIncrementByKeyId(pushKey.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            // 标记为以消费
            if ( order.getCouponId() != null ) {
                couponService.usedCoupon(order.getCouponId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            // 当订单使用的券是新手券的时候
            if ( order.getCouponId() != null ) {
                TCoupon coupon = couponService.getMyCoupon(order.getUserId(), order.getCouponId());
                if ( coupon.getType() == CouponTypeOfNewUser ) {
                    TCouponConfig config = couponService.getCouponConfigOfShop(order.getCorpId(), CouponTypeOfCutback);
                    if ( config != null ) {
                        // 发放满减券
                        TCoupon newCoupon = new TCoupon();
                        newCoupon.setDescText(config.getDescText());
                        // 几天后
                        newCoupon.setExpirationTime(Date.from(LocalDateTime.now().plusDays(config.getExpirationDay()).toInstant(ZoneOffset.UTC)) );
                        newCoupon.setType(CouponTypeOfCutback);
                        newCoupon.setCutback(config.getCutback());
                        newCoupon.setToup(config.getToup());
                        newCoupon.setActiveTime(new Date());
                        newCoupon.setUserId(order.getUserId());
                        newCoupon.setEnable(1);
                        newCoupon.setShopId(order.getCorpId());
                        newCoupon.setName(config.getName());
                        newCoupon.setPermanent(config.getPermanent());
                        newCoupon.setUsed(0);
                        newCoupon.setName(config.getName());
                        couponService.insertCouponToUser(newCoupon);
                        couponService.doCouponPushPlan(new Coupon(newCoupon));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            // 获取订单对应的 店铺 配置
            // 是否自动发送第三方配送
            TShopConfig shopConfig = shopConfigService.getShopConfig(order.getCorpId());
            if ( order.getOrderType() == Order.ORDER_TYPE_DELIVERED && shopConfig.getDeliveryAuto3rd() == 1 ) {
                transportService.transportOrderToChannel(order, shopConfig.getDeliveryChannel());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
