package com.mall.contoller.api;

import com.mall.model.Order;
import com.mall.model.ShoppingCart;
import com.mall.service.ShoppingCartService;
import com.mall.wrapper.OrderWrapper;
import com.mall.wrapper.ShoppingCartWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Supeng on 16/01/2017.
 */
@Controller
public class ShoppingCartController extends BaseCorpContoller {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ShoppingCartWrapper shoppingCartWrapper;

    @Autowired
    OrderWrapper orderWrapper;

    /**
     * 3001 添加购物车
     * @param corpId
     * @param itemId
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "items/{itemId}/shoppingcart", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createShoppingCart(@PathVariable int corpId, @PathVariable int itemId, @RequestBody ShoppingCart shoppingCart) {

        // TODO 用户编号解码
        int userId = 1;

        //数量默认 为 1
        if (shoppingCart.getQuantity() == null || shoppingCart.getQuantity() <= 0) {
            shoppingCart.setQuantity(1);
        }

        //必须包含规格信息，即 detail_id 不能为空
        if (shoppingCart.getDetailId() == null) {
            return new ResponseEntity<Object>("请选择商品规格", HttpStatus.BAD_REQUEST);
        }

        shoppingCart.setCorpId(corpId);
        shoppingCart.setItemId(itemId);
        shoppingCart.setUserId(userId);

        shoppingCart = shoppingCartWrapper.createShoppingCart(shoppingCart);

        return new ResponseEntity<Object>(shoppingCart, HttpStatus.OK);
    }

    /**
     * 3002 修改购物车
     * @param
     * @return
     */
    @RequestMapping(value = "shoppingcart/{shoppingCartId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateShoppingCart(@PathVariable int shoppingCartId, @RequestBody ShoppingCart shoppingCart) {
        //必须包含quantity
        if (shoppingCart.getQuantity() == null) {
            return new ResponseEntity<Object>("请设置商品数量", HttpStatus.BAD_REQUEST);
        }

        shoppingCartService.updateShoppingCartQuantily(shoppingCartId, shoppingCart.getQuantity());

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 3003 删除购物车
     * @param shoppingcartId
     * @return
     */
    @RequestMapping(value = "shoppingcart/{shoppingcartId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> removeShoppingCart(@PathVariable int shoppingcartId) {
        shoppingCartService.removeShoppingCart(shoppingcartId);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 3004 加载购物车
     * @param corpId
     * @return
     */
    @RequestMapping(value = "shoppingcart", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getShoppingCart(@PathVariable int corpId) {

        // TODO 用户编号解码
        int userId = 1;

        List<ShoppingCart> shoppingCartList = shoppingCartWrapper.getShoppingCart(corpId, userId);
        return new ResponseEntity<>(shoppingCartList, HttpStatus.OK);
    }

    /**
     * 3005 购物车直接下单
     * @param corpId
     * @param order
     * @return
     */
    @RequestMapping(value = "shoppingcart", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createOrderByShoppingCart(@PathVariable int corpId, @RequestBody Order order) {
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

        List<ShoppingCart> shoppingCartList = order.getShoppingCartList();
        if (shoppingCartList == null ||  shoppingCartList.size() == 0) {
            return new ResponseEntity<Object>("请选择购物车的商品", HttpStatus.BAD_REQUEST);
        }

        orderWrapper.createOrderByShoppingCart(order);
        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }
}
