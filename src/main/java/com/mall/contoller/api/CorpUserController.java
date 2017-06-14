package com.mall.contoller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.configure.AppConfiguration;
import com.mall.model.*;
import com.mall.service.CorpService;
import com.mall.service.CorpUserService;
import com.mall.utils.IPushUtil;
import com.mall.utils.SMSUtil;
import com.mall.wrapper.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static com.mall.utils.Util.makeError;

/**
 * Created by Supeng on 15/03/2017.
 */
@Controller
public class CorpUserController {

    @Autowired
    CorpUserService corpUserService;

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    CorpService corpService;

    @Autowired
    OrderWrapper orderWrapper;

    @Autowired
    ObjectMapper objectMapper;

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

        Order order = orderWrapper.buildTestOrder();

        orderWrapper.pushOrder(order, clientIdList);

        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }


}
