package com.mall.service.impl;

import com.mall.mapper.TCategoryMapper;
import com.mall.model.TCategory;
import com.mall.model.TCategoryExample;
import com.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        criteria.andCorpIdEqualTo(corpId);

        return categoryMapper.selectByExample(example);
    }
}
