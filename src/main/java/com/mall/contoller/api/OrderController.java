package com.mall.contoller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.mall.annotation.SessionKey;
import com.mall.annotation.SessionData;
import com.mall.configure.page.Page;
import com.mall.model.Order;
import com.mall.model.OrderItem;
import com.mall.service.OrderService;
import com.mall.utils.Constants;
import com.mall.utils.JPushUtil;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
@Controller
public class OrderController extends BaseCorpController {

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    OrderService orderService;

    /**
     * 1002 创建订单
     * @param dinerId
     * @param order
     * @return
     */
    @RequestMapping(value = "orders", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createOrder(@PathVariable int dinerId, @RequestBody Order order, @SessionKey SessionData sessionData) {
        int userId = sessionData.getUserId();
        order.setUserId(userId);

        // 订单状态默认为未付款
        order.setStatus(Order.STATUS_CREATED);
        order.setCorpId(dinerId);

        // 如果选择堂食，必须有桌号；否则桌号为空
        if (order.getOrderType() == Order.ORDER_TYPE_EAT_IN) {
            if (order.getTableId() == null) {
                return new ResponseEntity<Object>("请选择就餐桌号.", HttpStatus.BAD_REQUEST);
            }
        } else {
            order.setTableId(null);
        }

        List<Integer> itemIdList = new ArrayList<>();

        if (order.getItemList() != null && order.getItemList().size() > 0) {
            for (OrderItem orderItem : order.getItemList()) {
                itemIdList.add(orderItem.getItemId());
            }
        }

        orderWrapper.createOrder(order, itemIdList);

        order = orderWrapper.selectOrder(order.getId());

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    /**
     * 1004 加载订单
     * @param dinerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "orders", method = RequestMethod.GET)
    @ResponseBody
    @Page
    public ResponseEntity<?> getPaidOrders(@SessionKey SessionData sessionData, @PathVariable int dinerId, @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {
        int userId = sessionData.getUserId();

        PageInfo<Order> pageInfo = orderWrapper.selectPaidOrders(userId, dinerId);
        return new ResponseEntity<Object>(pageInfo, HttpStatus.OK);
    }

    /**
     * 2001 加载商户订单
     * @param dinerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "orders/all", method = RequestMethod.GET)
    @ResponseBody
    @Page
    public ResponseEntity<?> getPaidOrdersByCorp(@PathVariable int dinerId, @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                                 @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {
        PageInfo<Order> pageInfo = orderWrapper.selectAllOrders(dinerId);
        return new ResponseEntity<Object>(pageInfo, HttpStatus.OK);
    }


    @RequestMapping(value = "orders/{orderId}/push", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> pushOrder(@PathVariable int dinerId, @PathVariable int orderId) {
        Order order = orderWrapper.selectOrder(orderId);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String content = mapper.writeValueAsString(order);
            JPushUtil.sendPushOrder(content, "1");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOrderPaid(@PathVariable int orderId) {
        orderService.updateOrderPaid(orderId);

        Order order = orderWrapper.selectOrder(orderId);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String content = mapper.writeValueAsString(order);
            JPushUtil.sendPushOrder(content, "1");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

}
