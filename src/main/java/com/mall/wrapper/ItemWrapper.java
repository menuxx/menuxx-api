package com.mall.wrapper;

import com.mall.model.Item;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemWrapper {

    Item getItemDetail(int corpId, int itemId);
}
