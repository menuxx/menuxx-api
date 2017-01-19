package com.mall.model;

import org.springframework.beans.BeanUtils;

/**
 * Created by Supeng on 19/01/2017.
 */
public class ItemUnit extends TItemUnit {

    private String unitName;

    private String fieldName;

    public ItemUnit() {
    }

    public ItemUnit(TItemUnit itemUnit) {
        BeanUtils.copyProperties(itemUnit, this);
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
