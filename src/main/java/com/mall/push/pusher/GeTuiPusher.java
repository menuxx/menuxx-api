package com.mall.push.pusher;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.mall.push.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GeTuiPusher extends AbstractPusher {

    static final Logger logger = LoggerFactory.getLogger(GeTuiPusher.class);

    public static final Map<String, String> ErrorMap = new HashMap<>();

    public static final String PUSHER_NAME = "getui-push";

    static {
        ErrorMap.put("ok", "成功");
        ErrorMap.put("successed_online", "状态在线下发");
        ErrorMap.put("successed_offline", "状态离线转入离线消息");
        ErrorMap.put("lastLogin", "用户离线时返回，用户最近一次登录时间戳");
        ErrorMap.put("msgTotal", "有效可下发总数");
        ErrorMap.put("msgProcess", "消息回执总数");
        ErrorMap.put("clickNum", "用户点击数");
        ErrorMap.put("successed_ignore", "无效用户，消息丢弃");
        ErrorMap.put("failed", "将cid列表加入黑名单失败");
        ErrorMap.put("invalidCidList", "无效的cid列表");
        ErrorMap.put("StopTaskError", "停止任务失败");
        ErrorMap.put("NotInDealRange", "该任务不在停止任务的范围内");
        ErrorMap.put("Error", "请求信息填写有误");
        ErrorMap.put("AppidError", "clientid绑定的appid与推送的appid不符");
        ErrorMap.put("AppKeyError", "Appkey填写错误");
        ErrorMap.put("sign_error", "Appkey与ClientId不匹配，鉴权失败");
        ErrorMap.put("domain_error", "填写的域名错误或者无法解析");
        ErrorMap.put("action_error", "未找到对应的action动作");
        ErrorMap.put("TokenMD5NoUsers", "在系统中未查找到用户");
        ErrorMap.put("TargetListIsNullOrSizeIs0", "目标用户列表为空");
        ErrorMap.put("taskIdNullError", "任务Id为空");
        ErrorMap.put("ServiceError！", "service错误");
        ErrorMap.put("AppidNoAppSecret", "appId没有对应的appSecret");
        ErrorMap.put("AppidNoMatchAppKey", "appid未找到对应的appkey");
        ErrorMap.put("TaskIdNotMatchAppKey", "taskId找不到对应的appKey");
        ErrorMap.put("NullMsgCommon", "未找到消息公共体");
        ErrorMap.put("PushMsgToListTimesOverLimit", "群推消息次数超限");
        ErrorMap.put("PushMsgToAppTimesOverLimit", "群推消息次数超限");
        ErrorMap.put("SendError", "消息发送失败");
        ErrorMap.put("SynSendError", "报文发送错误");
        ErrorMap.put("Online", "在线");
        ErrorMap.put("Offline", "离线");
        ErrorMap.put("Nobind", "cid未绑定appid");
        ErrorMap.put("FlowExceeded", "接口消息推送流量已超限");
        ErrorMap.put("BlackAppId", "appId为黑名单");
        ErrorMap.put("TokenMD5Error", "cid填写错误");
        ErrorMap.put("TagsNoUsers", "标签找不到对应用户");
        ErrorMap.put("AppIdNoUsers", "appid下找不到对应用户");
        ErrorMap.put("PushTotalNumOverLimit", "推送总数超限");
        ErrorMap.put("NoSuchTaskId", "无效contentid");
        ErrorMap.put("OverLimit", "每个clientId在24小时内只能设置一次");
        ErrorMap.put("ParsePushInfoError", "pushinfo消息格式有误");
        ErrorMap.put("DeviceTokenError", "无效devicetoken");
        ErrorMap.put("NoTargetDeviceToken", "没有填写devicetoken");
        ErrorMap.put("NOTarget", "没有推送目标");
        ErrorMap.put("TagInvalidOrNoAuth", "无效的变迁或没鉴权");
        ErrorMap.put("AliasNotBind", "别名没有绑定");
        ErrorMap.put("OtherError", "未知错误，无法判定错误类型");
        ErrorMap.put("GroupNumOverLimit", "直播间超过套餐值");
        ErrorMap.put("GroupCidNumOverLimit", "单个直播间的cid数超过套餐值");
        ErrorMap.put("PushTooFrequency", "直播间推送过频");
        ErrorMap.put("PushTotalOverLimit", "直播间当天推送总数超限");
        ErrorMap.put("AppidOrGroupidErr", "直播间查询传入的appid和groupid不对应");
    }

    public String getErrorFormCode(String errorCode) {
        String errMsg = ErrorMap.get(errorCode);
        if (errMsg == null) {
            return "其他错误";
        }
        return errMsg;
    }

    private String host;

    private String appKey;

    private String appid;

    private String masterSecret;

    private boolean useSSL;

    private IGtPush push;

    public GeTuiPusher(String host, String appKey, String appid, String masterSecret, boolean useSSL) {
        this.host = host;
        this.appKey = appKey;
        this.appid = appid;
        this.masterSecret = masterSecret;
        this.useSSL = useSSL;
    }

    @Override
    public String getName() {
        return PUSHER_NAME;
    }

    @Override
    public void initialize() throws ClientInitException {
        push = new IGtPush(host, appKey, masterSecret);
    }

    @Override
    public PushState pushToClient(String clientAlias, String payload, Map<String, Object> opts) {
        // 透传模版
        TransmissionTemplate dataTpl = new TransmissionTemplate();
        dataTpl.setAppId(appid);
        dataTpl.setAppkey(appKey);
        if (getOptBool(opts, PushConst.OPTS_WAKEUP_EVERY)) {
            // 收到消息是否立即启动应用，1为立即启动，2则广播等待客户端自启动
            dataTpl.setTransmissionType(1);
        }
        dataTpl.setTransmissionContent(payload); //content长度：2048中/英字符，不支持转义字符
        SingleMessage msg = new SingleMessage();
        if (getOptBool(opts, PushConst.OPTS_MSG_EXPIRE_ENABLE)) {
            msg.setOfflineExpireTime(getOptLong(opts, PushConst.OPTS_MSG_EXPIRE_TIME));
        }

        msg.setData(dataTpl);

        // 配置推送目标
        Target target = new Target();
        target.setAppId(appid);
        target.setAlias(clientAlias);

        IPushResult _result = push.pushMessageToSingle(msg, target);

        Map<String, Object> result = _result.getResponse();

        String resCode = (String) result.get("result");

        if ( "ok".equals(resCode) ) {
            return new PushState(true, "ok", (String) result.get("msgId"));
        } else {
            logger.error("PushException", resCode + " " + getErrorFormCode(resCode));
            return new PushState(false, getErrorFormCode(resCode));
        }
    }
}
