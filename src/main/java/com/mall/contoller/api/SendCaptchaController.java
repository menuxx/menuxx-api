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

import java.util.HashMap;
import java.util.Map;

import static com.mall.utils.Util.makeError;

/**
 * Created by Supeng on 29/09/2016.
 */
@Controller
public class SendCaptchaController {

    @Autowired
    CorpUserService corpUserService;


    /**
     * 2004 发送验证码
     * @param phone
     * @param phone
     * @return
     */
    @RequestMapping(value = "/captcha/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, ?>> sendCaptcha(@PathVariable String phone) {
        // 先判断手机号是否已录入，未录入手机号不得发送短信
        TCorpUser corpUser = corpUserService.selectCorpUserByMobile(phone);

        if (corpUser == null) {
            return new ResponseEntity<>(makeError(-1, "你的手机暂未授权"), HttpStatus.FORBIDDEN);
        }

        String captcha = Util.generateCaptcha();

        SMSUtil.sendCaptcha(phone, captcha);

        HashMap<String, String> data = new HashMap<>();

        data.put("phone", phone);
        data.put("captcha", captcha);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
