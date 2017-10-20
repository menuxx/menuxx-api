package com.mall.contoller.api;

import com.mall.model.TChargeApply;
import com.mall.model.TOrder;
import com.mall.model.TRechargeRecord;
import com.mall.service.ChargeApplyService;
import com.mall.service.OrderService;
import com.mall.service.RechargeRecordService;
import com.mall.utils.Constants;
import com.mall.weixin.*;
import com.mall.wrapper.OrderWrapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
@RestController
public class PayNotifyController {

	private static final Logger logger = Logger.getLogger(PayNotifyController.class);

	@Autowired
	WXPayService wxPayService;

	@Autowired
	ChargeApplyService chargeApplyService;

	@Autowired
	OrderWrapper orderWrapper;

	@Autowired
	RechargeRecordService rechargeRecordService;

	@Autowired
	OrderService orderService;

	/**
	 * 微信支付回调频率：15/15/30/180/1800/1800/1800/1800/3600（秒）
	 * @param
	 * @return
	 */
	@PostMapping(path = "weixin/pay_notify", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	 public String onNotify(@RequestBody WXNotifyEvent event) {
		logger.info("***************************[tenpay] notify start***************************");

		logger.info(event);

		XStreamMarshaller xStreamMarshaller = Constants.getXStreamMarshaller();
		logger.info(xStreamMarshaller.getXStream().toXML(event));

		// 先获取 ChargeApply 是否存在
		TChargeApply chargeApply = chargeApplyService.selectChargeApplyByOutTradeNo(event.getOutTradeNo());

		// 如果为空，先创建 ChargeApply
		if (null == chargeApply) {

			String outTradeNo = event.getOutTradeNo();

			TOrder order = orderService.selectOrderByCode(outTradeNo);

			chargeApply = buildChargeApply(event, order.getUserId(), order.getId());

			chargeApplyService.createChargeApply(chargeApply);

			// 如果状态码为 SUCCESS，更新付款状态
			if ("SUCCESS".equals(event.getResultCode())) {
				orderWrapper.setStatusToPaid(chargeApply);
				return "SUCCESS";
			}
		} else {
			// 第一次支付失败的情况
			if ("SUCCESS".equals(event.getResultCode()) && !"SUCCESS".equals(chargeApply.getResultCode())) {
				// 更新状态
				orderWrapper.setStatusToPaid(chargeApply);
				return "SUCCESS";
			}
		}

		return "FAIL";

	}

	/**
	 * 微信支付回调频率：15/15/30/180/1800/1800/1800/1800/3600（秒）
	 * @param event
	 * @return
	 */
	@PostMapping(path = "weixin/pay_notify/recharge", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	public String onRechargeNotify(@RequestBody WXNotifyEvent event) {
		logger.info("***************************[tenpay] recharge notify start***************************");
		logger.info(event);

		XStreamMarshaller xStreamMarshaller = Constants.getXStreamMarshaller();
		logger.info(xStreamMarshaller.getXStream().toXML(event));

		TChargeApply chargeApply = chargeApplyService.selectChargeApplyByOutTradeNo(event.getOutTradeNo());

		// 如果为空，先创建 ChargeApply
		if (null == chargeApply) {
			String outTradeNo = event.getOutTradeNo();
			TRechargeRecord rechargeRecord = rechargeRecordService.selectRechargeRecordByCode(outTradeNo);

			chargeApply = buildChargeApply(event, rechargeRecord.getUserId(), rechargeRecord.getOrderId());
			chargeApplyService.createChargeApply(chargeApply);

			// 如果状态码为 SUCCESS，更新付款状态
			if ("SUCCESS".equals(event.getResultCode())) {
				// 订单充值
				orderWrapper.rechargeCompleted(chargeApply, event.getAttach());
				return "SUCCESS";
			}

		} else {
			if ("SUCCESS".equals(event.getResultCode()) && !"SUCCESS".equals(chargeApply.getResultCode())) {
				// 更新状态
				// 订单充值
				orderWrapper.rechargeCompleted(chargeApply, event.getAttach());
				return "SUCCESS";
			}
		}

		return "FAIL";
	}

	private TChargeApply buildChargeApply(WXNotifyEvent event, int userId, Integer orderId) {
		TChargeApply chargeApply = new TChargeApply();

		chargeApply.setUserId(userId);
		chargeApply.setOrderId(orderId);

		chargeApply.setAttach(event.getAttach());
		chargeApply.setBankType(event.getBankType());
		chargeApply.setCashFee(event.getCashFee());
		chargeApply.setFeeType(event.getFeeType());
		chargeApply.setIsSubscribe(event.getIsSubscribe());
		chargeApply.setMchId(event.getMchid());
		chargeApply.setNonceStr(event.getNonceStr());
		chargeApply.setOpenid(event.getOpenid());
		chargeApply.setOutTradeNo(event.getOutTradeNo());
		chargeApply.setResultCode(event.getResultCode());
		chargeApply.setReturnCode(event.getReturnCode());
		chargeApply.setSign(event.getSign());
		chargeApply.setTimeEnd(event.getTimeEnd());
		chargeApply.setTotalFee(event.getTotalFee());
		chargeApply.setTradeType(event.getTradeType());
		chargeApply.setTransactionId(event.getTransactionId());

		chargeApply.setDiviceInfo(event.getDeviceInfo());
		chargeApply.setSignType(event.getSignType());
		chargeApply.setErrCode(event.getErrCode());
		chargeApply.setErrCodeDes(event.getErrCodeDes());
		chargeApply.setSettlementTotalFee(event.getSettlementTotalFee());
		chargeApply.setCashFeeType(event.getCashFeeType());
		chargeApply.setCouponFee(event.getCouponFee());
		chargeApply.setCouponCount(event.getCouponCount());
		chargeApply.setCouponType0(event.getCouponType0());
		chargeApply.setCouponType1(event.getCouponType1());
		chargeApply.setCouponId0(event.getCouponId0());
		chargeApply.setCouponId1(event.getCouponId1());
		chargeApply.setCouponId2(event.getCouponId2());
		chargeApply.setCouponId3(event.getCouponId3());
		chargeApply.setCouponId4(event.getCouponId4());
		chargeApply.setCouponId5(event.getCouponId5());
		chargeApply.setCouponFee0(event.getCouponFee0());
		chargeApply.setCouponFee1(event.getCouponFee1());
		chargeApply.setCouponFee2(event.getCouponFee2());
		chargeApply.setCouponFee3(event.getCouponFee3());
		chargeApply.setCouponFee4(event.getCouponFee4());
		chargeApply.setCouponFee5(event.getCouponFee5());
		chargeApply.setReturnMsg(event.getReturnMsg());

		return chargeApply;
	}
}
