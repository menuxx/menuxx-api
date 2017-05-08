package com.mall.utils;

import com.mall.weixin.CDATADomDriver;
import com.mall.weixin.WXNotifyEvent;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.xstream.XStreamMarshaller;

/**
 * Created by Supeng on 12/01/2017.
 */
public class Constants {

    // 入驻类型商户
    public static final Integer CORP_TYPE_ENTER = 1;

    // 独立类型商户
    public static final Integer CORP_TYPE_INDEPENDENT = 0;

    public static final Integer ZERO = 0;

    public static final Integer ONE = 1;

    // 默认第一页
    public static final String DEFAULT_PAGENUM = "1";

    // 默认每页10条
    public static final String DEFAULT_PAGESIZE = "10";

    // 多字段 分割符
    public static final String SEPARATOR = ":";

    // 充值类型：充值
    public static final Integer CHARGE_TYPE_TOPUP = 0;
    // 充值类型：消费
    public static final Integer CHARGE_TYPE_PAY = 1;

    public static XStreamMarshaller getXStreamMarshaller() {
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xstreamMarshaller.setAutodetectAnnotations(true);
        xstreamMarshaller.setStreamDriver(new CDATADomDriver());
        xstreamMarshaller.getXStream().alias("xml", WXNotifyEvent.class);
        return xstreamMarshaller;
    }
}
