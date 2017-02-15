package com.mall.wrapper.impl;

import com.mall.model.OrderItem;
import com.mall.model.TItem;
import com.mall.model.TOrderItem;
import com.mall.service.ItemService;
import com.mall.service.OrderItemService;
import com.mall.wrapper.OrderItemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 15/02/2017.
 */
@Service
public class OrderItemWrapperImpl implements OrderItemWrapper {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    ItemService itemService;

    @Override
    public List<OrderItem> selectOrderItemByOrders(List<Integer> orderIdList) {
        List<TOrderItem> tOrderItemList = orderItemService.selectOrderItemByOrders(orderIdList);

        List<OrderItem> orderItemList = new ArrayList<>();

        List<Integer> itemIdList = new ArrayList<>();

        if (tOrderItemList.size() > 0) {
            for (TOrderItem tOrderItem : tOrderItemList) {
                itemIdList.add(tOrderItem.getItemId());
            }

            Map<Integer, TItem> itemMap = itemService.selectItemsForMap(itemIdList);

            for (TOrderItem tOrderItem : tOrderItemList) {
                OrderItem orderItem = new OrderItem(tOrderItem);

                TItem item = itemMap.get(orderItem.getItemId());
                orderItem.setItem(item);

                orderItemList.add(orderItem);
            }

        }

        return orderItemList;
    }

    @Override
    public Map<Integer, List<OrderItem>> groupOrderItemsByOrder(List<Integer> orderIdList) {
        List<OrderItem> orderItemList = selectOrderItemByOrders(orderIdList);

        Map<Integer, List<OrderItem>> map = new HashMap<>();

        for (OrderItem orderItem : orderItemList) {
            int orderId = orderItem.getOrderId();
            if (map.containsKey(orderId)) {
                map.get(orderId).add(orderItem);
            } else {
                List<OrderItem> tempList = new ArrayList<>();
                tempList.add(orderItem);
                map.put(orderId, tempList);
            }
        }

        return map;
    }
}
