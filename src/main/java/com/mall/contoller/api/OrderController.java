package com.mall.contoller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.configure.page.Page;
import com.mall.exception.NotFoundException;
import com.mall.exception.WXPayException;
import com.mall.model.*;
import com.mall.service.*;
import com.mall.utils.Constants;
import com.mall.utils.QueueUtil;
import com.mall.utils.Util;
import com.mall.weixin.*;
import com.mall.weixin.encrypt.SignEncryptorImpl;
import com.mall.wrapper.OrderWrapper;
import com.yingtaohuo.service.ActivityOrderService;
import com.yingtaohuo.service.CouponService;
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

import java.io.IOException;
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

    @Autowired
    ActivityOrderService activityOrderService;

    @Autowired
    CouponService couponService;

    @Autowired
    ItemService itemService;

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
    public Map<String, String> createRecharge(@PathVariable int dinerId, @PathVariable int topupId, @PathVariable int orderId, @SessionKey SessionData sessionData) {

        int userId = sessionData.getUserId();

        // 获取充值配置
        TTopup topup = topupService.selectTopup(dinerId, topupId);

        if (null == topup) {
            throw new RuntimeException("充值配置不匹配。");
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

        return unifiedOrderWithPaySign(payOrder, corp);

    }

    private WXPayResult unifiedOrder(WXPayOrder payOrder) throws WXPayException {
        try {
            Response<WXPayResult> resp = wxPayService.unifiedorder(payOrder).execute();
            if (resp.isSuccessful()) {
                WXPayResult payResult = resp.body();
                if ( "FAIL".equals(payResult.getReturnCode()) ) {
                    logger.error(payResult.getReturnMsg());
                    throw new WXPayException(payResult.getReturnMsg());
                }
                return payResult;
            }
            throw new WXPayException(resp.message());
        } catch (IOException e) {
            throw new WXPayException(e.getMessage());
        }
    }

    private Map<String, String> unifiedOrderWithPaySign(WXPayOrder payOrder, TCorp corp) {
        // 创建微信支付订单，向微信发起请求
        WXPaymentSignature paymentSignature = new WXPaymentSignature(corp.getAuthorizerAppid(), corp.getPaySecret());
        WXPayResult payResult = unifiedOrder(payOrder);
        String prePayId = payResult.getPrepayId();
        return paymentSignature.update(prePayId).digest(SignEncryptorImpl.MD5()).toMap();
    }

    /**
     *  使用优惠券, 一般是
     */
    @PutMapping("orders/{orderId}/coupons")
    @ResponseBody
    public TOrder applyCoupon(@SessionKey SessionData sessionData, @PathVariable int orderId, @RequestBody Map<String, Object> map) {

        Integer couponId = (Integer) map.get("couponId");

        int userId = sessionData.getUserId();
        Order order = orderWrapper.selectOrder(orderId);
        order.setUserId(userId);
        // 让 订单计算计算新的 优惠券
        order.setCouponId(couponId);
        List<Integer> itemIdList = new ArrayList<>();
        if (order.getItemList() != null && order.getItemList().size() > 0) {
            for (OrderItem orderItem : order.getItemList()) {
                itemIdList.add(orderItem.getItemId());
            }
        }
        Map<Integer, TItem> itemMap = itemService.selectItemsForMap(itemIdList);
        if ( couponId == null ) {
            // 当更换 卡券的时候 传 空，就不计算卡券
            order.setCouponId(null);
            return orderWrapper.calcOrder(order, itemMap, false);
        }
        orderWrapper.calcOrder(order, itemMap, true);
        // 将新计算的结果更新到数据库
        orderService.updateOrder(order);
        return order;
    }

    /**
     * 1003 发起支付
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orders/{orderId}/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> createOrder(@PathVariable int orderId, @SessionKey SessionData sessionData) {

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

        WXPayResult payResult = unifiedOrder(payOrder);

        // 创建微信支付订单，向微信发起请求
        WXPaymentSignature paymentSignature = new WXPaymentSignature(corp.getAuthorizerAppid(), corp.getPaySecret());

        String prePayId = payResult.getPrepayId();

        // 更新 prepayId
        orderService.updatePrepayId(orderId, prePayId);

        return paymentSignature.update(prePayId).digest(SignEncryptorImpl.MD5()).toMap();
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

        // 下单次数
        order.setOrderTimes(1);

        logger.debug("================================");
        logger.trace(sessionData);
        logger.trace(order);
        logger.debug("================================");

        // 订单状态默认为未付款
        if ( confirm == 1 ) {
            // 大店版 确认类型的订单 ，需要生成 流水号
            order.setStatus(Order.STATUS_CONFIRM);
            int queueId = QueueUtil.getQueueNum(dinerId);
            order.setQueueId(queueId);
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

        List<Integer> itemIdList = new ArrayList<>();
        if (order.getItemList() != null && order.getItemList().size() > 0) {
            for (OrderItem orderItem : order.getItemList()) {
                itemIdList.add(orderItem.getItemId());
            }
        }

        orderWrapper.createOrder(order, itemIdList);

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
        return orderWrapper.selectOrdersFilterStatusByCorpId(dinerId, Arrays.asList(Order.STATUS_PAID, Order.STATUS_CONFIRM, Order.STATUS_OFFLINE));
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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        orderWrapper.rechargePay(userId, dinerId, order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "orders/{orderId}/", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOrderPaid(@PathVariable int dinerId, @PathVariable int orderId) {

        TOrder tOrder =  orderService.selectOrder(orderId);

        // 大店版创建定单的时候就已经产生了流水号
        // 所以当流水号已经存在的时候，就不在创建流水号
        if ( tOrder.getQueueId() == null ) {
            // 创建排序号
            int queueId = QueueUtil.getQueueNum(dinerId);
            orderService.updateOrderPaid(orderId, Order.PAY_TYPE_RECHARGE, queueId);
        }

        Order order = orderWrapper.pushOrder(orderWrapper.selectOrder(orderId));

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
