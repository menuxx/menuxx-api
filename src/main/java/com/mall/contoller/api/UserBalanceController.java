package com.mall.contoller.api;

import com.mall.annotation.SessionData;
import com.mall.annotation.SessionKey;
import com.mall.model.TUserBalance;
import com.mall.service.UserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Supeng on 09/05/2017.
 */
@Controller
public class UserBalanceController extends BaseCorpController {

    @Autowired
    UserBalanceService userBalanceService;

    /**
     * 2026 获取充值余额
     * @param dinerId
     * @param sessionData
     * @return
     */
    @RequestMapping(value = "balance", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserBalance(@PathVariable int dinerId, @SessionKey SessionData sessionData) {
        TUserBalance userBalance = userBalanceService.selectUserBalance(sessionData.getUserId(), dinerId);

        if (null == userBalance) {
            userBalance = new TUserBalance();
            userBalance.setBalance(0);
            userBalance.setUserId(sessionData.getUserId());
            userBalance.setCorpId(dinerId);
        }

        return new ResponseEntity<Object>(userBalance, HttpStatus.OK);
    }
}
