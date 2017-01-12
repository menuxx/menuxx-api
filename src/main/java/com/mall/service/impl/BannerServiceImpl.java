package com.mall.service.impl;

import com.mall.mapper.TBannerMapper;
import com.mall.model.TBanner;
import com.mall.model.TBannerExample;
import com.mall.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    TBannerMapper bannerMapper;

    @Override
    public TBanner createBanner(TBanner banner) {
        bannerMapper.insert(banner);
        return banner;
    }

    @Override
    public int removeBanner(Integer bannerId) {
        return bannerMapper.deleteByPrimaryKey(bannerId);
    }

    @Override
    public List<TBanner> selectActivatedBanner(Integer corpId) {
        TBannerExample example = new TBannerExample();
        TBannerExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("sort_id ASC");
        criteria.andCorpIdEqualTo(corpId);

        criteria.andStartTimeLessThan(new Date());
        criteria.andEndTimeGreaterThan(new Date());

        List<TBanner> list = bannerMapper.selectByExample(example);

        return list;
    }
}
