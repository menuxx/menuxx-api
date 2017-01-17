package com.mall.model;

import com.mall.utils.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
public class Item extends TItem {

    /**
     * 总库存：根据各规格库存求和
     */
    private int stock;

    private Map<String, ItemUnitDetail> detailMap;

    private String[] thumbList;

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

    public String[] getThumbList() {
        if (StringUtils.isNotBlank(getThumbnails())) {
            thumbList = getThumbnails().split(Constants.SEPARATOR);
        }
        return thumbList;
    }

    public void setThumbList(String[] thumbList) {
        this.thumbList = thumbList;
    }

    public void setDetailMap(Map<String, ItemUnitDetail> detailMap) {
        this.detailMap = detailMap;
    }

    public Map<String, ItemUnitDetail> getDetailMap() {
        if (getDetailList() != null && getDetailList().size() > 0) {
            detailMap = new HashMap<>();

            for (ItemUnitDetail itemUnitDetail : getDetailList()) {
                detailMap.put(itemUnitDetail.getUnitProduct(), itemUnitDetail);
            }
        }

        return detailMap;
    }
}
