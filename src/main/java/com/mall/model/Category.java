package com.mall.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
public class Category extends TCategory {

    private List<Category> children;

    public Category() {

    }

    public Category(TCategory category) {
        BeanUtils.copyProperties(category, this);
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public List<Category> getChildren() {
        return children;
    }
}
