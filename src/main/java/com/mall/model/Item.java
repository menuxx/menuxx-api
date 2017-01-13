package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
public class Item extends TItem {

    /**
     * 总库存：根据各规格库存求和
     */
    private int stock;

    private List<Unit> unitList;

    private List<ItemUnitDetail> detailList;

    public Item() {
    }

    public Item(TItem item) {
        BeanUtils.copyProperties(item, this);
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setDetailList(List<ItemUnitDetail> detailList) {
        this.detailList = detailList;
    }

    public List<ItemUnitDetail> getDetailList() {
        return detailList;
    }

    public int getStock() {
        if (detailList != null && detailList.size() > 0) {
            for (ItemUnitDetail itemUnitDetail : detailList) {
                stock += itemUnitDetail.getStock();
            }
        }

        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
