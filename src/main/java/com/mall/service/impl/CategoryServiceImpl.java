package com.mall.service.impl;

import com.mall.mapper.TCategoryMapper;
import com.mall.model.TCategory;
import com.mall.model.TCategoryExample;
import com.mall.service.CategoryService;
import com.mall.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    TCategoryMapper categoryMapper;

    @Override
    public List<TCategory> selectCategoriesByCorp(int corpId) {
        TCategoryExample example = new TCategoryExample();
        TCategoryExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("sort_id asc");
        criteria.andCorpIdEqualTo(corpId).andStatusEqualTo(Constants.STATUS_SELECT);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Map<Integer, TCategory> selectCategoriesByCorpForMap(int corpId) {
        Map<Integer, TCategory> map = new HashMap<>();

        List<TCategory> list = selectCategoriesByCorp(corpId);

        for (TCategory category : list) {
            map.put(category.getId(), category);
        }

        return map;
    }

    @Override
    public TCategory selectCategory(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }
}
