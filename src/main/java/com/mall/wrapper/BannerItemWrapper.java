package com.mall.wrapper;

import com.mall.model.TItem;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface BannerItemWrapper {

    List<TItem> selectItemsByBanner(int bannerId);
}
