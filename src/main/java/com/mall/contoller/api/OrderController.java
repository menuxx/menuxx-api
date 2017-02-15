package com.mall.contoller.api;

import com.mall.model.Order;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supeng on 14/02/2017.
 */
@Controller
public class OrderController extends BaseCorpContoller {


    @Autowired
    OrderWrapper orderWrapper;

    @RequestMapping(value = "orders", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createOrder(@PathVariable int corpId, @RequestBody Order order) {
        // TODO 获取用户ID
        int userId = 0;
        order.setUserId(userId);

        // 订单状态默认为未付款
        order.setStatus(Order.STATUS_CREATED);
        order.setCorpId(corpId);

        // 如果选择堂食，必须有桌号；否则桌号为空
        if (order.getOrderType() == Order.ORDER_TYPE_EAT_IN) {
            if (order.getTableId() == null) {
                return new ResponseEntity<Object>("请选择就餐桌号.", HttpStatus.BAD_REQUEST);
            }
        } else {
            order.setTableId(null);
        }

        orderWrapper.createOrder(order);

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

}