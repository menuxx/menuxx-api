package com.mall.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 *
 * 参考： https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
 */
@XStreamAlias("xml")
public class WXNotifyEvent {

	// ---------------------------------------------------------
	// 财付通支付通知（后台通知）示例，商户按照此文档进行开发即可
	// ---------------------------------------------------------

	//	 <xml><appid><![CDATA[wx506ab893668b8798]]></appid>
	//	 <attach><![CDATA[5265_704_13738142344]]></attach>
	//	 <bank_type><![CDATA[CFT]]></bank_type>
	//	 <cash_fee><![CDATA[1]]></cash_fee>
	//	 <fee_type><![CDATA[CNY]]></fee_type>
	//	 <is_subscribe><![CDATA[N]]></is_subscribe>
	//	 <mch_id><![CDATA[1236288401]]></mch_id>
	//	 <nonce_str><![CDATA[8e036cc193d0af59aa9b22821248292b]]></nonce_str>
	//	 <openid><![CDATA[oDsmJt_4m6Fbn_-Y3Vgf1x-qdtUU]]></openid>
	//	 <out_trade_no><![CDATA[151de84cca69258b17375e2f44239191]]></out_trade_no>
	//	 <result_code><![CDATA[SUCCESS]]></result_code>
	//	 <return_code><![CDATA[SUCCESS]]></return_code>
	//	 <sign><![CDATA[43A3262DA67FAA7EEE85BF9F3478D9A7]]></sign>
	//	 <time_end><![CDATA[20150417163916]]></time_end>
	//	 <total_fee>1</total_fee>
	//	 <trade_type><![CDATA[APP]]></trade_type>
	//	 <transaction_id><![CDATA[1003240555201504170069012054]]></transaction_id></xml>

	@XStreamAlias("appid")
	private String appId;

	@XStreamAlias("mch_id")
	private String mchid;

	//new
	@XStreamAlias("device_info")
	private String deviceInfo;

	@XStreamAlias("nonce_str")
	private String nonceStr;

	@XStreamAlias("sign")
	private String sign;

	//new
	@XStreamAlias("sign_type")
	private String signType;

	@XStreamAlias("result_code")
	private String resultCode;

	//new
	@XStreamAlias("err_code")
	private String errCode;

	//new
	@XStreamAlias("err_code_des")
	private String errCodeDes;

	@XStreamAlias("openid")
	private String openid;

	@XStreamAlias("is_subscribe")
	private String isSubscribe;

	@XStreamAlias("trade_type")
	private String tradeType;

	@XStreamAlias("bank_type")
	private String bankType;

	@XStreamAlias("total_fee")
	private Integer totalFee;

	//new
	@XStreamAlias("settlement_total_fee")
	private Integer settlementTotalFee;


	@XStreamAlias("fee_type")
	private String feeType;

	@XStreamAlias("cash_fee")
	private Integer cashFee;

	//new
	@XStreamAlias("cash_fee_type")
	private String cashFeeType;

	// new
	@XStreamAlias("coupon_fee")
	private Integer couponFee;

	//new
	@XStreamAlias("coupon_count")
	private Integer couponCount;

	//new
	@XStreamAlias("coupon_type_0")
	private Integer couponType0;

	//new
	@XStreamAlias("coupon_type_1")
	private Integer couponType1;

	//new
	@XStreamAlias("coupon_id_0")
	private String couponId0;

	//new
	@XStreamAlias("coupon_id_1")
	private String couponId1;

	//new
	@XStreamAlias("coupon_id_2")
	private String couponId2;

	//new
	@XStreamAlias("coupon_id_3")
	private String couponId3;

	//new
	@XStreamAlias("coupon_id_4")
	private String couponId4;

	@XStreamAlias("transaction_id")
	private String transactionId;

	@XStreamAlias("out_trade_no")
	private String outTradeNo;

	@XStreamAlias("attach")
	private String attach;

	@XStreamAlias("time_end")
	private String timeEnd;

	@XStreamAlias("return_code")
	private String returnCode;

	@XStreamAlias("return_msg")
	private String returnMsg;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public Integer getCouponType0() {
		return couponType0;
	}

	public void setCouponType0(Integer couponType0) {
		this.couponType0 = couponType0;
	}

	public Integer getCouponType1() {
		return couponType1;
	}

	public void setCouponType1(Integer couponType1) {
		this.couponType1 = couponType1;
	}

	public String getCouponId0() {
		return couponId0;
	}

	public void setCouponId0(String couponId0) {
		this.couponId0 = couponId0;
	}

	public String getCouponId1() {
		return couponId1;
	}

	public void setCouponId1(String couponId1) {
		this.couponId1 = couponId1;
	}

	public String getCouponId2() {
		return couponId2;
	}

	public void setCouponId2(String couponId2) {
		this.couponId2 = couponId2;
	}

	public String getCouponId3() {
		return couponId3;
	}

	public void setCouponId3(String couponId3) {
		this.couponId3 = couponId3;
	}

	public String getCouponId4() {
		return couponId4;
	}

	public void setCouponId4(String couponId4) {
		this.couponId4 = couponId4;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}
