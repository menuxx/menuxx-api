package com.mall.contoller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.configure.page.Page;
import com.mall.model.*;
import com.mall.service.*;
import com.mall.utils.Constants;
import com.mall.utils.QueueUtil;
import com.mall.utils.Util;
import com.mall.weixin.*;
import com.mall.weixin.encrypt.SignEncryptorImpl;
import com.mall.wrapper.OrderWrapper;
import com.yingtaohuo.service.PushService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.mall.utils.Util.genOrderNo;

/**
 * Created by Supeng on 14/02/2017.
 */
@Controller
public class OrderController extends BaseCorpController {

    private static final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    AppConfigureProperties appConfig;

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

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    RechargeRecordService rechargeRecordService;

    @Autowired
    UserBalanceService userBalanceService;

    @Autowired
    TopupService topupService;

    @Autowired
    PushService pushService;

    /**
     * 2023 发起充值
     * @param dinerId
     * @param orderId
     * @param sessionData
     * @param topupId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}/recharge/{topupId}", method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<?> createRecharge(@PathVariable int dinerId, @PathVariable int topupId, @PathVariable int orderId, @SessionKey SessionData sessionData) {
        int userId = sessionData.getUserId();

        // 获取充值配置
        TTopup topup = topupService.selectTopup(dinerId, topupId);

        DeferredResult<Map<String, String>> deferredResult = new DeferredResult<>();

        if (null == topup) {
            deferredResult.setErrorResult(new Exception("充值配置不匹配。"));
            return deferredResult;
        }

        // 创建充值记录
        TRechargeRecord rechargeRecord = new TRechargeRecord();
        rechargeRecord.setCorpId(dinerId);
        rechargeRecord.setUserId(userId);
        rechargeRecord.setOrderId(orderId);
        rechargeRecord.setRechargeCode(genOrderNo());
        rechargeRecord.setChargeType(Constants.CHARGE_TYPE_TOPUP);
        rechargeRecord.setAmount(topup.getRechargeAmount() + topup.getGiftAmount());
        rechargeRecord.setRemark(topup.getContent());
        rechargeRecord.setStatus(Constants.ZERO);

        rechargeRecordService.createRechargeRecord(rechargeRecord);

        String mchId = sessionData.getMchid();

        // 查询 个体店 和 平台店 的通用方案
        TCorp corp = corpsService.selectCorpByMchId(mchId);

        WXPayOrder payOrder = new WXPayOrder();
        payOrder.setAppid(corp.getAuthorizerAppid());
        payOrder.setMchId(corp.getMchId());
        payOrder.setNonceStr(Util.genNonce());
        payOrder.setNotifyUrl(appConfig.getRechargeNotifyUrl());
        payOrder.setOpenid(sessionData.getOpenid());
        payOrder.setOutTradeNo(rechargeRecord.getRechargeCode());
        payOrder.setBody(rechargeRecord.getRemark());
        payOrder.setTotalFee(topup.getRechargeAmount());

        WXPayOrderDigest orderDigest = new WXPayOrderDigest(payOrder, corp.getPaySecret());
        orderDigest.digest(SignEncryptorImpl.MD5());

        unifiedOrderAsync(payOrder, corp, deferredResult);

        return deferredResult;
    }

    private void unifiedOrderAsync(WXPayOrder payOrder, TCorp corp, DeferredResult<Map<String, String>> deferredResult) {

        // 创建微信支付订单，向微信发起请求
        WXPaymentSignature paymentSignature = new WXPaymentSignature(corp.getAuthorizerAppid(), corp.getPaySecret());

        wxPayService.unifiedorder(payOrder).enqueue(new Callback<WXPayResult>() {
            @Override
            public void onResponse(Call<WXPayResult> call, Response<WXPayResult> response) {
                if (response.isSuccessful()) {
                    WXPayResult payResult = response.body();
                    if ( "FAIL".equals(payResult.getReturnCode()) ) {
                        logger.error(payResult.getReturnMsg());
                        deferredResult.setErrorResult(new Exception(payResult.getReturnMsg()));
                        return;
                    }
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

    }

    /**
     * 1003 发起支付
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}/create", method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<?> createOrder(@PathVariable int orderId, @SessionKey SessionData sessionData) {

        int userId = sessionData.getUserId();

        Order order = orderWrapper.selectOrder(orderId);

        // Body
        String body = order.getItemList().get(0).getItem().getItemName();
        if (order.getItemList().size() > 1) {
            body += "...";
        }

        TCorp corp;

        if ( sessionData.getCorpId() != null ) {
            corp = corpsService.selectCorpByCorpId(sessionData.getCorpId());
        } else {
            corp = corpsService.selectCorpByMchId(sessionData.getMchid());
        }

        WXPayOrder payOrder = new WXPayOrder();
        payOrder.setAppid(corp.getAuthorizerAppid());
        payOrder.setMchId(corp.getMchId());
        payOrder.setNonceStr(Util.genNonce());
        payOrder.setNotifyUrl(appConfig.getPayNotifyUrl());
        payOrder.setOpenid(sessionData.getOpenid());
        payOrder.setOutTradeNo(order.getOrderCode());
        payOrder.setBody(body);
        payOrder.setTotalFee(order.getPayAmount());

        WXPayOrderDigest orderDigest = new WXPayOrderDigest(payOrder, corp.getPaySecret());
        orderDigest.digest(SignEncryptorImpl.MD5());

        DeferredResult<Map<String, String>> deferredResult = new DeferredResult<>();

        unifiedOrderAsync(payOrder, corp, deferredResult);

        return deferredResult;
    }

    /**
     * 1002 创建订单
     * @param dinerId
     * @param order
     * @param sessionData
     * @return
     */
    @RequestMapping(value = "orders", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createOrderNoPay(
        @PathVariable int dinerId,
        @RequestBody Order order,
        @RequestParam(required = false, defaultValue = "0") Integer confirm,
        @SessionKey SessionData sessionData) {
        int userId = sessionData.getUserId();
        order.setUserId(userId);

        logger.debug("================================");
        logger.trace(sessionData);
        logger.trace(order);
        logger.debug("================================");

        // 订单状态默认为未付款
        if ( confirm == 1 ) {
            order.setStatus(Order.STATUS_CONFIRM);
        } else {
            order.setStatus(Order.STATUS_CREATED);
        }
        order.setCorpId(dinerId);
        order.setPayType(Order.PAY_TYPE_WX);

        // 如果选择堂食，必须有桌号；否则桌号为空
        if (order.getOrderType() == Order.ORDER_TYPE_EAT_IN) {
            if (order.getTableId() == null) {
                return new ResponseEntity<Object>("请选择就餐桌号.", HttpStatus.BAD_REQUEST);
            }
        } else {
            order.setTableId(null);
        }

        orderWrapper.createOrder(order);

        order = orderWrapper.selectOrder(order.getId());

        TUserBalance userBalance = userBalanceService.selectUserBalance(userId, dinerId);

        if (null == userBalance) {
            order.setUserBalance(0);
        } else {
            order.setUserBalance(userBalance.getBalance());
        }

        // 如果订单为 确认下单类型 就推送该订单
        if (order.getStatus() == Order.STATUS_CONFIRM) {
            pushService.pushConfirmOrder(order.getCorpId(), order);
        }

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
     * 2001 加载商户订单（已支付订单）
     * @param dinerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Page
    @GetMapping("orders/all")
    @ResponseBody
    public PageInfo<Order> getOrdersByCorp(@PathVariable int dinerId,
                                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                           @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {
        // 获取所有确认订单, 已支付，和 已下单 都 拉取出来
        return orderWrapper.selectOrdersFilterStatusByCorpId(dinerId, Arrays.asList(1, 2));
    }

    /**
     * 2021 获取订单详情
     * @param dinerId
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getOrder(@PathVariable int dinerId, @PathVariable int orderId, @SessionKey SessionData sessionData) {

        Order order = orderWrapper.selectOrder(orderId);

        if (null == order) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 获取用户余额
        TUserBalance userBalance = userBalanceService.selectUserBalance(sessionData.getUserId(), dinerId);

        if (null == userBalance) {
            order.setUserBalance(0);
        } else {
            order.setUserBalance(userBalance.getBalance());
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "orders/{orderId}/push", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> pushOrder(@PathVariable int dinerId, @PathVariable int orderId) {
        Order order = orderWrapper.selectOrder(orderId);

        try {

            String content = objectMapper.writeValueAsString(order);

            // JPushUtil.sendPushOrder(content, "1");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     * 2024 充值卡支付
     * @param dinerId
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}/recharge_pay", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> rechargePay(@PathVariable int dinerId, @PathVariable int orderId, @SessionKey SessionData sessionData) {
        int userId = sessionData.getUserId();

        // 获取用户余额
        TUserBalance userBalance = userBalanceService.selectUserBalance(userId, dinerId);

        Order order = orderWrapper.selectOrder(orderId);

        if (userBalance.getBalance() < order.getPayAmount()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        orderWrapper.rechargePay(userId, dinerId, order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "orders/{orderId}/", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOrderPaid(@PathVariable int dinerId, @PathVariable int orderId) {
        // 创建排序号
        int queueId = QueueUtil.getQueueNum(dinerId);

        orderService.updateOrderPaid(orderId, Order.PAY_TYPE_RECHARGE, queueId);

        Order order = orderWrapper.pushOrder(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    /**
     * 2016 修改备注
     * @param dinerId
     * @param orderId
     * @param map
     * @return
     */
    @RequestMapping(value = "orders/{orderId}/remark", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOrderRemark(@PathVariable int dinerId, @PathVariable int orderId, @RequestBody Map<String, String> map) {
        String remark = map.get("remark");

        if (StringUtils.isNotBlank(remark)) {
            orderService.updateOrderRemark(orderId, remark);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
