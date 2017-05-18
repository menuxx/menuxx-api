package com.mall.wrapper.impl;

import com.mall.model.Category;
import com.mall.model.TCategory;
import com.mall.model.TItem;
import com.mall.service.CategoryService;
import com.mall.wrapper.CategoryWrapper;
import com.mall.wrapper.ItemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 14/02/2017.
 */
@Service
public class CategoryWrapperImpl implements CategoryWrapper {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemWrapper itemWrapper;

    @Override
    public List<Category> selectCategoriesByCorp(int corpId) {
        List<TCategory> categoryList = categoryService.selectCategoriesByCorp(corpId);

        if (categoryList.size() > 0) {
            List<Category> returnList = new ArrayList<>();

            Map<Integer, List<TItem>> itemMap = itemWrapper.selectSellItemsByCorp(corpId);

            if (itemMap.containsKey(0)) {
                Category todayCategory = new Category();
                todayCategory.setId(0);
                todayCategory.setCategoryName("今日特价");
                todayCategory.setItemList(itemMap.get(0));
                todayCategory.setSortId(1);
                returnList.add(todayCategory);
            }

            for (TCategory tcategory : categoryList) {
                Category category = new Category(tcategory);

                List<TItem> itemList = itemMap.get(category.getId());
                category.setItemList(itemList);

                returnList.add(category);
            }

            return returnList;
        }

        return null;
    }
}
