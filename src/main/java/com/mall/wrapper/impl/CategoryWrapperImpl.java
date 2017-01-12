package com.mall.wrapper.impl;

import com.mall.model.Category;
import com.mall.model.TCategory;
import com.mall.service.CategoryService;
import com.mall.utils.Constants;
import com.mall.wrapper.CategoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
@Service
public class CategoryWrapperImpl implements CategoryWrapper {

    @Autowired
    CategoryService categoryService;

    @Override
    public Category buildCategory(int corpId) {
        Category root = new Category();
        root.setId(Constants.ZERO);
        root.setCategoryName("根分类");

        Map<Integer, List<Category>> categoryMap = getCategoryMap(corpId);

        bulidChildren(root, categoryMap);

        return root;
    }

    private Map<Integer, List<Category>> getCategoryMap(int corpId) {
        List<TCategory> categoryList = categoryService.selectCategoriesByCorpId(corpId);

        Map<Integer, List<Category>> categoryMap = new HashMap<Integer, List<Category>>();

        for (TCategory tCategory : categoryList) {
            Category category = new Category(tCategory);

            int parentId = tCategory.getParentId();
            if (categoryMap.containsKey(parentId)) {
                categoryMap.get(parentId).add(category);
            } else {
                List<Category> list = new ArrayList<Category>();
                list.add(category);

                categoryMap.put(parentId, list);
            }
        }

        return categoryMap;
    }

    private void bulidChildren(Category category, Map<Integer, List<Category>> categoryMap) {
        int categoryId = category.getId();

        if (categoryMap.containsKey(categoryId)) {
            List<Category> children = categoryMap.get(categoryId);
            category.setChildren(children);

            categoryMap.remove(categoryId);
        }

        List<Category> children = category.getChildren();
        if (null != children && children.size() > 0) {
            for (Category child : children) {
                bulidChildren(child, categoryMap);
            }
        }
    }
}
