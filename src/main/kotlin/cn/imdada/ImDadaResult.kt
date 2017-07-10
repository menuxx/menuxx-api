package cn.imdada

import com.google.gson.annotations.SerializedName

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/3
 * 微信: yin80871901
 *
 * http://newopen.cn.imdada.cn/#/development/file/code?_k=9fsryy
 * 返回码说明
 * 返回码(code)	描述
 * -1	    系统异常
 * 0	    请求成功
 * 999	    系统维护中,暂时不能发单
 * 1994	    format值不正确,默认为json
 * 1995	    body值不能为null
 * 1996	    v的值不正确,默认为1.0
 * 1997	    原始订单order_id不能为空
 * 1998	    请求参数的个数不正确,请仔细核对
 * 1999	    接口请求的headers为application/json
 * 2000	    接口请求参数不能为空
 * 2001	    app_key无效
 * 2002	    app_key没有绑定上线
 * 2003	    签名错误
 * 2004	    无效的门店编号
 * 2005	    订单不存在,请核查订单号
 * 2006	    订单回调URL不存在
 * 2007	    参数query需按要求传值
 * 2008	    token不能为空
 * 2009	    timestamp不能为空
 * 2010	    signature不能为空
 * 2011	    达达订单不存在,数据异常
 * 2012	    订单正在处理中,请稍后再试
 * 2013	    请求接口参数异常,请查看开发文档参数设定
 * 2043	    门店未审核
 * 2044	    城市尚未开通
 * 2045	    商家支付账号不存在
 * 2047	    运费服务不可用
 * 2048	    订单取消原因ID不能为空
 * 2049	    订单取消原因ID对应其他,取消原因不能为空
 * 2050	    订单配送中,无法取消
 * 2051	    订单已完成配送,无法取消
 * 2052	    订单已过期,无法取消
 * 2053	    订单取消失败
 * 2054	    小费不能为空或者字符,必须为数字
 * 2055	    小费额度不能少于1元
 * 2056	    城市区号不能为空
 * 2057	    新增小费不能小于原来订单小费的值
 * 2058	    添加小费失败
 * 2059	    只有在待接单的情况下才能加小费
 * 2060	    新的订单,不能重新发单,请走正常发单流程
 * 2061	    只有已取消、已过期、投递异常的订单才能重发
 * 2062	    订单价格信息已过期,请重新查询后发单
 * 2063	    该订单已发布,请选择新的订单
 * 2064	    该订单状态不是已取消、已过期、投递异常,请选择新的订单
 * 2065	    该平台订单编号已处理,请勿重复请求
 * 2066	    该平台订单编号已处理,请勿重复请求
 * 2067	    该订单运费已查询,请稍后再试
 * 2068	    接口仅测试环境可用
 * 2069	    追加的订单与门店不匹配
 * 2070	    追加的订单已被接单
 * 2071	    追加的配送员不符合追加要求
 * 2072	    订单没有追加记录
 * 2073	    订单状态已经改变,取消失败
 * 2074	    取消追加订单失败
 * 2075	    投诉原因不能为空
 * 2076	    订单已取消,无法重复取消
 * 2077	    小费金额不能大于订单金额
 * 2104	    第三方订单号不能为空
 * 2105	    不能重复发单
 * 2106	    pay_for_supplier_fee不能为空
 * 2107	    fetch_from_receiver_fee不能为空
 * 2108	    deliver_fee不能为空
 * 2109	    is_prepay不能为空
 * 2110	    App密码设置不符合要求,必须包含数字和字母,长度在6~16内
 * 2111	    cargo_type不能为空
 * 2112	    cargo_weight不能为空
 * 2113	    cargo_price不能为空
 * 2114	    supplier_name不能为空
 * 2115	    supplier_address不能为空
 * 2116	    supplier_phone不能为空
 * 2117	    supplier_tel不能为空
 * 2118	    supplier_lat不能为空
 * 2119	    supplier_lng不能为空
 * 2120	    receiver_name不能为空
 * 2121	    receiver_address不能为空
 * 2122	    receiver_phone不能为空
 * 2123	    callback不能为空
 * 2124	    expected_fetch_time不能为空
 * 2125	    expected_finish_time不能为空
 * 2126	    city_code不能为空
 * 2127	    invoice_title不能为空
 * 2128	    receiver_lat或receiver_lng不能为空
 * 2129	    无效的收货地址,解析地址坐标失败
 * 2130	    该订单已发单,不能查询运费
 * 2131	    source_id不能为空
 * 2132	    门店已下线,不能发单
 * 2133	    投诉原因id不存在,请重新选择
 * 2134	    投诉失败
 * 2135	    订单状态为待接单,不能投诉
 * 2136	    门店尚未绑定商品类型
 * 2137	    订单异常,配送员信息不存在
 * 2138	    receiver_lat或receiver_lng值不能为null
 * 2139	    数据异常,receiver_lat大于receiver_lng值
 * 2155	    余额不足请充值
 * 2170	    期望完成时间不合法
 * 2200	    accountId不能为空
 * 2201	    password不能为空
 * 2300	    accountId不能为空
 * 2301	    merhcantId不能为空
 * 2400	    该商家尚未审核上线
 * 2401	    商家不存在
 * 2402	    门店不存在
 * 2403	    门店编号已存在
 * 2404	    城市名称city_name不正确
 * 2405	    区域名称area_name不正确
 * 2406	    没有可以更新的参数,请重新核对
 * 2407	    业务类型不存在,请重新选择
 * 2408	    门店状态不存在,请重新选择
 * 2409	    新的门店编号不能与现有的门店编号相同
 * 2410	    参数类型不正确, Double类型不能传null与字符串
 * 2411	    参数类型不正确, pay_for_supplier_fee为Double类型
 * 2412	    参数类型不正确, fetch_from_receiver_fee为Double类型
 * 2413	    参数类型不正确, deliver_fee为Double类型
 * 2414	    参数类型不正确, cargo_type值不在展示的列表中
 * 2415	    参数类型不正确, cargo_weight为Double
 * 2416	    参数类型不正确, cargo_num为Integer
 * 2417	    参数类型不正确, 可以不传,但是不能传null值
 * 2418	    expected_fetch_time为unix时间戳,精确到秒(10位)
 * 2419	    body参数json解析出错,请检查body内的参数格式是否正确
 * 2420	    QA环境禁止修改11047059门店编号
 * 2421	    order_mark_no格式不正确,仅包含数字(长度小于15)或为空
 * 2422	    order_mark格式不正确,仅包含字母(长度小于10)或为空
 */

