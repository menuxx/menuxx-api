package com.mall.model;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * Created by Supeng on 13/01/2017.
 */
public class ItemUnitDetail extends TItemUnitDetail {

    public static final String SEPARATOR = "-";

    private String unitProduct;

    public ItemUnitDetail() {
    }

    public ItemUnitDetail(TItemUnitDetail itemUnitDetail) {
        BeanUtils.copyProperties(itemUnitDetail, this);
    }

    public void setUnitProduct(String unitProduct) {
        this.unitProduct = unitProduct;
    }

    public String getUnitProduct() {
        unitProduct = "";

        if (getUnit1() != null) {
            unitProduct += getUnit1();
        }

        if (getUnit2() != null) {
            unitProduct += SEPARATOR;
            unitProduct += getUnit2();
        }

        if (getUnit3() != null) {
            unitProduct += SEPARATOR;
            unitProduct += getUnit3();
        }

        return unitProduct;
    }
}
