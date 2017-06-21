package com.mall.push;

import com.tencent.xinge.Message;
import com.tencent.xinge.XingeApp;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class XGPusher implements IPusher {

    public static final Map<Integer, String> ErrorMap = new HashMap<>();

    static {
        ErrorMap.put(0, "调用成功");
        ErrorMap.put(-1, "参数错误 检查参数配置");
        ErrorMap.put(-2, "请求时间戳不在有效期内 检查设备当前时间");
        ErrorMap.put(-3, "sign校验无效 检查Access ID和Secret Key（注意不是Access Key）");
        ErrorMap.put(2, "参数错误 检查参数配置");
        ErrorMap.put(14, "收到非法token，例如iOS终端没能拿到正确的token Android Token长度为40位 iOS Token长度为64位");
        ErrorMap.put(15, "信鸽逻辑服务器繁忙 稍后重试");
        ErrorMap.put(19, "操作时序错误。例如进行tag操作前未获取到deviceToken 没有获取到deviceToken的原因：\n 1.没有注册信鸽或者苹果推送. \n 2.provisioning profile制作不正确");
        ErrorMap.put(20, "鉴权错误，可能是由于Access ID和Access Key不匹配 检查Access ID和Access Key");
        ErrorMap.put(40, "推送的token没有在信鸽中注册 检查token是否注册");
        ErrorMap.put(48, "推送的账号没有绑定token 检查帐号和token是否绑定 见推送指南：绑定/设置账号 见热门问题解答：账号和设备未绑定");
        ErrorMap.put(63, "标签系统忙 检查标签是否设置成功 见推送指南：设置标签");
        ErrorMap.put(71, "APNS服务器繁忙 苹果服务器繁忙，稍后重试");
        ErrorMap.put(73, "消息字符数超限 iOS最新支持1000字节左右，苹果的额外推送设置如角标，也会占用字节数");
        ErrorMap.put(76, "请求过于频繁，请稍后再试 全量广播限频为每3秒一次");
        ErrorMap.put(78, "循环任务参数错误");
        ErrorMap.put(100, "APNS证书错误。请重新提交正确的证书 证书格式是pem的，另外，注意区分生产证书、开发证书的区别");
    }

    static final Logger logger = LoggerFactory.getLogger(XGPusher.class);

    // year-mon-day hour:min:sec
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);

    private XingeApp xingeApp;

    public String getErrorFormCode(int errorCode) {
        String errMsg = ErrorMap.get(errorCode);
        if (errMsg == null) {
            return "其他错误";
        }
        return errMsg;
    }

    public XGPusher(Long accessId, String secretKey) {
        this.xingeApp = new XingeApp(accessId, secretKey);
    }

    @Override
    public PushState pushToDevice(String pushToken, String payload, Map<String, Object> opts) {

        String title = (String) opts.get("title");
        if (StringUtils.isBlank(title)) title = "订单推送";

        final Message msg = new Message();
        Long expireTime = TimeUnit.DAYS.toSeconds(1);
        msg.setExpireTime(expireTime.intValue());
        msg.setTitle(title);
        msg.setContent(payload);
        msg.setSendTime(dateFormat.format(new Date()));
        msg.setType(Message.TYPE_MESSAGE);

        JSONObject res = xingeApp.pushSingleDevice(pushToken, msg);
        int retCode = res.getInt("ret_code");
        if ( retCode != 0 ) {
            logger.error("XGPusher", getErrorFormCode(retCode));
        }
        return new PushState(true, "");
    }

}
