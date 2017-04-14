package com.mall.model;

import org.springframework.beans.BeanUtils;

/**
 * Created by Supeng on 21/02/2017.
 */
public class Item extends TItem {

    // 已卖光
    public static final Integer SOLDOUT = 1;

    // 销售中
    public static final Integer SELLING = 0;

    private TCategory category;

    public Item() {
    }

    public Item(TItem item) {
        BeanUtils.copyProperties(item, this);
    }

    public TCategory getCategory() {
        return category;
    }

    public void setCategory(TCategory category) {
        this.category = category;
    }
}
