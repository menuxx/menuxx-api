package com.mall.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/2
 * 微信: yin80871901
 *
 *
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

	@XStreamAlias("attach")
	private String attach;

	@XStreamAlias("bank_type")
	private String bankType;

	@XStreamAlias("cash_fee")
	private String cashFee;

	@XStreamAlias("fee_type")
	private String feeType;

	@XStreamAlias("is_subscribe")
	private String isSubscribe;

	@XStreamAlias("mch_id")
	private String mchid;

	@XStreamAlias("nonce_str")
	private String nonceStr;

	@XStreamAlias("openid")
	private String openid;

	@XStreamAlias("out_trade_no")
	private String outTradeNo;

	@XStreamAlias("result_code")
	private String resultCode;

	@XStreamAlias("return_code")
	private String returnCode;

	@XStreamAlias("sign")
	private String sign;

	@XStreamAlias("time_end")
	private String timeEnd;

	@XStreamAlias("total_fee")
	private String totalFee;

	@XStreamAlias("trade_type")
	private String tradeType;

	@XStreamAlias("transaction_id")
	private String transactionId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getCashFee() {
		return cashFee;
	}

	public void setCashFee(String cashFee) {
		this.cashFee = cashFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
