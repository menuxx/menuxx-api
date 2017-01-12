package com.mall.service.impl;

import com.mall.mapper.TBannerItemMapper;
import com.mall.model.TBannerItem;
import com.mall.model.TBannerItemExample;
import com.mall.service.BannerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class BannerItemServiceImpl implements BannerItemService {

    @Autowired
    TBannerItemMapper bannerItemMapper;

    @Override
    public List<TBannerItem> selectBannerItems(int bannerId) {
        TBannerItemExample example = new TBannerItemExample();
        TBannerItemExample.Criteria criteria = example.createCriteria();

        criteria.andBannerIdEqualTo(bannerId);

        return bannerItemMapper.selectByExample(example);
    }

    @Override
    public int createBannerItem(int bannerId, int itemId) {
        TBannerItem bannerItem = new TBannerItem();
        bannerItem.setBannerId(bannerId);
        bannerItem.setItemId(itemId);

        return bannerItemMapper.insert(bannerItem);
    }

    @Override
    public int removeBannerItem(int bannerItemId) {
        return bannerItemMapper.deleteByPrimaryKey(bannerItemId);
    }
}
