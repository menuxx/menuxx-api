package com.mall.contoller.api;

import com.mall.model.TCorpDiscover;
import com.mall.service.CorpDiscoverService;
import com.mall.utils.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supeng on 24/03/2017.
 */
@Service
public class CorpDiscoverController extends BaseCorpController {

    @Autowired
    CorpDiscoverService corpDiscoverService;

    @RequestMapping(value = "discover", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createCorpDiscover(@PathVariable("dinerId") int dinerId, @RequestBody TCorpDiscover corpDiscover) {
        corpDiscover.setFormCorpId(dinerId);

        corpDiscoverService.createCorpDiscover(corpDiscover);

        SMSUtil.sendNotify("15558132823", new String[] {corpDiscover.getPhone(), corpDiscover.getLinkman(), corpDiscover.getCorpName()});

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
