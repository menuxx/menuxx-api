package com.mall.wrapper;

import com.mall.model.Column;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface ColumnWrapper {

    List<Column> selectAllColumns(int corpId);
}
