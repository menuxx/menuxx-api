package com.yingtaohuo.configure

import com.yingtaohuo.feieprinter.FeieOrderPrinter
import com.yingtaohuo.feieprinter.FeiePrinterClient
import com.yingtaohuo.service.FeiePrinterService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/8/15
 * 微信: yin80871901
 */
@Configuration
open class FeiePrinterConfigure {

    val user = "80871901@qq.com"

    val ukey = "uva5fA5ujzFN43EV"

    @Bean
    open fun feiePrinterClient() : FeiePrinterClient {
        return FeiePrinterClient(user, ukey)
    }

    @Bean
    open fun orderPrinter(feiePrinterClient: FeiePrinterClient, feiePrinterService: FeiePrinterService) : FeieOrderPrinter {
        return FeieOrderPrinter(feiePrinterClient, feiePrinterService)
    }

}