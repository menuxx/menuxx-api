package com.mall.push;

import static com.google.common.base.Preconditions.checkNotNull;

public class Util {

    public static String pushDeviceKey(String appKey) {
        checkNotNull(appKey);
        return appKey + Consts.PUSH_DEVICES_SUFFIX;
    }

}
