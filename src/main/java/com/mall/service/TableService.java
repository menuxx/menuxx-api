package com.mall.service;

import com.mall.model.TTable;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface TableService {

    List<TTable> selectTablesByCorp(int corpId);

    Map<Integer, TTable> selectTablesByCorpForMap(int corpId);

    TTable selectTable(int tableId);

}
