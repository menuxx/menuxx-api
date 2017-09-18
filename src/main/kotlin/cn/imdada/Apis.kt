package cn.imdada

import feign.Body
import feign.Headers
import feign.Param
import feign.RequestLine

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/6
 * 微信: yin80871901
 */
@Headers("Accept: application/json", "Content-Type: application/json")
interface ImDadaApi {

    /**
     * 新增配送单接口
     * (1) 接口调用URL地址：/api/order/addOrder。
     * (2) 在测试环境，使用统一商户和门店进行发单。其中，商户id：73753，门店编号：11047059。
     */
    @RequestLine("POST /api/order/addOrder?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun addOrder(@Param("source_id") sourceId: String, order: DDOrder) : DDAddOrderResult

    /**
     * 重新发布订单
     * 在调用新增订单后，订单被取消、过期或者投递异常的情况下，调用此接口，可以在达达平台重新发布订单。
     * 接口调用URL地址：/api/order/reAddOrder。
     */
    @RequestLine("POST /api/order/reAddOrder?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun reAddOrder(@Param("source_id") sourceId: String, order: DDOrder) : DDAddOrderResult

    /**
     * 增加小费
     * 接口调用URL地址：/api/order/addTip
     * (1) 可以对待接单状态的订单增加小费。需要注意：订单的小费，以最新一次加小费动作的金额为准，故下一次增加小费额必须大于上一次小费额。
     */
    @RequestLine("POST /api/order/addTip?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\", \"tips\": \"{tips}\", \"city_code\": \"{city_code}\", \"info\": \"{info}\"%7D")
    @Throws(ImDadaException::class)
    fun addTips(@Param("source_id") sourceId: String, @Param("order_id") orderId: String, @Param("tips") tips: Float, @Param("city_code") cityCode: String, @Param("info") info: String) : DDResult

    @RequestLine("POST /api/order/status/query?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\"%7D")
    @Throws(ImDadaException::class)
    fun queryDetail(@Param("source_id") sourceId: String, @Param("order_id") orderId: String) : DDOrderDetailQueryResult

    /**
     * 预发布订单的操作流程是：使用【查询订单运费接口】获取平台订单编号，调用【查询运费后发单接口】即可发布订单。
     * 传入订单相关参数可以查询到该时刻订单所需的运费，同时返回一个唯一的平台订单编号，注意：该平台订单编号有效期为3分钟。
     */
    @RequestLine("POST /api/order/queryDeliverFee?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun queryDeliverFee(@Param("source_id") sourceId: String) : DDQueryDeliverFeeResult

    /**
     * 查询运费后发单接口
     * 根据【查询订单运费接口】返回的平台订单编号进行发单。只有新订单或者状态为已取消、已过期以及投递异常的情况下可以进行订单预发布。
     */
    @RequestLine("POST /api/order/addAfterQuery")
    @Throws(ImDadaException::class)
    fun addAfterQuery(deliveryNo: String) : DDQueryDeliverFeeResult

    @RequestLine("POST /api/cityCode/list?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun listCity(@Param("source_id") sourceId: String) : Array<DDCity>

    /**
     * 注册商户
     * 商户注册接口,并完成与该商户的绑定.生成的初始化密码会以短信形式发送给注册手机号
     * 接口URL地址：/merchantApi/merchant/add
     */
    @RequestLine("POST /merchantApi/merchant/add")
    @Throws(ImDadaException::class)
    fun addMerchant(merchant: DDMerchant) : Int

    /**
     * 新增门店
     * 批量新增门店接口,接口URL地址：/api/shop/add
     * 1. 门店编码可自定义，但必须唯一，若不填写，则系统自动生成。发单时用于确认发单门店
     * 2. 如果需要使用达达商家App发单，请设置登陆达达商家App的账号（必须手机号）和密码
     * 3. 该接口为批量接口,业务参数为数组
     */
    @RequestLine("POST /api/shop/add?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun addShop(@Param("source_id") sourceId: String, shop: Array<DDShop>) : DDAddShopResult

    /**
     * 编辑门店
     * 更新门店信息接口,接口URL地址：/api/shop/update
     * 门店编码是必传参数。其他参数，需要更新则传，且不能为空。
     */
    @RequestLine("POST /api/shop/update")
    @Throws(ImDadaException::class)
    fun updateShop(shop: DDShop) : DDResult

    /**
     * 门店详情
     * 查询门店详情接口,接口URL地址：/api/shop/detail
     */
    @RequestLine("POST /api/shop/detail")
    @Throws(ImDadaException::class)
    fun getShop(originShopId: String) : DDShop

    /**
     * 订单区取消原型查询接口
     * 查询门店详情接口,接口URL地址：/api/order/cancel/reasons
     */
    @RequestLine("POST /api/order/cancel/reasons?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun getCancelReasons(@Param("source_id") sourceId: String) : List<DDCancelReason>

    /**
     * 订单区取消接口
     * 查询门店详情接口,接口URL地址：/api/order/formalCancel
     */
    @RequestLine("POST /api/order/formalCancel?source_id={source_id}")
    @Throws(ImDadaException::class)
    fun formalCancel(@Param("source_id") sourceId: String, cancel: DDFormalCancel) : DDCancelResult

}

/**
 * 测试环境，模拟订单各状态的接口如下：
 * 注：接口仅限于测试环境调试使用，且触发回调URL成功后，接口直接返回成功；否则，重复三次触发，每次间隔3秒，最后返回成功。
 * 模拟接受订单
 * 模拟完成取货
 * 模拟完成订单
 * 模拟取消订单
 * 模拟订单过期
 */
@Headers("Accept: application/json", "Content-Type: application/json")
interface MockImDadaApi {

    /**
     * 模拟接受订单
     * order_id	String	是	第三方订单编号
     * 在测试环境中，可调用此接口接受订单，检测回调。
     * http://newopen.cn.imdada.cn/#/development/file/accept?_k=z2oear
     */
    @RequestLine("POST /api/order/accept?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\"%7D")
    @Throws(ImDadaException::class)
    fun accept(@Param("source_id") sourceId: String, @Param("order_id") orderId: String) : HashMap<String, Any>

    /**
     * 模拟完成取货
     * order_id	String	是	第三方订单编号
     * 在测试环境中，可调用此接口完成取货，检测回调。
     * http://newopen.cn.imdada.cn/#/development/file/fetch?_k=pwi5a6
     */
    @RequestLine("POST /api/order/fetch?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\"%7D")
    @Throws(ImDadaException::class)
    fun fetch(@Param("source_id") sourceId: String, @Param("order_id") orderId: String) : HashMap<String, Any>

    /**
     * 模拟完成订单
     * order_id	String	是	第三方订单编号
     * 在测试环境中，可调用此接口完成订单，检测回调。
     * http://newopen.cn.imdada.cn/#/development/file/finish?_k=6oyhb0
     */
    @RequestLine("POST /api/order/finish?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\"%7D")
    @Throws(ImDadaException::class)
    fun finish(@Param("source_id") sourceId: String, @Param("order_id") orderId: String) : HashMap<String, Any>

    /**
     * 模拟取消订单
     * order_id	String	是	第三方订单编号
     * reason	String	否	取消原因
     * 在测试环境中，可调用此接口取消订单，检测回调。
     * http://newopen.cn.imdada.cn/#/development/file/cancel?_k=s6j10i
     */
    @RequestLine("POST /api/order/cancel?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\", \"reason\": \"{reason}\"%7D")
    @Throws(ImDadaException::class)
    fun cancel(@Param("source_id") sourceId: String, @Param("order_id") orderId: String, @Param("reason") reason: String) : HashMap<String, Any>

    /**
     * 模拟订单过期
     * order_id	String	是	第三方订单编号
     * 在测试环境中，可调用此接口模拟订单过期，检测回调。
     * http://newopen.cn.imdada.cn/#/development/file/exipre?_k=tnrjno
     */
    @RequestLine("POST /api/order/expire?source_id={source_id}")
    @Body("%7B\"order_id\": \"{order_id}\"%7D")
    @Throws(ImDadaException::class)
    fun expire(@Param("source_id") sourceId: String, @Param("order_id") orderId: String) : HashMap<String, Any>

}