package com.mall.service;

import com.mall.model.TBanner;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface BannerService {

    TBanner createBanner(TBanner banner);

    int removeBanner(Integer bannerId);

    List<TBanner> selectActivatedBanner(Integer corpId);
}
