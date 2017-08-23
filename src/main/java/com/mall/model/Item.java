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

    public static final Integer OFFLINE = 1;

    public static final Integer ONLINE = 0;

    // 不要打包盒
    public static final Integer PACKAGE_FLAG_NO = 0;

    // 需要打包盒
    public static final Integer PACKAGE_FLAG_YES = 1;

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
