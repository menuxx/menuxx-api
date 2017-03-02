package com.mall.wrapper.impl;

import com.github.pagehelper.PageInfo;
import com.mall.model.*;
import com.mall.service.*;
import com.mall.utils.MallUtil;
import com.mall.utils.QueueUtil;
import com.mall.wrapper.OrderItemWrapper;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    @Override
    @Transactional
    public void createOrder(String appid, String mchid, Order order, List<Integer> itemIdList) {
        Map<Integer, TItem> itemMap = itemService.selectItemsForMap(itemIdList);

        // 先创建订单
        orderService.createOrder(order);

        // 总金额
        int totalAcount = 0;

        // 创建订单项
        List<OrderItem> orderItemList = order.getItemList();
        for (OrderItem orderItem : orderItemList) {
            TItem item = itemMap.get(orderItem.getItemId());

            int payAmount = item.getProductPrice() * orderItem.getQuantity();

            orderItem.setOrderId(order.getId());

            orderItem.setPayAmount(payAmount);

            orderItemService.createOrderItem(orderItem);

            totalAcount = totalAcount + payAmount;
        }

        // 创建订单号
        order.setOrderCode(MallUtil.getYearMonthDay() + (10000000 + order.getId()));

        // 创建排序号
        order.setQueueId(QueueUtil.getQueueNum(order.getCorpId()));

        // 更新订单号、排序号
        orderService.updateOrder(order);

        String body = "已成功支付¥" + order.getTotalAmount()/100;
        String timeStart = MallUtil.dateFormatNow();
        String timeExpire = MallUtil.dateFormatAddMinites(4);

        // 创建一个微信支付订单
//        ScanPayReqData scanPayReqData = new ScanPayReqData(appid, mchid, body, order.getOrderCode(), order.getTotalAmount(), timeStart, timeExpire);

//        chargeApplyService.createChargeApply(order, scanPayReqData);

//        return scanPayReqData;
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

            for (TOrder torder : tOrderList) {
                Order order = new Order(torder);

                orderList.add(order);
                orderIdList.add(torder.getId());
            }

            // 获取 OrderItem
            Map<Integer, List<OrderItem>> orderItemMap = orderItemWrapper.groupOrderItemsByOrder(orderIdList);

            Map<Integer, TTable> tableMap = tableService.selectTablesByCorpForMap(corpId);

            for(Order order : orderList) {
                List<OrderItem> orderItemList = orderItemMap.get(order.getId());
                order.setItemList(orderItemList);

                TTable table = tableMap.get(order.getTableId());
                order.setTable(table);
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

        TTable table = tableService.selectTable(order.getTableId());
        order.setTable(table);

        return order;
    }

    @Override
    public PageInfo<Order> selectAllOrders(int corpId) {
        PageInfo<TOrder> tOrderPageInfo = orderService.selectAllOrders(corpId);
        return getOrderPageInfo(corpId, tOrderPageInfo);
    }
}
