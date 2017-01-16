package com.mall.wrapper.impl;

import com.mall.model.Item;
import com.mall.model.TBannerItem;
import com.mall.model.TItem;
import com.mall.service.ItemService;
import com.mall.service.BannerItemService;
import com.mall.wrapper.BannerItemWrapper;
import com.mall.wrapper.ItemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class BannerItemWrapperImpl implements BannerItemWrapper {

    @Autowired
    BannerItemService bannerItemService;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemWrapper itemWrapper;

    @Override
    public List<Item> selectItemsByBanner(int bannerId) {
        List<TBannerItem> tBannerItemList = bannerItemService.selectBannerItems(bannerId);

        if (tBannerItemList.size() > 0) {
            List<Integer> itemIdList = new ArrayList<>();

            for (TBannerItem bannerItem : tBannerItemList) {
                itemIdList.add(bannerItem.getItemId());
            }

            return itemWrapper.selectItems(itemIdList);
        }

        return null;
    }
}
