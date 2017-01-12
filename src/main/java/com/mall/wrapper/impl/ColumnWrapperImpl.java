package com.mall.wrapper.impl;

import com.mall.model.Column;
import com.mall.model.TColumn;
import com.mall.model.TColumnItem;
import com.mall.service.ColumnItemService;
import com.mall.service.ColumnService;
import com.mall.wrapper.ColumnWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class ColumnWrapperImpl implements ColumnWrapper {

    @Autowired
    ColumnService columnService;

    @Autowired
    ColumnItemService columnItemService;

    @Override
    public List<Column> selectAllColumns(int corpId) {
        List<TColumn> tColumnList = columnService.selectAllColumns(corpId);

        if (tColumnList.size() > 0) {
            List<Integer> columnIdList = new ArrayList<>();

            for (TColumn column : tColumnList) {
                columnIdList.add(column.getId());
            }

            Map<Integer, List<TColumnItem>> groupMap = columnItemService.selectColumnsByGroup(columnIdList);

            List<Column> columnList = new ArrayList<>();

            for (TColumn tcolumn : tColumnList) {
                Column column = new Column(tcolumn);
                List<TColumnItem> columnItemList = groupMap.get(column.getId());

                if (null != columnItemList) {
                    column.setItemList(columnItemList);
                }


                columnList.add(column);
            }

            return columnList;
        }

        return null;
    }
}
