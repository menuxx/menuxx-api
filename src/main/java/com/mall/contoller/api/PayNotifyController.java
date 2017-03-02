package com.mall.contoller.api;

import com.mall.model.TChargeApply;
import com.mall.service.ChargeApplyService;
import com.mall.utils.Util;
import com.mall.weixin.*;
import com.mall.weixin.encrypt.SignEncryptorImpl;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Map;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 */
@RestController
public class PayNotifyController {

	@Autowired
	WXPayService wxPayService;

	@Autowired
	ChargeApplyService chargeApplyService;

	@Autowired
	OrderWrapper orderWrapper;

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

	@PostMapping("weixin/pay_notify")
	public ResponseEntity<?> onNotify(@RequestBody WXNotifyEvent event) {


		if ("SUCCESS".equals(event.getResultCode())) {
			TChargeApply chargeApply = chargeApplyService.selectChargeApplyByOutTradeNo(event.getOutTradeNo());

			if (null != chargeApply) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}

			chargeApply = new TChargeApply();
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

			orderWrapper.setStatusToPaid(chargeApply);
			return new ResponseEntity<Object>(HttpStatus.OK);

		}

		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
