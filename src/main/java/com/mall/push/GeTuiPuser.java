package com.mall.push;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.mall.push.IPusher;
import com.mall.push.PushState;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GeTuiPuser implements IPusher {

    public static final Map<Integer, String> ErrorMap = new HashMap<>();

    /*
    ok	成功
    successed_online	result=ok，状态在线下发
    successed_offline	result=ok，状态离线转入离线消息
    lastLogin	用户离线时返回，用户最近一次登录时间戳
    msgTotal	有效可下发总数
    msgProcess	消息回执总数
    clickNum	用户点击数


    错误返回	返回码	结果说明
    successed_ignore	无效用户，消息丢弃
    failed	将cid列表加入黑名单失败
    invalidCidList	无效的cid列表
    StopTaskError	停止任务失败
    NotInDealRange	该任务不在停止任务的范围内
    Error	请求信息填写有误
    AppidError	clientid绑定的appid与推送的appid不符
    AppKeyError	Appkey填写错误
    sign_error	Appkey与ClientId不匹配，鉴权失败
    domain_error	填写的域名错误或者无法解析
    action_error	未找到对应的action动作
    PushTotalNumOverLimit	推送消息个数总数超限
    TokenMD5NoUsers	在系统中未查找到用户
    TargetListIsNullOrSizeIs0	目标用户列表为空
    taskIdNullError	任务Id为空
    ServiceError！	service错误
    AppidNoAppSecret	appId没有对应的appSecret
    AppidNoMatchAppKey	appid未找到对应的appkey
    TaskIdNotMatchAppKey	taskId找不到对应的appKey
    NullMsgCommon	未找到消息公共体
    PushMsgToListTimesOverLimit	群推消息次数超限
    PushMsgToAppTimesOverLimit	群推消息次数超限
    TokenMD5NoUsers	在系统中未查找到用户
    SendError	消息发送失败
    SynSendError	报文发送错误
    Online	在线
    Offline	离线
    Nobind	cid未绑定appid
    FlowExceeded	接口消息推送流量已超限
    BlackAppId	appId为黑名单
    TokenMD5Error	cid填写错误
    TagsNoUsers	标签找不到对应用户
    AppIdNoUsers	appid下找不到对应用户
    PushTotalNumOverLimit	推送总数超限
    NoSuchTaskId	无效contentid
    OverLimit	每个clientId在24小时内只能设置一次
    ParsePushInfoError	pushinfo消息格式有误
    DeviceTokenError	无效devicetoken
    NoTargetDeviceToken	没有填写devicetoken
    TaskIdNotMatchAppKey	taskId找不到对应的appKey
    NOTarget	没有推送目标
    TagInvalidOrNoAuth	无效的变迁或没鉴权
    AliasNotBind	别名没有绑定
    OtherError	未知错误，无法判定错误类型
    GroupNumOverLimit	直播间超过套餐值
    GroupCidNumOverLimit	单个直播间的cid数超过套餐值
    PushTooFrequency	直播间推送过频
    PushTotalOverLimit	直播间当天推送总数超限
    AppidOrGroupidErr	直播间查询传入的appid和groupid不对应

            */

    static {
        ErrorMap.put(0, "调用成功");
    }

    private String host;

    private String appKey;

    private String appid;

    private String masterSecret;

    private boolean useSSL;

    private IGtPush push;

    private int transmissionType;

    public GeTuiPuser(String host, String appKey, String appid, String masterSecret, boolean useSSL) {
        this.host = host;
        this.appKey = appKey;
        this.appid = appid;
        this.masterSecret = masterSecret;
        this.useSSL = useSSL;
        this.push = new IGtPush(host, appKey, masterSecret);
    }

    public void setTransmissionType(int transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Override
    public PushState pushToDevice(String pushToken, String payload, Map<String, Object> opts) {

        Integer _transmissionType = (Integer) opts.get("transmissionType");
        Long _expireTime = (Long) opts.get("expireTime");

        if ( _transmissionType != null ) {
            transmissionType = _transmissionType;
        }
        // default oneday
        if ( _expireTime == null ) {
            _expireTime = TimeUnit.DAYS.toDays(1);
        }

        // 透传模版
        TransmissionTemplate dataTpl = new TransmissionTemplate();
        dataTpl.setAppId(appid);
        dataTpl.setAppkey(appKey);
        dataTpl.setTransmissionType(transmissionType); // 收到消息是否立即启动应用，1为立即启动，2则广播等待客户端自启动
        dataTpl.setTransmissionContent(payload); //content长度：2048中/英字符，不支持转义字符

        SingleMessage message = new SingleMessage();
        message.setOfflineExpireTime(_expireTime);
        message.setData(dataTpl);

        // 配置推送目标
        Target target = new Target();
        target.setAppId(appid);
        target.setClientId(pushToken);

        IPushResult result = push.pushMessageToSingle(message, target);

        // return result.getResponse();

        return new PushState(true, "");

    }
}
