package com.mall.contoller.api;

import com.github.pagehelper.PageInfo;
import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.configure.page.Page;
import com.mall.model.TCorp;
import com.mall.model.TRechargeRecord;
import com.mall.service.CorpService;
import com.mall.service.RechargeRecordService;
import com.mall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supeng on 09/05/2017.
 */
@Controller
public class RechargeRecordController extends BaseCorpController {

    @Autowired
    RechargeRecordService rechargeRecordService;

    @Autowired
    CorpService corpService;

    /**
     *
     * @param dinerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "recharge_record", method = RequestMethod.GET)
    @ResponseBody
    @Page
    public ResponseEntity<?> getRechargeRecord(@SessionKey SessionData sessionData, @PathVariable int dinerId, @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                               @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {

        TCorp rechargeShop = corpService.resolveRechargeShop(dinerId);
        PageInfo<TRechargeRecord> pageInfo = rechargeRecordService.selectRechargeRecordByUser(sessionData.getUserId(), rechargeShop.getId());
        return new ResponseEntity<Object>(pageInfo, HttpStatus.OK);
    }

}
