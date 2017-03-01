package com.mall.utils;

import org.junit.Test;

/**
 * Created by Supeng on 01/03/2017.
 */


public class AESCoderTest {

    @Test
    public void testEncrypt() {
        String source = "wx833943b167b4012a:50b8133c1d4b6f34c6eafbd220570226:5";

        String encryptString = AESCoder.encrypt(source);

        System.out.println(encryptString);

        source = AESCoder.decrypt(encryptString);

        System.out.println(source);
    }
}
