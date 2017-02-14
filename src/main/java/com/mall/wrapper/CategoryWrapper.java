package com.mall.wrapper;

import com.mall.model.Category;

import java.util.List;

/**
 * Created by Supeng on 14/02/2017.
 */
public interface CategoryWrapper {

    List<Category> selectCategoriesByCorp(int corpId);

}
