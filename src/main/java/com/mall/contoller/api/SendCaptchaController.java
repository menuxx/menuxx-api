package com.mall.contoller.api;

import com.mall.model.TCorpUser;
import com.mall.service.CorpUserService;
import com.mall.utils.SMSUtil;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supeng on 29/09/2016.
 */
@Controller
public class SendCaptchaController {

    @Autowired
    CorpUserService corpUserService;


    /**
     * 2004 发送验证码
     * @param dinerId
     * @param phone
     * @return
     */
    @RequestMapping(value = "/captcha/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> sendCaptcha(@PathVariable String phone) {
        // 先判断手机号是否已录入，未录入手机号不得发送短信
        TCorpUser corpUser = corpUserService.selectCorpUserByMobile(phone);

        if (corpUser == null) {
            return new ResponseEntity<Object>("你的手机暂未授权", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String captcha = Util.generateCaptcha();

        SMSUtil.sendCaptcha(phone, captcha);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
