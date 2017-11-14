package com.mall.service.impl;

import com.mall.mapper.StatisticsMapper;
import com.mall.model.Order;
import com.mall.model.TCorp;
import com.mall.model.TCorpTotal;
import com.mall.service.CorpService;
import com.mall.service.CorpTotalService;
import com.mall.service.StatisticsService;
import com.mall.utils.Constants;
import com.mall.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Supeng on 31/03/2017.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;

    @Autowired
    CorpTotalService corpTotalService;

    @Autowired
    CorpService corpService;

    @Override
    public List<TCorpTotal> countTotalByDay(Map<String, String> dayMap) {
        return statisticsMapper.countTotalByDay(dayMap);
    }

    @Override
    public List<TCorpTotal> countRechargeByDay(Map<String, String> dayMap) {
        return statisticsMapper.countRechargeByDay(dayMap);
    }

    @Override
    public TCorpTotal selectByToday(int corpId) {
        Map<String, String> map = getTodayMap();
        map.put("corpId", String.valueOf(corpId));

        List<TCorpTotal> list = countTotalByDay(map);

        TCorpTotal corpTotal = Util.onlyOne(list);

        if (null != corpTotal) {
            corpTotal.setArerage(corpTotal.getIncomeTotal() / corpTotal.getOrderTotal());
        } else {
            corpTotal = new TCorpTotal();
            corpTotal.setArerage(0);
            corpTotal.setOrderTotal(0);
            corpTotal.setCorpId(corpId);
            corpTotal.setIncomeTotal(0);
        }

        return corpTotal;
    }

    private Map<String, String> getTodayMap() {
        Map<String, String> dayMap = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        String fromDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        String toDay = dateFormat.format(calendar.getTime());

        dayMap.put("toDay", toDay);
        dayMap.put("fromDay", fromDay);
        return dayMap;
    }

    @Override
    public void doStatistics(String statDay) {
        String toDay = Util.addOneDay(statDay);
        calculation(statDay, toDay);
    }

    @Override
    public void doStatistics() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        String toDay = dateFormat.format(calendar.getTime());

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        String fromDay = dateFormat.format(calendar.getTime());

        calculation(fromDay, toDay);
    }

    private void calculation(String fromDay, String toDay) {
        Map<String, String> dayMap = new HashMap<>();
        dayMap.put("toDay", toDay);
        dayMap.put("fromDay", fromDay);

        // 获取所有的商家
        List<TCorp> corpList = corpService.selectAllCorps();

        // 获取营业额统计
        Map<Integer, TCorpTotal> incomeMap = selectIncomeTotal(dayMap);

        // 获取充值卡支付金额
        Map<Integer, Integer> rechargeTotalMap = selectRechagePayTotal(dayMap);

        // 获取卡券支付金额
        // Map<Integer, Integer> couponTotalMap = selectCounponPayTotal(dayMap);

        // 获取微信支付金额
        Map<Integer, Integer> wxTotalMap = selectWXPayTotal(dayMap);

        // 获取充值金额
        Map<Integer, Integer> rechargeMap = selectRechargeTotal(dayMap);

        for (TCorp corp : corpList) {
            int corpId = corp.getId();

            TCorpTotal corpTotal = corpTotalService.selectCorpTotal(corpId, fromDay);

            if (null == corpTotal) {
                corpTotal = new TCorpTotal();
                corpTotal.setCorpId(corpId);
                corpTotal.setDay(Util.parseDate(fromDay));

                // 营业额
                int incomeTotal = incomeMap.containsKey(corpId) ? incomeMap.get(corpId).getIncomeTotal() : 0;
                corpTotal.setIncomeTotal(incomeTotal);

                // 订单数量
                int orderTotal = incomeMap.containsKey(corpId) ? incomeMap.get(corpId).getOrderTotal() : 0;
                corpTotal.setOrderTotal(orderTotal);

                // 客单价
                int arerage = incomeMap.containsKey(corpId) ? incomeTotal/orderTotal : 0;
                corpTotal.setArerage(arerage);

                // 微信支付
                int wxPayTotal = wxTotalMap.containsKey(corpId) ? wxTotalMap.get(corpId) : 0;
                corpTotal.setWxTotalAmount(wxPayTotal);

                // 充值卡支付
                int rechargePayTotal = rechargeTotalMap.containsKey(corpId) ? rechargeTotalMap.get(corpId) : 0;
                corpTotal.setRechargeTotalAmount(rechargePayTotal);

                // 卡券支付
                // int couponPayTotal = couponTotalMap.containsKey(corpId) ? couponTotalMap.get(corpId) : 0;
                // corpTotal.setCouponTotalAmount(couponPayTotal);

                // 充值卡总收入
                int rechargeTotal = rechargeMap.containsKey(corpId) ? rechargeMap.get(corpId) : 0;
                corpTotal.setRechargeTotal(rechargeTotal);

                corpTotal.setStatus(Constants.ZERO);

                corpTotalService.createCorpTotal(corpTotal);
            }
        }
    }

    private Map<Integer, TCorpTotal> selectIncomeTotal(Map<String, String> dayMap) {
        List<TCorpTotal> totalList = countTotalByDay(dayMap);

        Map<Integer, TCorpTotal> map = new HashMap<>();

        if (totalList.size() > 0) {
            for (TCorpTotal total : totalList) {
                map.put(total.getCorpId(), total);
            }
        }

        return map;
    }

    private Map<Integer, Integer> selectCounponPayTotal(Map<String, String> dayMap) {
        dayMap.put("payType", String.valueOf(Order.PAY_TYPE_COUPON));

        List<TCorpTotal> totalList = countTotalByDay(dayMap);

        Map<Integer, Integer> map = new HashMap<>();

        if (totalList.size() > 0) {
            for(TCorpTotal total : totalList) {
                map.put(total.getCorpId(), total.getIncomeTotal());
            }
        }

        return map;
    }

    private Map<Integer, Integer> selectRechagePayTotal(Map<String, String> dayMap) {
        dayMap.put("payType", String.valueOf(Order.PAY_TYPE_RECHARGE));

        List<TCorpTotal> totalList = countTotalByDay(dayMap);

        Map<Integer, Integer> map = new HashMap<>();

        if (totalList.size() > 0) {
            for(TCorpTotal total : totalList) {
                map.put(total.getCorpId(), total.getIncomeTotal());
            }
        }

        return map;
    }

    private Map<Integer, Integer> selectWXPayTotal(Map<String, String> dayMap) {
        dayMap.put("payType", String.valueOf(Order.PAY_TYPE_WX));

        List<TCorpTotal> totalList = countTotalByDay(dayMap);

        Map<Integer, Integer> map = new HashMap<>();

        if (totalList.size() > 0) {
            for(TCorpTotal total : totalList) {
                map.put(total.getCorpId(), total.getIncomeTotal());
            }
        }

        return map;
    }

    private Map<Integer, Integer> selectRechargeTotal(Map<String, String> dayMap) {
        List<TCorpTotal> totalList = countRechargeByDay(dayMap);

        Map<Integer, Integer> map = new HashMap<>();

        if (totalList.size() > 0) {
            for(TCorpTotal total : totalList) {
                map.put(total.getCorpId(), total.getIncomeTotal());
            }
        }

        return map;
    }
}
