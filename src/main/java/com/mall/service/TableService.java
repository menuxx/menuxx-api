package com.mall.service;

import com.mall.model.TTable;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface TableService {

    List<TTable> selectTablesByCorp(int corpId);

}
