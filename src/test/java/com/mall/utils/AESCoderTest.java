package com.mall.utils;

import org.junit.Test;

/**
 * Created by Supeng on 01/03/2017.
 */


public class AESCoderTest {

    @Test
    public void testEncrypt() {
        // String appId, String sessionKey, int userId, String mchid, String openid
        String source = "5d7e5dd6f883e66684a0acc8e94f469b92194f1bfaeff995a35fe7b4c6052ac11659b6e224450010c254b1735a7376be85916730c08ce46ab38b8dbcf8f4bf44";

        String encryptString = AESCoder.encrypt(source);

        System.out.println(encryptString);

        source = AESCoder.decrypt(encryptString);

        System.out.println(source);
    }
}
