package com.mall.push;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPusher implements IPusher {

    protected boolean getOptBool(Map<String, Object> opts, String key) {
        return (boolean) opts.get(key);
    }

    protected Long getOptLong(Map<String, Object> opts, String key) {
        return (Long) opts.get(key);
    }

    protected String getOptStr(Map<String, Object> opts, String key) {
        return (String) opts.get(key);
    }

    @Override
    public PushState pushToDevice(String deviceId, String payload, Map<String, Object> opts) {
        return new PushState(false, "not support");
    }

    @Override
    public Map<String, Object> getDefaultOpts(Map<String, Object> commonOpts) {
        Map<String, Object> mergeOpts = new HashMap<>();
        // 每一次都唤醒
        mergeOpts.put(PushConst.OPTS_WAKEUP_EVERY, true);
        // 消息缓存开启
        mergeOpts.put(PushConst.OPTS_MSG_EXPIRE_ENABLE, true);
        // 消息缓存时间
        mergeOpts.put(PushConst.OPTS_MSG_EXPIRE_TIME, TimeUnit.DAYS.toMillis(1));
        mergeOpts.putAll(commonOpts);
        return mergeOpts;
    }

    @Override
    public void destroy() {
        // do nothings
    }
}
