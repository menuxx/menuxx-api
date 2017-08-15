package com.yingtaohuo.feieprinter

import com.mall.model.Order
import com.mall.model.TCorp
import com.mall.utils.NumberUtil
import com.yingtaohuo.service.FeiePrinterService
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */
class FeieOrderPrinter(val printerClient: FeiePrinterClient, val feiePrinterService: FeiePrinterService) {

    val logger = LoggerFactory.getLogger(FeieOrderPrinter::class.java)!!

    val DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE)

    val Tpl01 = """<CB># {queueNo} 堂食(追单)</CB><BR>
<CB>{tableNo}号桌</CB><BR>
================================<BR>
<L>名称            数量      金额<L><BR>
--------------------------------<BR>
<L>经典欧式培根披萨</L><BR>
<L>                 2份    ￥32.0</L><BR>
--------------------------------<BR>
<L>匈牙利烤肉披萨</L><BR>
<L>                 3份    ￥65.0</L><BR>
--------------------------------<BR>
<L>水果圆舞曲披萨</L><BR>
<L>                 1份    ￥28.0</L><BR>
================================<BR>
合计：￥{payAmountText}(未支付)
流水号: {queueNo}
订单号：{orderNo}
时间：{createTime}
================================<BR>
<C>-----{shopName}-----</C>"""

    fun makeOrderTicketContent(order: Order, shop: TCorp) : String {

        var content = ""

        if ( order.status == Order.STATUS_CONFIRM ) {

            var stateText = "下单"

            // 第二次下单
            if (order.orderTimes > 1) {
                stateText = "追单"
            }

            content += "<CB># ${order.queueId} 堂食-$stateText</CB><BR>"

        }

        else if ( order.status == Order.STATUS_OFFLINE ) {

            var stateText = "结账"

            content += "<CB># ${order.queueId} 堂食-$stateText</CB><BR>"

        }

        else if ( order.status == Order.STATUS_PAID ) {

            content += "<CB># ${order.queueId} ${order.orderTypeText}</CB><BR>"

        }

        if ( order.table != null ) {
            content += "<CB>(${order.table.tableName}桌)</CB><BR>"
        }

        content += "================================<BR>\n" +
                "<L>名称            数量       金额<L><BR>"

        for (item in order.itemList) {
            content += "--------------------------------\n" +
                    "<L>${item.item.itemName}</L>\n" +
                    "<L>                 ${item.quantity}份    ￥${NumberUtil.fenToYuan2(item.payAmount)}</L><BR>"
        }

        content += "================================<BR>"

        if (!StringUtils.isBlank(order.remark)) {
            content += "<W>${order.remark}</W>\n" +
                    "================================<BR>"
        }

        if (order.status == Order.STATUS_CONFIRM) {
            content += "本次合计："
        } else {
            content += "合计："
        }


        val payStatusText = when(order.status) {
            Order.STATUS_OFFLINE -> "过其他方式结算"
            Order.STATUS_CONFIRM -> "待支付"
            Order.STATUS_PAID -> "已付款"
            else -> "未支付"
        }


        content += """￥${NumberUtil.fenToYuan2(order.payAmount)}($payStatusText)
流水号：${order.queueId}
订单号：${order.orderCode}
时间：${DateFormat.format(order.createTime)}<BR>"""

        // 如果是外卖
        if ( order.orderType == Order.ORDER_TYPE_DELIVERED ) {
            content += "-------------外卖---------------<BR>\n" +
                    "配送费                  ${NumberUtil.fenToYuan2(order.deliveryAmount)}\n"
        }

        content += "================================<BR>"

        // 如果是外卖 就显示外卖信息
        if ( order.orderType == Order.ORDER_TYPE_DELIVERED ) {
            content += "<L>配送信息: ${order.address.address} ${order.address.linkman} ${order.address.phone}</L>"
        }

        content + "<C>-----${shop.corpName}-----</C><BR>"

        if (!StringUtils.isBlank(shop.masterPhone)) {
            content += "<C>--联系:${shop.masterPhone}--</C>"
        }

        return content

    }

    fun printerOrderToShop(order: Order, shop: TCorp) {

        val content = makeOrderTicketContent(order, shop)

        val corpPrinters = feiePrinterService.selectShopPrinter(shop.id)

        for (printer in corpPrinters) {

            val resp = printerClient.print(printer.printerSn, content, 0)

            // 打印失败
            if ( resp.ret != 0 ) {
                logger.error("shopName: ${shop.corpName}, shopId: ${shop.id}, ret: ${resp.ret}, msg: ${resp.msg}")
            }

        }

    }

}
