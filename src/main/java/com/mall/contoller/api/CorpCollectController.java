package com.mall.contoller.api;

import com.mall.model.TCorpCollect;
import com.mall.service.CorpCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supeng on 24/03/2017.
 */
@Controller
public class CorpCollectController extends BaseCorpController {

    @Autowired
    CorpCollectService corpCollectService;

    @RequestMapping(value = "collect", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createCorpCollect(@PathVariable("dinerId") int dinerId, @RequestBody TCorpCollect corpCollect) {
        corpCollect.setFormCorpId(dinerId);

        corpCollectService.createCorpCollect(corpCollect);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
