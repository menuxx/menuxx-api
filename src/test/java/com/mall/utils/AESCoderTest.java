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

    @Test
    public void testDecrypt() {
        String str = "1afdbe7ec3c92b6bb63369053d5804f12b7e66697f57be4022e53b73a2ffa2824cebaea7cc45682ffeccc1ebebd77369ec3386d75c7da2bc46e4e14fe2e2e8a2";

        str = AESCoder.decrypt(str);

        System.out.println(str);
    }

    @Test
    public void testEncrypt1() {
        // String appId, String sessionKey, int userId, String mchid, String openid
        String userId = "5";
        String corpId = "1";
//        "":"":userId:corpId
        String source = "" + ":" + "" + ":" + userId + ":" + corpId;

        String encryptString = AESCoder.encrypt(source);

        System.out.println(source + "==>" + encryptString);

        source = AESCoder.decrypt(encryptString);

        System.out.println(source);
    }

}
