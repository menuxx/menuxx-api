package com.mall.push;

import static com.google.common.base.Preconditions.checkNotNull;

public class Util {

    public static String pushDeviceKey(String appKey) {
        checkNotNull(appKey);
        return appKey + PushConst.PUSH_DEVICES_SUFFIX;
    }

    public static int randomIntVal() {
        return Long.valueOf(Math.round(System.currentTimeMillis() / 1000) + Math.round(Math.random() * 10000)).intValue();
    }

}
