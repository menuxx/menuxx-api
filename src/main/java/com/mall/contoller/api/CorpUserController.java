package com.mall.contoller.api;

import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.configure.properties.AppConfigureProperties;
import com.mall.model.*;
import com.mall.push.DinerPushManager;
import com.mall.service.CorpService;
import com.mall.service.CorpUserService;
import com.mall.utils.SMSUtil;
import com.mall.wrapper.OrderWrapper;
import com.yingtaohuo.feieprinter.FeieOrderPrinter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.mall.utils.Util.makeError;
import static com.mall.utils.Util.status400;
import static com.mall.utils.Util.status401;

@Controller
public class CorpUserController {

    @Autowired
    CorpUserService corpUserService;

    @Autowired
    AppConfigureProperties appConfig;

    @Autowired
    CorpService corpService;

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    DinerPushManager dinerPushManager;

    @Autowired
    FeieOrderPrinter feieOrderPrinter;

    /**
     * 2005 手机号登录
     *
     * @return
     */
    @RequestMapping(value = "captcha/{phone}/{captcha}/{clientId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> login(@PathVariable String phone, @PathVariable String captcha, @PathVariable String clientId) {
        if (SMSUtil.checkCaptcha(phone, captcha)) {
            TCorpUser corpUser = corpUserService.selectCorpUserByMobile(phone);
            corpUser.setClientId(clientId);
            corpUserService.updateCorpUser(corpUser);
            SessionData sessionData = new SessionData("", "", corpUser.getId(), String.valueOf(corpUser.getCorpId()), corpUser.getCorpId());
            Map<String, Object> corp = corpService.selectCorpForMap(corpUser.getCorpId());
            Map<String, Object> map = new java.util.HashMap<>();
            map.put("sessionData", sessionData);
            map.put("corp", corp);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        return new ResponseEntity<>(makeError(401, "手机号和验证码不匹配"), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/diner_login/{phone}")
    @ResponseBody
    public ResponseEntity<?> login(@PathVariable String phone, @RequestBody Map<String, String> body) {
        String captcha = body.get("captcha");
        if ( captcha == null ) {
            return status400("手机动态码必填");
        }
        if (!SMSUtil.checkCaptcha(phone, captcha)) {
            return status401("手机号和验证码不匹配");
        }
        TCorpUser corpUser = corpUserService.selectCorpUserByMobile(phone);
        SessionData sessionData = new SessionData("", "", corpUser.getId(), String.valueOf(corpUser.getCorpId()), corpUser.getCorpId());
        Map<String, Object> corp = corpService.selectCorpForMap(corpUser.getCorpId());
        Map<String, Object> map = new HashMap<>();
        map.put("sessionData", sessionData);
        map.put("corp", corp);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    // 设备上线
    @PutMapping("/diner_user/device")
    @ResponseBody
    public Map<String, Object> deviceOnline(@SessionKey SessionData sessionData, @RequestBody Map<String, String> device) {
        String pushToken = device.get("push_token");
        String pushChannel = device.get("push_channel");
        if (StringUtils.isBlank(pushToken) ||  StringUtils.isBlank(pushToken)) {
            return makeError(400, "设备不正确");
        }
        int corpUserId = sessionData.getUserId();
        TCorpUser corpUser = corpUserService.selectCorpUser(corpUserId);
        dinerPushManager.putToken( corpUser.getPushKey(),  pushChannel, pushToken);
        return makeError(200, "上线成功");
    }

    /**
     * 2010 流程自检
     * @return
     */
    @RequestMapping(value = "self_check", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selfCheckProgram(@SessionKey SessionData sessionData) {
        int corpUserId = sessionData.getUserId();

        TCorpUser corpUser = corpUserService.selectCorpUser(corpUserId);

        List<String> clientIdList = new ArrayList<>();
        clientIdList.add(corpUser.getClientId());

        Order order = orderWrapper.buildTestOrder(1);

        orderWrapper.pushOrder(order, clientIdList);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /**
     * 2010 流程自检
     * @return
     */
    @PutMapping(value = "/diner_user/self_check")
    @ResponseBody
    public ResponseEntity<?> selfCheckPushDevice(@SessionKey SessionData sessionData, @RequestParam(required = false, defaultValue = "0") Integer withFeie) {
        int corpUserId = sessionData.getUserId();
        TCorpUser corpUser = corpUserService.selectCorpUser(corpUserId);
        Order order = orderWrapper.buildTestOrder(1);
        dinerPushManager.pushOrderToShopReceiver(corpUser.getPushKey(), order);
        if ( withFeie == 1 ) {
            feieOrderPrinter.printerOrderToShop(order, corpService.selectCorpByCorpId(sessionData.getCorpId()));
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
