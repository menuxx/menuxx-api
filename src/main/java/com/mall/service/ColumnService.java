package com.mall.service;

import com.mall.model.TColumn;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface ColumnService {

    List<TColumn> selectAllColumns(int corpId);

    TColumn createColumn(TColumn column);

    int removeColumn(int columnId);

}
