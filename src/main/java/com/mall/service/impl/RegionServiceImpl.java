package com.mall.service.impl;

import com.mall.mapper.TRegionMapper;
import com.mall.model.TRegion;
import com.mall.model.TRegionExample;
import com.mall.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 17/01/2017.
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    TRegionMapper regionMapper;

    @Override
    public List<TRegion> selectRegionByParent(int parentId) {
        TRegionExample example = new TRegionExample();
        TRegionExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        return regionMapper.selectByExample(example);
    }
}
