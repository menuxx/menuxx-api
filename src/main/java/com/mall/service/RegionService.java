package com.mall.service;

import com.mall.model.TRegion;

import java.util.List;

/**
 * Created by Supeng on 17/01/2017.
 */
public interface RegionService {

    List<TRegion> selectRegionByParent(int parentId);
}
