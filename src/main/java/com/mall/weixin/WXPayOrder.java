package com.mall.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mall.annotation.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/3/1
 * 微信: yin80871901
 * @doc https://pay.weixin.qq.com/wiki/doc/api/wxa/wxa_api.php?chapter=9_1
 */
@XStreamAlias("xml")
public class WXPayOrder {

	public static final String TRADE_TYPE_JSAPI = "JSAPI";

	@NotNull
	private String appid;

	/**
	 * 商户号
	 * 微信支付分配的商户号
	 */
	@XStreamAlias("mch_id")
	@JsonProperty("mch_id")
	private String mchId;

	/**
	 * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	 * @example
	 * 深圳分店
	 */
	private String attach;

	/**
	 * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	 */
	@XStreamAlias("device_info")
	@JsonProperty("device_info")
	private String deviceInfo;

	/**
	 * 商户订单号
	 * 商户系统内部的订单号,32个字符内、可包含字母
	 */
	@XStreamAlias("out_trade_no")
	@JsonProperty("out_trade_no")
	private String outTradeNo;

	/**
	 * 签名
	 */
	@NotNull
	private String sign;

	/**
	 * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
	 */
	@XStreamAlias("sign_type")
	@JsonProperty("sign_type")
	private String signType;

	/**
	 * 商品描述
	 * 128 长度
	 */
	@NotNull
	private String body;

	/**
	 * 商品详情
	 * 商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。
	 * 长度 6000
	 */
	@XStreamCDATA
	private String detail;

	/**
	 * 随机字符串
	 * 长度32
	 */
	@NotNull
	@JsonProperty("nonce_str")
	@XStreamAlias("nonce_str")
	private String nonceStr;

	/**
	 * 货币类型
	 * 符合ISO 4217标准的三位字母代码，默认人民币：CNY
	 */
	@XStreamAlias("fee_type")
	@JsonProperty("fee_type")
	private String feeType = "CNY";

	/**
	 * 总金额
	 */
	@NotNull
	@Min(1)
	@JsonProperty("total_fee")
	@XStreamAlias("total_fee")
	private Integer totalFee;

	/**
	 * 终端IP
	 * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 */
	@NotNull
	@JsonProperty("spbill_create_ip")
	@XStreamAlias("spbill_create_ip")
	private String spbillCreateIp;

	/**
	 * 交易起始时间
	 * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	 * @example
	 * 20091225091010
	 */
	@JsonProperty("time_start")
	@XStreamAlias("time_start")
	private String timeStart;

	/**
	 * 交易结束时间
	 * @example
	 * 20091225091010
	 */
	@JsonProperty("time_expire")
	@XStreamAlias("time_expire")
	private String timeExpire;

	/**
	 * 商品标记，代金券或立减优惠功能的参数
	 */
	@XStreamAlias("goods_tag")
	@JsonProperty("goods_tag")
	private String goodsTag;

	/**
	 * 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	 * @example
	 * http://www.weixin.qq.com/wxpay/pay.php
	 */
	@NotNull
	@JsonProperty("notify_url")
	@XStreamAlias("notify_url")
	private String notifyUrl;

	/**
	 * 交易类型
	 * 小程序取值如下：JSAPI
	 */
	@JsonProperty("trade_type")
	@XStreamAlias("trade_type")
	private String tradeType = TRADE_TYPE_JSAPI;

	/**
	 * 指定支付方式
	 * no_credit -- 指定不能使用信用卡支付
	 */
	@JsonProperty("limit_pay")
	@XStreamAlias("limit_pay")
	private String limitPay;

	/**
	 * 用户标识
	 * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取。
	 * @example
	 * 	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
	 */
	private String openid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
