package com.mall.wrapper.impl;

import com.mall.model.*;
import com.mall.service.*;
import com.mall.utils.MallUtil;
import com.mall.wrapper.ItemUnitWrapper;
import com.mall.wrapper.ItemWrapper;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 18/01/2017.
 */
@Service
public class OrderWrapperImpl implements OrderWrapper{

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    AddressService addressService;

    @Autowired
    ItemWrapper itemWrapper;

    @Autowired
    ItemUnitWrapper itemUnitWrapper;

    @Autowired
    ItemUnitDetailService itemUnitDetailService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Override
    @Transactional
    public void createOrderByItem(Order order) {
        // 先创建订单
        orderService.createOrder(order);

        // 创建OrderItem
        List<OrderItem> orderItemList = order.getOrderItemList();

        List<Integer> itemIdList = new ArrayList<>();

        for (TOrderItem orderItem : orderItemList) {
            itemIdList.add(orderItem.getItemId());
        }

        // 获取相关的Item
        Map<Integer, TItem> itemMap = itemService.selectItemsForMap(itemIdList);

        BigDecimal payAmount = new BigDecimal(0);
        BigDecimal totalAmount = new BigDecimal(0);

        for (OrderItem orderItem : orderItemList) {
            int itemId = orderItem.getItemId();
            TItem item = itemMap.get(itemId);

            BigDecimal itemPayAmount = item.getDiscountPrice().multiply(new BigDecimal(orderItem.getQuantity()));
            BigDecimal itemTotalAmount = item.getProductPrice().multiply(new BigDecimal(orderItem.getQuantity()));

            orderItem.setPayAmount(itemPayAmount);
            orderItem.setTotalAmount(itemTotalAmount);

            payAmount = payAmount.add(itemPayAmount);
            totalAmount = totalAmount.add(itemTotalAmount);

            orderItem.setOrderId(order.getId());

            orderItem.setStatus(OrderItem.STATUS_SECCEED);

            orderItemService.createOrderItem(orderItem);
        }


        // 设置订单编码: 日期 + 编号  2017011900000001
        order.setOrderCode(MallUtil.getYearMonthDay() + (10000000 + order.getId()));

        // 更新订单编码、支付金额、订单金额
        order.setPayAmount(payAmount);
        order.setTotalAmount(totalAmount);

        orderService.updateOrder(order);
    }

    @Override
    @Transactional
    public void createOrderByShoppingCart(Order order) {
        // 先创建订单
        orderService.createOrder(order);

        List<ShoppingCart> tempShoppingCartList = order.getShoppingCartList();

        List<Integer> shoppingCartIdList = new ArrayList<>();

        for (ShoppingCart shoppingCart : tempShoppingCartList) {
            shoppingCartIdList.add(shoppingCart.getId());
        }

        List<TShoppingCart> shoppingCartList = shoppingCartService.selectShoppingCarts(shoppingCartIdList);

        List<Integer> itemIdList = new ArrayList<>();

        List<TOrderItem> orderItemList = new ArrayList<>();

        for (TShoppingCart shoppingCart : shoppingCartList) {
            itemIdList.add(shoppingCart.getItemId());

            TOrderItem orderItem = new TOrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setItemId(shoppingCart.getItemId());
            orderItem.setDetailId(shoppingCart.getDetailId());
            orderItem.setQuantity(shoppingCart.getQuantity());
            orderItem.setStatus(OrderItem.STATUS_SECCEED);

            orderItemList.add(orderItem);
        }

        Map<Integer, TItem> itemMap = itemService.selectItemsForMap(itemIdList);

        BigDecimal payAmount = new BigDecimal(0);
        BigDecimal totalAmount = new BigDecimal(0);

        for (TOrderItem orderItem : orderItemList) {
            TItem item = itemMap.get(orderItem.getItemId());

            BigDecimal itemPayAmount = item.getDiscountPrice().multiply(new BigDecimal(orderItem.getQuantity()));
            BigDecimal itemTotalAmount = item.getProductPrice().multiply(new BigDecimal(orderItem.getQuantity()));

            orderItem.setPayAmount(itemPayAmount);
            orderItem.setTotalAmount(itemTotalAmount);

            payAmount = payAmount.add(itemPayAmount);
            totalAmount = totalAmount.add(itemTotalAmount);

            orderItemService.createOrderItem(orderItem);
        }

        // 设置订单编码: 日期 + 编号  2017011900000001
        order.setOrderCode(MallUtil.getYearMonthDay() + (10000000 + order.getId()));

        // 更新订单编码、支付金额、订单金额
        order.setPayAmount(payAmount);
        order.setTotalAmount(totalAmount);

        orderService.updateOrder(order);

        // 删除购物车信息
        shoppingCartService.removeShoppingCarts(shoppingCartIdList);
    }

    @Override
    public Order selectOrder(int orderId) {
        TOrder tempOrder = orderService.selectOrder(orderId);

        Order order = new Order(tempOrder);

        List<TOrderItem> orderItemList = orderItemService.selectOrderItemsByOrder(orderId);

        List<Integer> itemIdList = new ArrayList<>();
        List<Integer> detailIdList = new ArrayList<>();

        List<OrderItem> returnOrderItemList = new ArrayList<>();

        for (TOrderItem orderItem : orderItemList) {
            itemIdList.add(orderItem.getItemId());
            detailIdList.add(orderItem.getDetailId());

            OrderItem tempOrderItem = new OrderItem(orderItem);
            returnOrderItemList.add(tempOrderItem);
        }

        Map<Integer, Item> itemMap = itemWrapper.selectItemsForMap(itemIdList);
        Map<Integer, ItemUnit> itemUnitMap = itemUnitWrapper.getItemUnitForMap(itemIdList);
        Map<Integer, TItemUnitDetail> detailMap = itemUnitDetailService.selectUnitDetailByItemIdsForMap(itemIdList);

        for (OrderItem orderItem : returnOrderItemList) {
            Item item = itemMap.get(orderItem.getItemId());
            orderItem.setItem(item);

            TItemUnitDetail itemUnitDetail = detailMap.get(orderItem.getDetailId());

            List<ItemUnit> itemUnitList = new ArrayList<>();

            if (itemUnitDetail.getUnit1() != null) {
                ItemUnit itemUnit = itemUnitMap.get(itemUnitDetail.getUnit1());
                itemUnitList.add(itemUnit);
            }

            if (itemUnitDetail.getUnit2() != null) {
                ItemUnit itemUnit = itemUnitMap.get(itemUnitDetail.getUnit2());
                itemUnitList.add(itemUnit);
            }

            if (itemUnitDetail.getUnit3() != null) {
                ItemUnit itemUnit = itemUnitMap.get(itemUnitDetail.getUnit3());
                itemUnitList.add(itemUnit);
            }

            orderItem.setItemUnitList(itemUnitList);
        }


        // 设置地址
        TAddress address = addressService.selectAddress(order.getAddressId());
        order.setAddress(address);

        order.setOrderItemList(returnOrderItemList);

        return order;
    }
}
