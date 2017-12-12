package com.yingtaohuo.feieprinter

import com.mall.model.Order
import com.mall.model.TCorp
import com.mall.model.TRechargeRecord
import com.mall.model.TShopConfig
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
class FeieOrderPrinter(private val printerClient: FeiePrinterClient, private val feiePrinterService: FeiePrinterService) {

    val logger = LoggerFactory.getLogger(FeieOrderPrinter::class.java)!!

    val DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE)

    // 买单打印
    val Tpl03 = """<CB># 支付买单 </CB>
================================
<L>共支付 :￥200.00</L>
================================
微信支付：￥0.0
余额支付：￥170.00
优惠：￥30.00 (新人券)
支付单号：20171749123747272134
时间：2017-12-11 21:21:20
================================
<C>-----小露私房小厨-----</C>
"""
    // 支付买单 小票内容
    fun makePaymentTicketContent(shop: TCorp) : String {
        var content = "<CB># 支付买单</CB>\n"
        content += "<L>共支付 :￥" + 1 + "</L>\n"
        content += "================================\n"
        // content += "微信支付:￥" + wxPayAmount + "\n"
        content += "余额支付：￥" + 2 + "\n"
        content += "优惠：￥30.00 (新人券)\n"
        content += "支付单号：20171749123747272134\n"
        content += "时间：2017-12-11 21:21:20\n"
        content += "================================\n"
        content += "<C>-----小露私房小厨-----</C>"
        content += "<C>-----"+ shop.shopName +"-----</C>"
        return content
    }

    val Tpl02 = """<CB># 12 充值 </CB>
================================
<L>名称            数量      金额<L>
<L>充200送10元</L><BR>
<L>                1份    ￥200.00</L>
--------------------------------
================================
合计：￥200.00(微信支付)
流水号: 12
订单号：20171749123747272134
时间：2017-12-11 21:21:20
账户余额：￥200.00
================================
<QR>https://mp.weixin.qq.com/a/~~Cs0YJfyPeXI~IXuXRRYnN-A72hMJg3QzoA~~</QR>
<C>-----小露私房小厨-----</C>
"""

    fun makeRechargeTicketContent(record: TRechargeRecord, shop: TCorp, shopConfig: TShopConfig) : String {
        var content = "<CB># 12 充值 </CB>\n"
        content += "================================\n"
        content += "<L>名称            数量      金额<L>\n"
        content += "<L>"+ record.remark +"</L><BR>\n"
        content += "--------------------------------\n"
        content += "================================\n"
        content += "合计：￥200.00(微信支付)\n"
        content += "流水号: 12\n"
        content += "订单号："  + record.rechargeCode + "\n"
        content += "时间："+ record +"\n"
        content += "账户余额：￥200.00\n"
        content += "================================\n"
        if ( !StringUtils.isBlank(shopConfig.ticketWxliteQrcode) ) {
            content += "<QR>https://mp.weixin.qq.com/a/~~Cs0YJfyPeXI~IXuXRRYnN-A72hMJg3QzoA~~</QR>\n"
        }
        content += "<C>-----"+ shop.shopName +"-----</C>"
        return content
    }

    val Tpl01 = """<CB># {queueNo} 堂食(追单)</CB><BR>
<CB>{tableNo}号桌</CB><BR>
================================<BR>
<L>名称            数量      金额<L><BR>
--------------------------------<BR>
<L>经典欧式培根披萨</L><BR>
156213645231747
3213123123
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
<QR>https://mp.weixin.qq.com/a/~~Cs0YJfyPeXI~IXuXRRYnN-A72hMJg3QzoA~~</QR><BR>
<C>-----{shopName}-----</C>"""

    fun makeOrderTicketContent(order: Order, shop: TCorp, shopConfig: TShopConfig?) : String {

        var content = ""

        if ( order.status == Order.STATUS_CONFIRM ) {

            var stateText = "下单"

            // 第二次下单
            if (order.orderTimes > 1) {
                stateText = "追单"
            }

            content += "<CB># ${order.queueId} 堂食-$stateText</CB>\n"

        }

        else if ( order.status == Order.STATUS_OFFLINE ) {

            var stateText = "结账"

            content += "<CB># ${order.queueId} 堂食-$stateText</CB>\n"

        }

        else if ( order.status == Order.STATUS_PAID ) {

            content += "<CB># ${order.queueId} ${order.orderTypeText}</CB>\n"

        }

        if ( order.table != null ) {
            content += "<CB>(${order.table.tableName}桌)</CB>\n"
        }

        content += "================================\n" +
                "<L>名称            数量       金额<L>\n"

        for (item in order.itemList) {
            content += if (item.item.barCode != null && item.item.itemCode != null) {
                "--------------------------------\n" +
                        "<L>${item.item.itemName}</L>" +
                        "${item.item.barCode}\n" +
                        "${item.item.itemCode}\n" +
                        "<L>                 ${item.quantity}${item.item.unit ?: "份"}    ￥${NumberUtil.fenToYuan2(item.payAmount)}</L>\n"
            } else {
                "--------------------------------\n" +
                        "<L>${item.item.itemName}</L>" +
                        "<L>                 ${item.quantity}${item.item.unit ?: "份"}    ￥${NumberUtil.fenToYuan2(item.payAmount)}</L>\n"
            }
        }

        content += "================================"

        if (!StringUtils.isBlank(order.remark)) {
            content += "<W>备注：${order.remark}</W>\n" +
                    "================================"
        }

        if (order.status == Order.STATUS_CONFIRM) {
            content += "本次合计："
        } else {
            content += "合计："
        }

        val payStatusText = when(order.status) {
            Order.STATUS_OFFLINE -> "其他方式结算"
            Order.STATUS_CONFIRM -> "待支付"
            Order.STATUS_PAID -> "已付款"
            else -> "未支付"
        }


        content += """￥${NumberUtil.fenToYuan2(order.payAmount)}($payStatusText)
流水号：${order.queueId}
订单号：${order.orderCode}
时间：${DateFormat.format(order.createTime)}""" + "\n"

        // 如果是外卖
        if ( order.orderType == Order.ORDER_TYPE_DELIVERED ) {
            content += "-------------外卖---------------\n" +
                    "配送费                   ￥${NumberUtil.fenToYuan2(order.deliveryAmount)}\n"
        }

        content += "================================\n"

        // 如果是外卖 就显示外卖信息
        if ( order.orderType == Order.ORDER_TYPE_DELIVERED ) {
            content += "<L>配送信息: ${order.address.address} ${order.address.linkman} ${order.address.phone}</L>\n"
        }

        if ( shopConfig != null && !StringUtils.isBlank(shopConfig.ticketWxliteQrcode) ) {
            content += "<QR>"+ shopConfig.ticketWxliteQrcode +"</QR>\n"
        }

        content + "<C>-----${shop.corpName}-----</C>\n"

        if (!StringUtils.isBlank(shop.corpPhone)) {
            content += "<C>--联系:${shop.corpPhone}--</C>"
        }

        return content

    }

    fun printOrderToShop(order: Order, shop: TCorp, shopConfig: TShopConfig?) : Boolean {

        val content = makeOrderTicketContent(order, shop, shopConfig)

        // val resp = printerClient.print("217502382", content, 0)

        val corpPrinters = feiePrinterService.selectShopPrinter(shop.id)

        // 成功打印次数
        var successPrintCount = 0

        var allSuccess = false

        for ( printer in corpPrinters) {

            val resp = printerClient.print(printer.printerSn, content, 0)

            // 打印失败
            if ( resp.ret != 0 ) {
                logger.error("shopName: ${shop.corpName}, shopId: ${shop.id}, ret: ${resp.ret}, msg: ${resp.msg}")
            }

            // 绑定的所有打印机都成功打印
            if ( resp.ret == 0 ) {
                successPrintCount++
                if ( successPrintCount == corpPrinters.size ) {
                    allSuccess = true
                }
            }

        }

        return allSuccess

    }

}
