package me.ele.delivery

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import feign.Headers
import feign.Param
import feign.RequestLine
import java.util.AbstractMap.SimpleImmutableEntry



/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/1
 * 微信: yin80871901
 */

data class AccessToken(
        @get:JsonProperty("access_token") @SerializedName("access_token") val accessToken: String,
        @get:JsonProperty("expire_time") @SerializedName("expire_time") val expireTime: Long
)


@Headers("Accept: application/json", "Content-Type: application/json")
interface TokenApi {

    @RequestLine("GET /get_access_token?app_id={appId}&salt={salt}&signature={signature}")
    fun getAccessToken(@Param("appId") appId: String, @Param("salt") salt: Int, @Param("signature") signature: String) : Result<AccessToken>

}

@Headers("Accept: application/json", "Content-Type: application/json")
interface EleApis {

    //---------------- 订单接口 -----------------------//

    @RequestLine("POST /v2/order")
    @Throws(EleException::class)
    fun postOrder(order: ElePostOrder) : Any

    /**
     * 订单投诉
     */
    @RequestLine("POST /v2/order/complaint")
    @Throws(EleException::class)
    fun orderComplaint(complaint: OrderComplaint) : Any

    /**
     * 订单查询
     * 订单查询接口说明
     * 商户将订单推送给蜂鸟配送开放平台后，可随时调用订单查询接口获取订单详情及最新物流状态。
     * 商户若在推送订单长时间没有收到状态反馈时，可调用此接口查询订单状态，以保持商户系统和蜂鸟配送开放平台状态一致。
     */
    @RequestLine("POST /v2/order/query")
    @Throws(EleException::class)
    fun orderQuery(queryOrder: QueryOrderCode) : OrderInfo

    /**
     * 同步取消订单
     * 当商户将订单推送给蜂鸟配送开放平台后，可根据需要调用同步取消订单接口对订单进行取消操作。
     * 目前，商户只能在“配送中” 状态前进行取消，一旦订单状态已经进入“配送中”状态，之后将不允许商户再取消该订单。
     */
    @RequestLine("POST /v2/order/cancel")
    @Throws(EleException::class)
    fun orderCancel(cancelOrder: OrderCancel) : Any

    //--------------- 店铺接口 ----------------------//

    /**
     * 添加门店信息
     * 商户添加门店信息，商户只有添加了门店信息并且审核通过后，所属该门店的订单才能推送给开发平台。
     */
    @RequestLine("POST /v2/chain_store")
    @Throws(EleException::class)
    fun postShop(shop: EleShop) : Any

    /**
     * 查询门店信息
     * 商户可以通过该接口，查询已上传门店的基本信息。
     * 基本信息主要包括：门店名称、门店联系方式、门店地址、门店经纬度、门店经纬度属性、门店配送服务、门店认证状态等。
     */
    @RequestLine("POST /v2/chain_store/query")
    @Throws(EleException::class)
    fun queryShops(shopNames: QueryShopData) : ArrayList<QueryEleShop>

    //-------------- 其他接口 ------------------//
    /**
     * 订单骑手位置
     * 订单骑手位置接口说明
     * 商户将订单推送给蜂鸟配送开放平台后，可根据需要调用订单骑手位置查询接口获取骑手所在位置。
     * 目前，可以在已分配骑手状态之后调用此查询接口获取位置信息，若订单未分配骑手，或已经完成配送／异常，将无法再获取骑手位置。
     */
    @RequestLine("POST /v2/order/carrier")
    @Throws(EleException::class)
    fun fetchCarrier(orderCode: QueryOrderCode) : OrderCarrier

}