val DDResultCodes = hashMapOf(
        -1      to  "系统异常",
        0       to  "请求成功",
        999     to  "系统维护中,暂时不能发单",
        1994    to  "format值不正确,默认为json",
        1995    to  "body值不能为null",
        1996    to  "v的值不正确,默认为1.0",
        1997    to  "原始订单order_id不能为空",
        1998    to  "请求参数的个数不正确,请仔细核对",
        1999    to  "接口请求的headers为application/json",
        2000    to  "接口请求参数不能为空",
        2001    to  "app_key无效",
        2002    to  "app_key没有绑定上线",
        2003    to  "签名错误",
        2004    to  "无效的门店编号",
        2005    to  "订单不存在,请核查订单号",
        2006    to  "订单回调URL不存在",
        2007    to  "参数query需按要求传值",
        2008    to  "token不能为空",
        2009    to  "timestamp不能为空",
        2010    to  "signature不能为空",
        2011    to  "达达订单不存在,数据异常",
        2012    to  "订单正在处理中,请稍后再试",
        2013    to  "请求接口参数异常,请查看开发文档参数设定",
        2043    to  "门店未审核",
        2044    to  "城市尚未开通",
        2045    to  "商家支付账号不存在",
        2047    to  "运费服务不可用",
        2048    to  "订单取消原因ID不能为空",
        2049    to  "订单取消原因ID对应其他,取消原因不能为空",
        2050    to  "订单配送中,无法取消",
        2051    to  "订单已完成配送,无法取消",
        2052    to  "订单已过期,无法取消",
        2053    to  "订单取消失败",
        2054    to  "小费不能为空或者字符,必须为数字",
        2055    to  "小费额度不能少于1元",
        2056    to  "城市区号不能为空",
        2057    to  "新增小费不能小于原来订单小费的值",
        2058    to  "添加小费失败",
        2059    to  "只有在待接单的情况下才能加小费",
        2060    to  "新的订单,不能重新发单,请走正常发单流程",
        2061    to  "只有已取消、已过期、投递异常的订单才能重发",
        2062    to  "订单价格信息已过期,请重新查询后发单",
        2063    to  "该订单已发布,请选择新的订单",
        2064    to  "该订单状态不是已取消、已过期、投递异常,请选择新的订单",
        2065    to  "该平台订单编号已处理,请勿重复请求",
        2066    to  "该平台订单编号已处理,请勿重复请求",
        2067    to  "该订单运费已查询,请稍后再试",
        2068    to  "接口仅测试环境可用",
        2069    to  "追加的订单与门店不匹配",
        2070    to  "追加的订单已被接单",
        2071    to  "追加的配送员不符合追加要求",
        2072    to  "订单没有追加记录",
        2073    to  "订单状态已经改变,取消失败",
        2074    to  "取消追加订单失败",
        2075    to  "投诉原因不能为空",
        2076    to  "订单已取消,无法重复取消",
        2077    to  "小费金额不能大于订单金额",
        2104    to  "第三方订单号不能为空",
        2105    to  "不能重复发单",
        2106    to  "pay_for_supplier_fee不能为空",
        2107    to  "fetch_from_receiver_fee不能为空",
        2108    to  "deliver_fee不能为空",
        2109    to  "is_prepay不能为空",
        2110    to  "App密码设置不符合要求,必须包含数字和字母,长度在6~16内",
        2111    to  "cargo_type不能为空",
        2112    to  "cargo_weight不能为空",
        2113    to  "cargo_price不能为空",
        2114    to  "supplier_name不能为空",
        2115    to  "supplier_address不能为空",
        2116    to  "supplier_phone不能为空",
        2117    to  "supplier_tel不能为空",
        2118    to  "supplier_lat不能为空",
        2119    to  "supplier_lng不能为空",
        2120    to  "receiver_name不能为空",
        2121    to  "receiver_address不能为空",
        2122    to  "receiver_phone不能为空",
        2123    to  "callback不能为空",
        2124    to  "expected_fetch_time不能为空",
        2125    to  "expected_finish_time不能为空",
        2126    to  "city_code不能为空",
        2127    to  "invoice_title不能为空",
        2128    to  "receiver_lat或receiver_lng不能为空",
        2129    to  "无效的收货地址,解析地址坐标失败",
        2130    to  "该订单已发单,不能查询运费",
        2131    to  "source_id不能为空",
        2132    to  "门店已下线,不能发单",
        2133    to  "投诉原因id不存在,请重新选择",
        2134    to  "投诉失败",
        2135    to  "订单状态为待接单,不能投诉",
        2136    to  "门店尚未绑定商品类型",
        2137    to  "订单异常,配送员信息不存在",
        2138    to  "receiver_lat或receiver_lng值不能为null",
        2139	to  "数据异常,receiver_lat大于receiver_lng值",
        2155	to  "余额不足请充值",
        2170	to  "期望完成时间不合法",
        2200	to  "accountId不能为空",
        2201	to  "password不能为空",
        2300	to  "accountId不能为空",
        2301	to  "merhcantId不能为空",
        2400	to  "该商家尚未审核上线",
        2401	to  "商家不存在",
        2402	to  "门店不存在",
        2403	to  "门店编号已存在",
        2404	to  "城市名称city_name不正确",
        2405	to  "区域名称area_name不正确",
        2406	to  "没有可以更新的参数,请重新核对",
        2407	to  "业务类型不存在,请重新选择",
        2408	to  "门店状态不存在,请重新选择",
        2409	to  "新的门店编号不能与现有的门店编号相同",
        2410	to  "参数类型不正确, Double类型不能传null与字符串",
        2411	to  "参数类型不正确, pay_for_supplier_fee为Double类型",
        2412	to  "参数类型不正确, fetch_from_receiver_fee为Double类型",
        2413	to  "参数类型不正确, deliver_fee为Double类型",
        2414	to  "参数类型不正确, cargo_type值不在展示的列表中",
        2415	to  "参数类型不正确, cargo_weight为Double",
        2416	to  "参数类型不正确, cargo_num为Integer",
        2417	to  "参数类型不正确, 可以不传,但是不能传null值",
        2418	to  "expected_fetch_time为unix时间戳,精确到秒(10位)",
        2419	to  "body参数json解析出错,请检查body内的参数格式是否正确",
        2420	to  "QA环境禁止修改11047059门店编号",
        2421	to  "order_mark_no格式不正确,仅包含数字(长度小于15)或为空",
        2422	to  "order_mark格式不正确,仅包含字母(长度小于10)或为空"
)

