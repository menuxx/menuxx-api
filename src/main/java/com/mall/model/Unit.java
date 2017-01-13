package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 13/01/2017.
 */
public class Unit extends TUnit {

    private List<TUnitField> fieldList;

    public Unit() {
    }

    public Unit(TUnit unit) {
        BeanUtils.copyProperties(unit, this);
    }

    public void setFieldList(List<TUnitField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<TUnitField> getFieldList() {
        return fieldList;
    }
}
