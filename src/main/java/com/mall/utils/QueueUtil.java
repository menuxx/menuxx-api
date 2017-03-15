package com.mall.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Supeng on 15/02/2017.
 */
public class QueueUtil {

    public static Map<Integer, Map<String, Integer>> queueMap = new HashMap<>();


    public static Integer getQueueNum(int corpId) {
        int queueNum = 1;

        Map<String, Integer> indexMap = null;

        if (queueMap.containsKey(corpId)) {
            indexMap = queueMap.get(corpId);
        } else {
            indexMap = new HashMap<>();
        }

        String dateKey = Util.getYearMonthDay();

        if (indexMap.containsKey(dateKey)) {
            queueNum = indexMap.get(dateKey) + 1;
            indexMap.put(dateKey, queueNum);
        } else {
            indexMap = new HashMap<>();
            indexMap.put(dateKey, queueNum);
        }

        queueMap.put(corpId, indexMap);

        return queueNum;
    }

}
