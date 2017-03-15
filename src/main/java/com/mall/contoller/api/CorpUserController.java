package com.mall.contoller.api;

import com.mall.annotation.SessionData;
import com.mall.model.TCorpUser;
import com.mall.service.CorpUserService;
import com.mall.utils.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Supeng on 15/03/2017.
 */
@Controller
public class CorpUserController extends BaseCorpController {

    @Autowired
    CorpUserService corpUserService;


    /**
     * 2005 手机号登录
     *
     * @return
     */
    @RequestMapping(value = "captcha/{phone}/{captcha}/{clientId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> login(@PathVariable int dinerId, @PathVariable String phone, @PathVariable String captcha, @PathVariable String clientId) {
        if (SMSUtil.checkCaptcha(phone, captcha)) {
            TCorpUser corpUser = corpUserService.selectCorpUserByMobile(phone);
            corpUser.setClientId(clientId);
            corpUserService.updateCorpUser(corpUser);

            SessionData sessionData = new SessionData("", "", corpUser.getId(), String.valueOf(corpUser.getCorpId()));
            return new ResponseEntity<Object>(sessionData, HttpStatus.OK);
        }


        return new ResponseEntity<Object>("手机号和验证码不匹配", HttpStatus.UNAUTHORIZED);
    }

}
