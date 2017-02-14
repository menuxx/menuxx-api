package com.mall.service;

import com.mall.model.TCategory;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface CategoryService {

    List<TCategory> selectCategoriesByCorp(int corpId);

}
