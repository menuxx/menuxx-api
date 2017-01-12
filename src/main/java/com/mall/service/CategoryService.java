package com.mall.service;

import com.mall.model.TCategory;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface CategoryService {

    List<TCategory> selectCategoriesByCorpId(int corpId);
}
