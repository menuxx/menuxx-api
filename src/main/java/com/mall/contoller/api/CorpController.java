package com.mall.contoller.api;

import com.mall.model.TCorp;
import com.mall.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 30/03/2017.
 */
@Controller
public class CorpController {

    @Autowired
    CorpService corpService;

    /**
     * 2014 获取商家信息
     * @param dinerId
     * @return
     */
    @RequestMapping(value = "diners/{dinerId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectCorp(@PathVariable int dinerId) {
        Map<String, Object> corpMap = corpService.selectCorpForMap(dinerId);
        return new ResponseEntity<Object>(corpMap, HttpStatus.OK);
    }

    @RequestMapping(value = "authorizers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCorpBy(@RequestParam(name = "appid", required = false) String appid, @RequestParam(name = "appkey", required = false) String appkey) {
        Map<String, Object> corpMap;
        if ( appid != null && !appid.isEmpty() ) {
            corpMap = corpService.getByAppid(appid);
        }
        else if ( appkey != null && !appkey.isEmpty() ) {
            corpMap = corpService.getByAppkey(appkey);
        } else {
            return new ResponseEntity<Object>(corpService.getAuthorizerDiners(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(corpMap, HttpStatus.OK);
    }

    @RequestMapping(value = "authorizers", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> getCorpBy(@RequestBody TCorp corp, @RequestParam(name = "appid", required = false) String appid, @RequestParam(name = "appkey", required = false) String appkey) {
        if ( appid != null && !appid.isEmpty() ) {
            corpService.updateByAppid(appid, corp);
        }
        else if ( appkey != null && !appkey.isEmpty() ) {
            corpService.updateByAppkey(appkey, corp);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 3001 获取入驻商家
     * @return
     */
    @RequestMapping(value = "entered_diners", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectEnterCorp() {
        List<?> list = corpService.selectEnterCorp();
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    /**
     * 3002 获取入驻商家
     * @return
     */
    @RequestMapping(value = "diners/{dinerId}/entered_diners", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectEnterCorp(@PathVariable int dinerId) {
        List<?> list = corpService.selectEnterCorp(dinerId);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

}
