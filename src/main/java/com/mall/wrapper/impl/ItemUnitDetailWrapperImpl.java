package com.mall.wrapper.impl;

import com.mall.model.ItemUnitDetail;
import com.mall.model.TItemUnitDetail;
import com.mall.service.ItemUnitDetailService;
import com.mall.wrapper.ItemUnitDetailWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
@Service
public class ItemUnitDetailWrapperImpl implements ItemUnitDetailWrapper {

    @Autowired
    ItemUnitDetailService itemUnitDetailService;

    @Override
    public List<ItemUnitDetail> selectItemUnitDetailByItem(int itemId) {
        List<TItemUnitDetail> tempList = itemUnitDetailService.selectUnitDetailByItem(itemId);

        if (null != tempList) {
            List<ItemUnitDetail> detailList = new ArrayList<>();

            for (TItemUnitDetail tempDetail : tempList) {
                ItemUnitDetail itemUnitDetail = new ItemUnitDetail(tempDetail);
                detailList.add(itemUnitDetail);
            }

            return detailList;
        }

        return null;
    }
}
