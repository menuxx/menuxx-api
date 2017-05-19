package com.mall.contoller.api;

import com.google.common.io.CharStreams;
import com.mall.model.TChargeApply;
import com.mall.model.TOrder;
import com.mall.model.TRechargeRecord;
import com.mall.service.ChargeApplyService;
import com.mall.service.OrderService;
import com.mall.service.RechargeRecordService;
import com.mall.utils.Constants;
import com.mall.weixin.*;
import com.mall.wrapper.OrderWrapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;

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

//	@PostMapping("weixin/orderpay")
//	public DeferredResult<Map<String, String>> wxPayment() {
//
//		DeferredResult<Map<String, String>> deferred = new DeferredResult<>();
//
//		String appSecret = "9982433695BB9D0CCA3416EF16755CFC";
//
//		String appId = "wx833943b167b4012a";
//
//		WXPaymentSignature wxPaymentSign = new WXPaymentSignature(appId, appSecret);
//
//		WXPayOrder payOrder = new WXPayOrder();
//
//		payOrder.setAppid(appId);
//		payOrder.setMchId("1444573602");
//		payOrder.setNonceStr(Util.genNonce());
//		payOrder.setNotifyUrl("https://dev.api.menuxx.com/weixin/pay_notify");
//		payOrder.setOpenid("oqdoZ0ZAdri71Wzu0A2RAQ1swghM");
//		payOrder.setOutTradeNo("612612647621462187348623857324");
//		payOrder.setBody("芝根芝底-美洲火鸡披萨");
//		payOrder.setSpbillCreateIp("127.0.0.1");
//		payOrder.setTotalFee(1);
//
//		WXPayOrderDigest payDigest = new WXPayOrderDigest(payOrder, appSecret);
//		payDigest.digest(SignEncryptorImpl.MD5());
//
//		wxPayService.unifiedorder(payOrder).enqueue(new Callback<WXPayResult>() {
//			@Override
//			public void onResponse(Call<WXPayResult> call, Response<WXPayResult> response) {
//				if ( response.isSuccessful() ) {
//					WXPayResult payResult = response.body();
//					String prePayId = payResult.getPrepayId();
//
//					Map<String, String> paySign = wxPaymentSign.update(prePayId).digest(SignEncryptorImpl.MD5()).toMap();
//
//					deferred.setResult(paySign);
//
//				}
//			}
//
//			@Override
//			public void onFailure(Call<WXPayResult> call, Throwable throwable) {
//				deferred.setErrorResult(throwable);
//			}
//		});
//
//		return deferred;
//
//	}

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

			chargeApply = new TChargeApply();

			chargeApply.setUserId(order.getUserId());
			chargeApply.setOrderId(order.getId());

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

			chargeApplyService.createChargeApply(chargeApply);

			// 如果状态码为 SUCCESS，更新付款状态
			if ("SUCCESS".equals(event.getResultCode())) {
				orderWrapper.setStatusToPaid(chargeApply);
				return "SUCCESS";
			}
		} else {
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

			chargeApply = new TChargeApply();

			chargeApply.setUserId(rechargeRecord.getUserId());
			chargeApply.setOrderId(rechargeRecord.getOrderId());

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

			chargeApplyService.createChargeApply(chargeApply);

			// 如果状态码为 SUCCESS，更新付款状态
			if ("SUCCESS".equals(event.getResultCode())) {
				orderWrapper.rechargeCompleted(chargeApply);
				return "SUCCESS";
			}

		} else {
			if ("SUCCESS".equals(event.getResultCode()) && !"SUCCESS".equals(chargeApply.getResultCode())) {
				// 更新状态
				orderWrapper.rechargeCompleted(chargeApply);
				return "SUCCESS";
			}
		}

		return "FAIL";
	}
}