// 达达 请求结果
data class DDResult(
        val status: String,     // 	响应状态，成功为"success"，失败为"fail"
        val result: Any?,        //  响应结果，JSON对象，详见具体的接口描述
        val code: Int,       //  响应返回吗
        val msg: String,        //  响应描述
        val errorCode: String?   //  错误码
)

// 添加订单结果
data class DDAddOrderResult(
        val distance: Double,
        val fee: Double
)

// 重新发布订单结果
data class DDQueryDeliverFeeResult(
        val distance: Double,   // 配送距离(单位：米)
        val fee: Double,        // 运费(单位：元)
        val deliveryNo: String  // 平台订单编号
)

// 新增门店失败返回结果

data class DDAddShopFailedResultItem(
        val shopNo: String,
        val msg: String,
        val shopName: String
)

// 新增门店返回结果

data class DDAddShopResult(
        val success: Int,
        val successList: ArrayList<DDShop>,
        val failedList: ArrayList<DDAddShopFailedResultItem>
)

/**
 * 订单详情查询
 * 查询订单的相关信息以及骑手的相关信息，具体信息参见参数说明
 */
data class DDOrderDetailQueryResult(
        val orderId: String,            // 	第三方订单编号
        val statusCode: Int,            // 	状态编码(待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8)
        val statusMsg: String,          // 订单状态
        val transporterName: String,    // 骑手名称
        val transporterPhone: String,   // 骑手手机号
        val transporterLng: String,     // 骑手经度
        val transporterLat: String,     // 骑手纬度
        val deliveryFee: String,        // 	配送费,单位为元
        val tips: Double,               // 小费,单位为元
        val distance: Int,              // 配送距离,单位为米
        val createTime: String,         // 	发单时间
        var acceptTime: String,         // 接单时间,若未接单,则为空
        var fetchTime: String,          // 取货时间,若未取货,则为空
        val finishTime: String,         // 送达时间,若未送达,则为空
        val cancelTime: String          // 	取消时间,若未取消,则为空
)

/**
 * 取消订单(线上环境)
 * 在订单待接单或待取货情况下，调用此接口可取消订单。注意：接单后1－15分钟内取消订单，运费退回。同时扣除2元作为给配送员的违约金
 */
data class DDOrderCancel(
        // 扣除的违约金(单位：元)
        @SerializedName("deduct_fee")
        val deductFee: Double
)