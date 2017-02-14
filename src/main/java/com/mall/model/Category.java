package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public class Category extends TCategory {

    private List<TItem> itemList;

    public Category() {

    }

    public Category(TCategory category) {
        BeanUtils.copyProperties(category, this);
    }

    public List<TItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TItem> itemList) {
        this.itemList = itemList;
    }
}
