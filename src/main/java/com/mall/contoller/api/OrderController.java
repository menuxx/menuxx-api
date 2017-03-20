package com.mall.contoller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.mall.annotation.SessionKey;
import com.mall.annotation.SessionData;
import com.mall.configure.AppConfiguration;
import com.mall.configure.page.Page;
import com.mall.model.Order;
import com.mall.model.OrderItem;
import com.mall.model.TCorp;
import com.mall.model.TCorpUser;
import com.mall.service.CorpService;
import com.mall.service.CorpUserService;
import com.mall.service.OrderService;
import com.mall.utils.Constants;
import com.mall.utils.IPushUtil;
import com.mall.utils.JPushUtil;
import com.mall.utils.Util;
import com.mall.weixin.*;
import com.mall.weixin.encrypt.SignEncryptorImpl;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
@Controller
public class OrderController extends BaseCorpController {

    /**
     * 支付回调地址
     */
    private static final String NOTIFY_URL = "https://dev.api.menuxx.com/weixin/pay_notify";

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    OrderService orderService;

    @Autowired
    CorpService corpsService;

    @Autowired
    WXPayService wxPayService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CorpUserService corpUserService;

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

        orderWrapper.createOrder(sessionData.getOpenid(), sessionData.getMchid(), order, itemIdList);

        // Body
        String body = "已成功支付¥" + order.getTotalAmount()/100;

        TCorp corp = corpsService.selectCorpByMchId(sessionData.getMchid());

        // 创建微信支付订单，向微信发起请求
        WXPaymentSignature paymentSignature = new WXPaymentSignature(corp.getAppId(), corp.getPaySecret());

        WXPayOrder payOrder = new WXPayOrder();
        payOrder.setAppid(corp.getAppId());
        payOrder.setMchId(corp.getMchId());
        payOrder.setNonceStr(Util.genNonce());
        payOrder.setNotifyUrl(NOTIFY_URL);
        payOrder.setOpenid(sessionData.getOpenid());
        payOrder.setOutTradeNo(order.getOrderCode());
        payOrder.setBody(body);
        payOrder.setTotalFee(order.getPayAmount());

        WXPayOrderDigest orderDigest = new WXPayOrderDigest(payOrder, corp.getPaySecret());
        orderDigest.digest(SignEncryptorImpl.MD5());

        DeferredResult<Map<String, String>> deferredResult = new DeferredResult<>();

        wxPayService.unifiedorder(payOrder).enqueue(new Callback<WXPayResult>() {
            @Override
            public void onResponse(Call<WXPayResult> call, Response<WXPayResult> response) {
                if (response.isSuccessful()) {
                    WXPayResult payResult = response.body();
                    String prePayId = payResult.getPrepayId();

                    Map<String, String> paySign = paymentSignature.update(prePayId).digest(SignEncryptorImpl.MD5()).toMap();
                    deferredResult.setResult(paySign);
                }
            }

            @Override
            public void onFailure(Call<WXPayResult> call, Throwable throwable) {
                deferredResult.setErrorResult(throwable);
            }
        });

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

        try {
            String content = objectMapper.writeValueAsString(order);
            JPushUtil.sendPushOrder(content, "1");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOrderPaid(@PathVariable int dinerId, @PathVariable int orderId) {
        orderService.updateOrderPaid(orderId);

        Order order = orderWrapper.selectOrder(orderId);

        List<TCorpUser> corpUserList = corpUserService.selectCorpUsersByCorpId(dinerId);

        List<String> clientIdList = new ArrayList<>();

        for (TCorpUser corpUser : corpUserList) {
            clientIdList.add(corpUser.getClientId());
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            String content = mapper.writeValueAsString(order);
            IPushUtil.sendPushOrder(appConfiguration, content, clientIdList);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

}
