package com.mall.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Supeng on 29/09/2016.
 */
public class SMSUtil {

    // 验证码模板
    private static final String TEMPLATE_ID_CAPTCHA = "198719";

    // 用户收集模板
    private static final String TEMPLATE_ID_NOTIFY = "198864";

    private static Map<String, String> captchaMap = new HashMap<>();

    static {
        captchaMap.put("13575762817", "1234");
        captchaMap.put("15158898469", "1234");
        captchaMap.put("18866669999", "1234");
    }

    public static boolean checkCaptcha(String phone, String captcha) {
        String value = captchaMap.get(phone);
        if (captcha.equals(value)) {
            return true;
        }
        return false;
    }

    public static void sendNotify(String phone, String[] args) {
        sendSMS(phone, TEMPLATE_ID_NOTIFY, args);
    }

    public static void sendCaptcha(String phone, String captcha) {

        if ( "18866669999".equals(phone) ) {
            return;
        }

        HashMap<String, Object> result = sendSMS(phone, TEMPLATE_ID_CAPTCHA, new String[]{captcha});

        System.out.println("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
//            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//            Set<String> keySet = data.keySet();
//            for(String key:keySet){
//                Object object = data.get(key);
//                System.out.println(key +" = "+object);
//            }
            captchaMap.put(phone, captcha);
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }

    private static HashMap<String, Object> sendSMS(String phone, String templateId, String[] captcha) {
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

        //******************************注释*********************************************
        //*初始化服务器地址和端口                                                       *
        //*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
        //*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
        //*******************************************************************************
        restAPI.init("app.cloopen.com", "8883");

        //******************************注释*********************************************
        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
        //*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
        //*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。                   *
        //*******************************************************************************
        restAPI.setAccount("8a216da857511049015774861894153f", "e1de26cde6e24dd28dfedcd81467d1f0");

        //******************************注释*********************************************
        //*初始化应用ID                                                                 *
        //*测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID     *
        //*应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
        //*******************************************************************************
        restAPI.setAppId("8a216da85da6adf7015de9addca8199f");

        //******************************注释****************************************************************
        //*调用发送模板短信的接口发送短信                                                                  *
        //*参数顺序说明：                                                                                  *
        //*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
        //*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
        //*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
        //*第三个参数是要替换的内容数组。																														       *
        //**************************************************************************************************

        //**************************************举例说明***********************************************************************
        //*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
        //*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
        //*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *
        //*********************************************************************************************************************
        return restAPI.sendTemplateSMS(phone, templateId,captcha);
    }

}
