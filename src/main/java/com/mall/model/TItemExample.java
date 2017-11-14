package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("corp_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(Integer value) {
            addCriterion("corp_id =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(Integer value) {
            addCriterion("corp_id <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(Integer value) {
            addCriterion("corp_id >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("corp_id >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(Integer value) {
            addCriterion("corp_id <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(Integer value) {
            addCriterion("corp_id <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<Integer> values) {
            addCriterion("corp_id in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<Integer> values) {
            addCriterion("corp_id not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(Integer value1, Integer value2) {
            addCriterion("corp_id between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("corp_id not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemDescIsNull() {
            addCriterion("item_desc is null");
            return (Criteria) this;
        }

        public Criteria andItemDescIsNotNull() {
            addCriterion("item_desc is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescEqualTo(String value) {
            addCriterion("item_desc =", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotEqualTo(String value) {
            addCriterion("item_desc <>", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescGreaterThan(String value) {
            addCriterion("item_desc >", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescGreaterThanOrEqualTo(String value) {
            addCriterion("item_desc >=", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLessThan(String value) {
            addCriterion("item_desc <", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLessThanOrEqualTo(String value) {
            addCriterion("item_desc <=", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLike(String value) {
            addCriterion("item_desc like", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotLike(String value) {
            addCriterion("item_desc not like", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescIn(List<String> values) {
            addCriterion("item_desc in", values, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotIn(List<String> values) {
            addCriterion("item_desc not in", values, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescBetween(String value1, String value2) {
            addCriterion("item_desc between", value1, value2, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotBetween(String value1, String value2) {
            addCriterion("item_desc not between", value1, value2, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(Integer value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(Integer value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(Integer value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(Integer value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(Integer value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<Integer> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<Integer> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(Integer value1, Integer value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(Integer value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(Integer value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(Integer value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(Integer value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(Integer value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<Integer> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<Integer> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(Integer value1, Integer value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceIsNull() {
            addCriterion("special_price is null");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceIsNotNull() {
            addCriterion("special_price is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceEqualTo(Integer value) {
            addCriterion("special_price =", value, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceNotEqualTo(Integer value) {
            addCriterion("special_price <>", value, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceGreaterThan(Integer value) {
            addCriterion("special_price >", value, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("special_price >=", value, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceLessThan(Integer value) {
            addCriterion("special_price <", value, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceLessThanOrEqualTo(Integer value) {
            addCriterion("special_price <=", value, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceIn(List<Integer> values) {
            addCriterion("special_price in", values, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceNotIn(List<Integer> values) {
            addCriterion("special_price not in", values, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBetween(Integer value1, Integer value2) {
            addCriterion("special_price between", value1, value2, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("special_price not between", value1, value2, "specialPrice");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNull() {
            addCriterion("weekday is null");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNotNull() {
            addCriterion("weekday is not null");
            return (Criteria) this;
        }

        public Criteria andWeekdayEqualTo(Integer value) {
            addCriterion("weekday =", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotEqualTo(Integer value) {
            addCriterion("weekday <>", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThan(Integer value) {
            addCriterion("weekday >", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekday >=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThan(Integer value) {
            addCriterion("weekday <", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThanOrEqualTo(Integer value) {
            addCriterion("weekday <=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayIn(List<Integer> values) {
            addCriterion("weekday in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotIn(List<Integer> values) {
            addCriterion("weekday not in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayBetween(Integer value1, Integer value2) {
            addCriterion("weekday between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotBetween(Integer value1, Integer value2) {
            addCriterion("weekday not between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andSoldoutIsNull() {
            addCriterion("soldout is null");
            return (Criteria) this;
        }

        public Criteria andSoldoutIsNotNull() {
            addCriterion("soldout is not null");
            return (Criteria) this;
        }

        public Criteria andSoldoutEqualTo(Integer value) {
            addCriterion("soldout =", value, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutNotEqualTo(Integer value) {
            addCriterion("soldout <>", value, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutGreaterThan(Integer value) {
            addCriterion("soldout >", value, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("soldout >=", value, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutLessThan(Integer value) {
            addCriterion("soldout <", value, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutLessThanOrEqualTo(Integer value) {
            addCriterion("soldout <=", value, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutIn(List<Integer> values) {
            addCriterion("soldout in", values, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutNotIn(List<Integer> values) {
            addCriterion("soldout not in", values, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutBetween(Integer value1, Integer value2) {
            addCriterion("soldout between", value1, value2, "soldout");
            return (Criteria) this;
        }

        public Criteria andSoldoutNotBetween(Integer value1, Integer value2) {
            addCriterion("soldout not between", value1, value2, "soldout");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNull() {
            addCriterion("sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Integer value) {
            addCriterion("sort_id =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Integer value) {
            addCriterion("sort_id <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Integer value) {
            addCriterion("sort_id >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_id >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Integer value) {
            addCriterion("sort_id <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("sort_id <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Integer> values) {
            addCriterion("sort_id in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Integer> values) {
            addCriterion("sort_id not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Integer value1, Integer value2) {
            addCriterion("sort_id between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_id not between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andFormatIdIsNull() {
            addCriterion("format_id is null");
            return (Criteria) this;
        }

        public Criteria andFormatIdIsNotNull() {
            addCriterion("format_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormatIdEqualTo(Integer value) {
            addCriterion("format_id =", value, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdNotEqualTo(Integer value) {
            addCriterion("format_id <>", value, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdGreaterThan(Integer value) {
            addCriterion("format_id >", value, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("format_id >=", value, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdLessThan(Integer value) {
            addCriterion("format_id <", value, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdLessThanOrEqualTo(Integer value) {
            addCriterion("format_id <=", value, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdIn(List<Integer> values) {
            addCriterion("format_id in", values, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdNotIn(List<Integer> values) {
            addCriterion("format_id not in", values, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdBetween(Integer value1, Integer value2) {
            addCriterion("format_id between", value1, value2, "formatId");
            return (Criteria) this;
        }

        public Criteria andFormatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("format_id not between", value1, value2, "formatId");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("bar_code in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("bar_code not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersIsNull() {
            addCriterion("suppliers is null");
            return (Criteria) this;
        }

        public Criteria andSuppliersIsNotNull() {
            addCriterion("suppliers is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliersEqualTo(String value) {
            addCriterion("suppliers =", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersNotEqualTo(String value) {
            addCriterion("suppliers <>", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersGreaterThan(String value) {
            addCriterion("suppliers >", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersGreaterThanOrEqualTo(String value) {
            addCriterion("suppliers >=", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersLessThan(String value) {
            addCriterion("suppliers <", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersLessThanOrEqualTo(String value) {
            addCriterion("suppliers <=", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersLike(String value) {
            addCriterion("suppliers like", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersNotLike(String value) {
            addCriterion("suppliers not like", value, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersIn(List<String> values) {
            addCriterion("suppliers in", values, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersNotIn(List<String> values) {
            addCriterion("suppliers not in", values, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersBetween(String value1, String value2) {
            addCriterion("suppliers between", value1, value2, "suppliers");
            return (Criteria) this;
        }

        public Criteria andSuppliersNotBetween(String value1, String value2) {
            addCriterion("suppliers not between", value1, value2, "suppliers");
            return (Criteria) this;
        }

        public Criteria andPackageFlagIsNull() {
            addCriterion("package_flag is null");
            return (Criteria) this;
        }

        public Criteria andPackageFlagIsNotNull() {
            addCriterion("package_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPackageFlagEqualTo(Integer value) {
            addCriterion("package_flag =", value, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagNotEqualTo(Integer value) {
            addCriterion("package_flag <>", value, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagGreaterThan(Integer value) {
            addCriterion("package_flag >", value, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_flag >=", value, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagLessThan(Integer value) {
            addCriterion("package_flag <", value, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagLessThanOrEqualTo(Integer value) {
            addCriterion("package_flag <=", value, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagIn(List<Integer> values) {
            addCriterion("package_flag in", values, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagNotIn(List<Integer> values) {
            addCriterion("package_flag not in", values, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagBetween(Integer value1, Integer value2) {
            addCriterion("package_flag between", value1, value2, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andPackageFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("package_flag not between", value1, value2, "packageFlag");
            return (Criteria) this;
        }

        public Criteria andThumbnailsIsNull() {
            addCriterion("thumbnails is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailsIsNotNull() {
            addCriterion("thumbnails is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailsEqualTo(String value) {
            addCriterion("thumbnails =", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsNotEqualTo(String value) {
            addCriterion("thumbnails <>", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsGreaterThan(String value) {
            addCriterion("thumbnails >", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnails >=", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsLessThan(String value) {
            addCriterion("thumbnails <", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsLessThanOrEqualTo(String value) {
            addCriterion("thumbnails <=", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsLike(String value) {
            addCriterion("thumbnails like", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsNotLike(String value) {
            addCriterion("thumbnails not like", value, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsIn(List<String> values) {
            addCriterion("thumbnails in", values, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsNotIn(List<String> values) {
            addCriterion("thumbnails not in", values, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsBetween(String value1, String value2) {
            addCriterion("thumbnails between", value1, value2, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andThumbnailsNotBetween(String value1, String value2) {
            addCriterion("thumbnails not between", value1, value2, "thumbnails");
            return (Criteria) this;
        }

        public Criteria andCoverImagesIsNull() {
            addCriterion("cover_images is null");
            return (Criteria) this;
        }

        public Criteria andCoverImagesIsNotNull() {
            addCriterion("cover_images is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImagesEqualTo(String value) {
            addCriterion("cover_images =", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesNotEqualTo(String value) {
            addCriterion("cover_images <>", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesGreaterThan(String value) {
            addCriterion("cover_images >", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesGreaterThanOrEqualTo(String value) {
            addCriterion("cover_images >=", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesLessThan(String value) {
            addCriterion("cover_images <", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesLessThanOrEqualTo(String value) {
            addCriterion("cover_images <=", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesLike(String value) {
            addCriterion("cover_images like", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesNotLike(String value) {
            addCriterion("cover_images not like", value, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesIn(List<String> values) {
            addCriterion("cover_images in", values, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesNotIn(List<String> values) {
            addCriterion("cover_images not in", values, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesBetween(String value1, String value2) {
            addCriterion("cover_images between", value1, value2, "coverImages");
            return (Criteria) this;
        }

        public Criteria andCoverImagesNotBetween(String value1, String value2) {
            addCriterion("cover_images not between", value1, value2, "coverImages");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusIsNull() {
            addCriterion("join_act_minus is null");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusIsNotNull() {
            addCriterion("join_act_minus is not null");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusEqualTo(Integer value) {
            addCriterion("join_act_minus =", value, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusNotEqualTo(Integer value) {
            addCriterion("join_act_minus <>", value, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusGreaterThan(Integer value) {
            addCriterion("join_act_minus >", value, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_act_minus >=", value, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusLessThan(Integer value) {
            addCriterion("join_act_minus <", value, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusLessThanOrEqualTo(Integer value) {
            addCriterion("join_act_minus <=", value, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusIn(List<Integer> values) {
            addCriterion("join_act_minus in", values, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusNotIn(List<Integer> values) {
            addCriterion("join_act_minus not in", values, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusBetween(Integer value1, Integer value2) {
            addCriterion("join_act_minus between", value1, value2, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andJoinActMinusNotBetween(Integer value1, Integer value2) {
            addCriterion("join_act_minus not between", value1, value2, "joinActMinus");
            return (Criteria) this;
        }

        public Criteria andOfflineIsNull() {
            addCriterion("offline is null");
            return (Criteria) this;
        }

        public Criteria andOfflineIsNotNull() {
            addCriterion("offline is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineEqualTo(Integer value) {
            addCriterion("offline =", value, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineNotEqualTo(Integer value) {
            addCriterion("offline <>", value, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineGreaterThan(Integer value) {
            addCriterion("offline >", value, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineGreaterThanOrEqualTo(Integer value) {
            addCriterion("offline >=", value, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineLessThan(Integer value) {
            addCriterion("offline <", value, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineLessThanOrEqualTo(Integer value) {
            addCriterion("offline <=", value, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineIn(List<Integer> values) {
            addCriterion("offline in", values, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineNotIn(List<Integer> values) {
            addCriterion("offline not in", values, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineBetween(Integer value1, Integer value2) {
            addCriterion("offline between", value1, value2, "offline");
            return (Criteria) this;
        }

        public Criteria andOfflineNotBetween(Integer value1, Integer value2) {
            addCriterion("offline not between", value1, value2, "offline");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}