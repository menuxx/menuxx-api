package com.mall.contoller.api;

import com.github.pagehelper.PageInfo;
import com.mall.configure.page.Page;
import com.mall.model.Order;
import com.mall.model.OrderItem;
import com.mall.utils.Constants;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
@Controller
public class OrderController extends BaseCorpContoller {


    @Autowired
    OrderWrapper orderWrapper;

    /**
     * 1002 创建订单
     * @param corpId
     * @param order
     * @return
     */
    @RequestMapping(value = "orders", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createOrder(@PathVariable int corpId, @RequestBody Order order) {
        // TODO 获取用户ID
        int userId = 1;
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


    @RequestMapping(value = "orders", method = RequestMethod.GET)
    @ResponseBody
    @Page
    public ResponseEntity<?> getPaidOrders(@PathVariable int corpId, @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {
        // TODO 获取用户ID
        int userId = 1;

        PageInfo<Order> pageInfo = orderWrapper.selectPaidOrders(userId, corpId);

        return new ResponseEntity<Object>(pageInfo, HttpStatus.OK);
    }
}
