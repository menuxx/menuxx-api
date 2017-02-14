package com.mall.contoller.api;

import com.mall.model.Order;
import com.mall.model.OrderItem;
import com.mall.model.TOrderItem;
import com.mall.service.OrderService;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Supeng on 18/01/2017.
 */
@Controller
public class OrderController extends BaseCorpContoller {

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    OrderService orderService;


    /**
     * 3006 直接下单
     * @param corpId
     * @param order
     * @return
     */
    @RequestMapping(value = "orders", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createOrder(@PathVariable int corpId, @RequestBody Order order) {
        //TODO 获取用户ID
        int userId = 1;
        order.setUserId(userId);

        //订单状态设置为待付款
        order.setStatus(Order.STATUS_CREATED);

        order.setCorpId(corpId);

        //必须包含 address_id
        if (order.getAddressId() == null || order.getAddressId() == 0) {
            return new ResponseEntity<Object>("请输入收货地址", HttpStatus.BAD_REQUEST);
        }

        List<OrderItem> orderItemList = order.getOrderItemList();

        //必须包含下单商品
        if (orderItemList == null || orderItemList.size() == 0) {
            return new ResponseEntity<Object>("请选择购买商品", HttpStatus.BAD_REQUEST);
        }

        for (TOrderItem orderItem : orderItemList) {
            if (orderItem.getDetailId() == null || orderItem.getDetailId() == 0) {
                return new ResponseEntity<Object>("请选择商品规格", HttpStatus.BAD_REQUEST);
            }
            if (orderItem.getQuantity() == null || orderItem.getQuantity() == 0) {
                return new ResponseEntity<Object>("请输入购买数量", HttpStatus.BAD_REQUEST);
            }
        }

        orderWrapper.createOrderByItem(order);

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    /**
     * 3008 获取订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getOrder(@PathVariable int orderId) {
        Order order = orderWrapper.selectOrder(orderId);
        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    /**
     * 3009 确认收货
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> setOrerSuccess(@PathVariable int orderId) {
        orderService.updateOrderStatus(orderId, Order.STATUS_SUCCEED);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 3010 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
        orderService.updateOrderStatus(orderId, Order.STATUS_DELETED);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }


}
