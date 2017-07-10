package com.mall.wrapper;

import com.github.pagehelper.PageInfo;
import com.mall.model.Order;
import com.mall.model.TChargeApply;
import com.mall.model.TCorpUser;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface OrderWrapper {

    void createOrder(String appid, String mchid, Order order, List<Integer> itemIdList);

    PageInfo<Order> selectPaidOrders(int userId, int corpId);

    PageInfo<Order> selectPaidOrders(int corpId);

    PageInfo<Order> selectAllOrders(int corpId);

    PageInfo<Order> selectAllPaidOrders(int corpId);

    Order selectOrder(int orderId);

    void setStatusToPaid(TChargeApply chargeApply);

    Order pushOrder(int orderId);

    void pushOrder(Order order, List<String> clientIdList);

    void rechargeCompleted(TChargeApply chargeApply);

    void rechargePay(int userId, int corpId, Order order);

    Order buildTestOrder();
}
