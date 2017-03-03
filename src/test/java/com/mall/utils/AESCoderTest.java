package com.mall.utils;

import org.junit.Test;

/**
 * Created by Supeng on 01/03/2017.
 */


public class AESCoderTest {

    @Test
    public void testEncrypt() {
        // String appId, String sessionKey, int userId, String mchid, String openid
        String source = "wx833943b167b4012a:50b8133c1d4b6f34c6eafbd220570226:5:1444573602:oqdoZ0RhsT7oHOW4WwekA_GYKHn0";

        String encryptString = AESCoder.encrypt(source);

        System.out.println(encryptString);

        source = AESCoder.decrypt(encryptString);

        System.out.println(source);
    }
}
