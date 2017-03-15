package com.mall.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Supeng on 15/03/2017.
 */
public class SMSUtilTest {

    private  static LoadingCache<String, String> captchaMap = CacheBuilder.newBuilder().concurrencyLevel(4).weakKeys().expireAfterAccess(50, TimeUnit.MILLISECONDS).build(new CacheLoader<String, String>() {
        @Override
        public String load(String key) throws Exception {
            return null;
        }
    });


    public void testCacheLoader() {


        captchaMap.put("1", "001");
        captchaMap.put("2", "002");
        captchaMap.put("3", "003");
        captchaMap.put("4", "004");
        captchaMap.put("13738142344", "2312");

        try {
            System.out.println(captchaMap.get("1"));
            System.out.println(captchaMap.get("2"));
            System.out.println(captchaMap.get("3"));
            System.out.println(captchaMap.get("4"));
            System.out.println(captchaMap.get("13738142344"));
            System.out.println(captchaMap.get("13738142344"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < 1000; i++ ) {
//            System.out.println("--start:--" + i);
//            Set set = captchaMap.asMap().entrySet();
//            Iterator it = set.iterator();
//            while (it.hasNext()) {
//                System.out.println(it.next());
//            }
//        }

    }

    @Test
    public void testSendCaptcha() {
        String phone = "17681834305";
        String captcha = "2344";

        SMSUtil.sendCaptcha(phone, captcha);

        boolean check = SMSUtil.checkCaptcha(phone, captcha);
        System.out.println(check);
    }
}
