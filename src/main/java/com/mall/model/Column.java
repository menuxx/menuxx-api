package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public class Column extends TColumn {

    private List<TColumnItem> itemList;

    public Column() {
    }

    public Column(TColumn column) {
        BeanUtils.copyProperties(column, this);
    }

    public void setItemList(List<TColumnItem> itemList) {
        this.itemList = itemList;
    }

    public List<TColumnItem> getItemList() {
        return itemList;
    }
}
