package com.mall.contoller.api;

import com.mall.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Supeng on 11/01/2017.
 */
@Controller
public class CorpController extends BaseAPIController {

    @Autowired
    CorpService corpService;

    @RequestMapping(value = "corplist", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCorpList() {
        return new ResponseEntity<>(corpService.selectAllCorp(), HttpStatus.OK);
    }
}
