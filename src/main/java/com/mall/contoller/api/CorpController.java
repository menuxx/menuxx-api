package com.mall.contoller.api;

import com.mall.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
