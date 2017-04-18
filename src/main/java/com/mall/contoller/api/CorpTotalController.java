package com.mall.contoller.api;

import com.github.pagehelper.PageInfo;
import com.mall.configure.page.Page;
import com.mall.model.TCorpTotal;
import com.mall.service.CorpTotalService;
import com.mall.service.StatisticsService;
import com.mall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Supeng on 31/03/2017.
 */
@Controller
public class CorpTotalController extends BaseCorpController {

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    CorpTotalService corpTotalService;

    /**
     * 2014 商户统计
     * @param dinerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "total")
    @ResponseBody
    @Page
    public ResponseEntity<?> getTotal(@PathVariable int dinerId, @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                      @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {
        PageInfo<TCorpTotal> pageInfo = corpTotalService.selectCorpTotal(dinerId);
        return new ResponseEntity<Object>(pageInfo, HttpStatus.OK);
    }

    /**
     * 2022 当日统计
     * @param dinerId
     * @return
     */
    @GetMapping(value = "total/today")
    @ResponseBody
    @Page
    public ResponseEntity<?> getTodayTotal(@PathVariable int dinerId) {
        TCorpTotal corpTotal = statisticsService.selectByToday();
        return new ResponseEntity<Object>(corpTotal, HttpStatus.OK);
    }

    @GetMapping(value = "stat")
    @ResponseBody
    public ResponseEntity<?> doStatistics() {
        statisticsService.doStatistics();
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
