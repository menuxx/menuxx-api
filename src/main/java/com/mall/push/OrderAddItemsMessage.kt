package com.mall.push

import com.yingtaohuo.eventbus.OrderAddItems

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/7/27
 * 微信: yin80871901
 */
class OrderAddItemsMessage(
        internal val _pushToken: String,
        internal val _channel: String,
        internal val _content: OrderAddItems,
        internal val _opts: Map<String, Any>? = hashMapOf()
) : PushDeviceMessage<OrderAddItems> {

    override fun getTitle() = "订单追加"
    override fun getName() = "OrderAddItemsMessage"
    override fun getPushToken() = _pushToken
    override fun getChannel() = _channel
    override fun getContent() = _content
    override fun getOpts() = _opts

}