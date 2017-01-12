package com.mall.service;

import com.mall.model.TBannerItem;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface BannerItemService {

    List<TBannerItem> selectBannerItems(int bannerId);

    int createBannerItem(int bannerId, int itemId);

    int removeBannerItem(int bannerItemId);
}
