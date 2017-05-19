package com.mall.wrapper.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.mall.configure.AppConfiguration;
import com.mall.model.*;
import com.mall.service.*;
import com.mall.utils.Constants;
import com.mall.utils.IPushUtil;
import com.mall.utils.QueueUtil;
import com.mall.utils.Util;
import com.mall.wrapper.OrderItemWrapper;
import com.mall.wrapper.OrderWrapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class OrderWrapperImpl implements OrderWrapper {


    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderItemWrapper orderItemWrapper;

    @Autowired
    TableService tableService;

    @Autowired
    ItemService itemService;

    @Autowired
    ChargeApplyService chargeApplyService;

    @Autowired
    CorpUserService corpUserService;

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    AddressService addressService;

    @Autowired
    RechargeRecordService rechargeRecordService;

    @Autowired
    UserService userService;

    @Autowired
    UserBalanceService userBalanceService;

    @Autowired
    ConfigService configService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    @Transactional
    public void createOrder(String appid, String mchid, Order order, List<Integer> itemIdList) {
        Map<Integer, TItem> itemMap = itemService.selectItemsForMap(itemIdList);

        // 先创建订单
        orderService.createOrder(order);

        // 总金额
        int totalAcount = 0;
        // 打包盒价格
        int packageAmount = 0;
        // 派送费
        int deliveryAmount = 0;

        // 获取配置信息
        Map<String, Integer> configMap = configService.selectMyConfigs4Map(order.getCorpId());
        // 单个打包盒费用
        Integer takeoutPackFee = configMap.get(Constants.takeoutPackFee);
        // 配送费
        Integer takeoutFee = configMap.get(Constants.takeoutFee);
        // 外卖起送费
        Integer takeoutMinLimit = configMap.get(Constants.takeoutMinLimit);


        // 创建订单项
        List<OrderItem> orderItemList = order.getItemList();
        for (OrderItem orderItem : orderItemList) {
            TItem item = itemMap.get(orderItem.getItemId());

            // 每日特价商品按特价处理
            if (Util.getWeekday() == item.getWeekday()) {
                item.setDiscountPrice(item.getSpecialPrice());
            }

            int payAmount = item.getDiscountPrice() * orderItem.getQuantity();

            orderItem.setOrderId(order.getId());

            orderItem.setPayAmount(payAmount);

            orderItemService.createOrderItem(orderItem);

            totalAcount = totalAcount + payAmount;

            // 如果选择打包或者外卖，计入打包盒价格
            if (order.getOrderType() == Order.ORDER_TYPE_CARRY_OUT || order.getOrderType() == Order.ORDER_TYPE_DELIVERED) {
                if (item.getPackageFlag() == Constants.ONE && takeoutPackFee > 0) {
                    packageAmount = packageAmount + (orderItem.getQuantity() * takeoutPackFee);
                }
            }

        }

        order.setPackageAmount(packageAmount);
        totalAcount = totalAcount + packageAmount;

        // 如果选择外卖，计入配送费
        if (order.getOrderType() == Order.ORDER_TYPE_DELIVERED && takeoutFee > 0) {
            deliveryAmount = takeoutFee;
        }
        order.setDeliveryAmount(deliveryAmount);
        totalAcount = totalAcount + deliveryAmount;

        // 设置订单号
        order.setOrderCode(Util.getYearMonthDay() + (10000000 + order.getId()));

        // 更新订单号、排序号
        order.setPayAmount(totalAcount);
        order.setTotalAmount(totalAcount);
        orderService.updateOrder(order);

    }

    @Override
    public PageInfo<Order> selectPaidOrders(int userId, int corpId) {
        PageInfo<TOrder> tOrderPageInfo = orderService.selectPaidOrders(userId, corpId);
        return getOrderPageInfo(corpId, tOrderPageInfo);
    }

    @Override
    public PageInfo<Order> selectPaidOrders(int corpId) {
        PageInfo<TOrder> tOrderPageInfo = orderService.selectPaidOrders(corpId);
        return getOrderPageInfo(corpId, tOrderPageInfo);
    }

    private PageInfo<Order> getOrderPageInfo(int corpId, PageInfo<TOrder> tOrderPageInfo) {
        PageInfo<Order> orderPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(tOrderPageInfo, orderPageInfo);

        List<TOrder> tOrderList = tOrderPageInfo.getList();
        List<Order> orderList = new ArrayList<>();

        if (tOrderList.size() > 0) {
            List<Integer> orderIdList = new ArrayList<>();
            List<Integer> addressIdList = new ArrayList<>();

            for (TOrder torder : tOrderList) {
                Order order = new Order(torder);

                orderList.add(order);
                orderIdList.add(torder.getId());

                if (order.getAddressId() != null && order.getAddressId() > 0) {
                    addressIdList.add(order.getAddressId());
                }
            }

            // 获取 OrderItem
            Map<Integer, List<OrderItem>> orderItemMap = orderItemWrapper.groupOrderItemsByOrder(orderIdList);

            Map<Integer, TTable> tableMap = tableService.selectTablesByCorpForMap(corpId);

            Map<Integer, TAddress> addressMap = new HashMap<>();
            if (addressIdList.size() > 0) {
                addressMap = addressService.selectAddressForMap(addressIdList);
            }

            for(Order order : orderList) {
                List<OrderItem> orderItemList = orderItemMap.get(order.getId());
                order.setItemList(orderItemList);

                if (order.getTableId() != null && order.getTableId() > 0) {
                    TTable table = tableMap.get(order.getTableId());
                    order.setTable(table);
                }

                if (order.getAddressId() != null && order.getAddressId() > 0) {
                    TAddress address = addressMap.get(order.getAddressId());
                    order.setAddress(address);
                }

            }

            orderPageInfo.setList(orderList);
        }

        return orderPageInfo;
    }

    @Override
    public Order selectOrder(int orderId) {
        TOrder torder = orderService.selectOrder(orderId);

        Order order = new Order(torder);

        List<OrderItem> orderItemList = orderItemWrapper.selectOrderItemByOrderId(orderId);
        order.setItemList(orderItemList);

        if ( order.getTableId() != null && order.getTableId() > 0 ) {
            TTable table = tableService.selectTable(order.getTableId());
            order.setTable(table);
        }

        if (order.getAddressId() != null && order.getAddressId() > 0) {
            TAddress address = addressService.selectAddress(order.getAddressId());
            order.setAddress(address);
        }

        return order;
    }

    @Override
    public PageInfo<Order> selectAllOrders(int corpId) {
        PageInfo<TOrder> tOrderPageInfo = orderService.selectAllOrders(corpId);
        return getOrderPageInfo(corpId, tOrderPageInfo);
    }

    @Override
    public PageInfo<Order> selectAllPaidOrders(int corpId) {
        PageInfo<TOrder> tOrderPageInfo = orderService.selectAllPaidOrders(corpId);
        return getOrderPageInfo(corpId, tOrderPageInfo);
    }

    @Override
    public Order pushOrder(int orderId) {
        Order order = selectOrder(orderId);
        return pushOrder(order);
    }

    private Order pushOrder(Order order) {
        List<TCorpUser> corpUserList = corpUserService.selectCorpUsersByCorpId(order.getCorpId());

        List<String> clientIdList = new ArrayList<>();

        for (TCorpUser corpUser : corpUserList) {
            clientIdList.add(corpUser.getClientId());
        }

        try {
            String content = objectMapper.writeValueAsString(order);
            IPushUtil.sendPushOrder(appConfiguration, content, clientIdList);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    @Transactional
    public void setStatusToPaid(TChargeApply chargeApply) {
        String orderCode = chargeApply.getOutTradeNo();
        TOrder order = orderService.selectOrderByCode(orderCode);

        chargeApply.setUserId(order.getUserId());
        chargeApply.setOrderId(order.getId());
        chargeApplyService.updateChargeApply(chargeApply);

        // 创建排序号
        Integer queueId = QueueUtil.getQueueNum(order.getCorpId());
        orderService.updateOrderPaid(order.getId(), Order.PAY_TYPE_WX, queueId);

        // PUSH
        pushOrder(order.getId());
    }

    @Override
    @Transactional
    public void rechargeCompleted(TChargeApply chargeApply) {
        chargeApplyService.updateChargeApply(chargeApply);
        // 充值完成：更新记录状态
        String rechargeCode = chargeApply.getOutTradeNo();
        TRechargeRecord rechargeRecord = rechargeRecordService.selectRechargeRecordByCode(rechargeCode);
        rechargeRecord.setStatus(Constants.ONE);
        rechargeRecordService.updateRechargeRecordStatus2Completed(rechargeRecord.getId());

        // 更新余额
        int balance = userBalanceService.increaseBalance(rechargeRecord.getUserId(), rechargeRecord.getCorpId(), rechargeRecord.getAmount());

        // 获取订单
        Order order = selectOrder(rechargeRecord.getOrderId());

        // 如果充值后余额 不够支付当前订单，则不更新订单状态
        if (balance >= order.getPayAmount()) {
            // 创建排序号
            Integer queueId = QueueUtil.getQueueNum(order.getCorpId());

            // 订单支付
            orderService.updateOrderPaid(rechargeRecord.getOrderId(), Order.PAY_TYPE_RECHARGE, queueId);

            // 创建消费记录
            TRechargeRecord recharge = new TRechargeRecord();
            recharge.setCorpId(rechargeRecord.getCorpId());
            recharge.setUserId(rechargeRecord.getUserId());
            recharge.setOrderId(rechargeRecord.getOrderId());
            recharge.setRechargeCode(UUID.randomUUID().toString());
            recharge.setChargeType(Constants.CHARGE_TYPE_PAY);
            recharge.setStatus(Constants.ONE);


            recharge.setAmount(order.getPayAmount());

            rechargeRecordService.createRechargeRecord(recharge);

            // 更新余额
            userBalanceService.reduceBalance(rechargeRecord.getUserId(), rechargeRecord.getCorpId(), order.getPayAmount());

            // PUSH
            pushOrder(order);
        }

    }

    @Override
    public void rechargePay(int userId, int corpId, Order order) {
        // 减掉应付款
        userBalanceService.reduceBalance(userId, corpId, order.getPayAmount());

        // 创建排序号
        Integer queueId = QueueUtil.getQueueNum(order.getCorpId());
        order.setQueueId(queueId);

        // 更新订单状态
        orderService.updateOrderPaid(order.getId(), Order.PAY_TYPE_RECHARGE, order.getQueueId());

        // 创建消费记录
        TRechargeRecord recharge = new TRechargeRecord();
        recharge.setCorpId(corpId);
        recharge.setUserId(userId);
        recharge.setOrderId(order.getId());
        recharge.setRechargeCode(UUID.randomUUID().toString());
        recharge.setChargeType(Constants.CHARGE_TYPE_PAY);
        recharge.setStatus(Constants.ONE);
        recharge.setAmount(order.getPayAmount());

        rechargeRecordService.createRechargeRecord(recharge);

        // PUSH
        pushOrder(order);
    }

    @Override
    public Order buildTestOrder() {
        Order order = new Order();
        order.setId(0);
        order.setUserId(0);
        order.setCorpId(0);
        order.setOrderCode("88888888");
        order.setRemark("不要葱，不要蒜，加辣");
        order.setStatus(1);
        order.setOrderType(Order.ORDER_TYPE_CARRY_OUT);
        order.setQueueId(0);
        order.setTotalAmount(1);
        order.setPayAmount(1);
        order.setCreateTime(new Date());

        Item item = new Item();
        item.setId(0);
        item.setCorpId(0);
        item.setItemName("测试订单");
        item.setCategoryId(0);
        item.setProductPrice(1);
        item.setCreateTime(new Date());

        OrderItem orderItem = new OrderItem();
        orderItem.setId(0);
        orderItem.setOrderId(0);
        orderItem.setItemId(0);
        orderItem.setQuantity(1);
        orderItem.setPayAmount(1);
        orderItem.setCreateTime(new Date());
        orderItem.setItem(item);

        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);

        order.setItemList(orderItemList);
        return order;
    }
}
