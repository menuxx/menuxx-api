package com.mall.model;

import java.util.ArrayList;
import java.util.List;

public class TCouponConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCouponConfigExample() {
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

        public Criteria andToupIsNull() {
            addCriterion("toup is null");
            return (Criteria) this;
        }

        public Criteria andToupIsNotNull() {
            addCriterion("toup is not null");
            return (Criteria) this;
        }

        public Criteria andToupEqualTo(Integer value) {
            addCriterion("toup =", value, "toup");
            return (Criteria) this;
        }

        public Criteria andToupNotEqualTo(Integer value) {
            addCriterion("toup <>", value, "toup");
            return (Criteria) this;
        }

        public Criteria andToupGreaterThan(Integer value) {
            addCriterion("toup >", value, "toup");
            return (Criteria) this;
        }

        public Criteria andToupGreaterThanOrEqualTo(Integer value) {
            addCriterion("toup >=", value, "toup");
            return (Criteria) this;
        }

        public Criteria andToupLessThan(Integer value) {
            addCriterion("toup <", value, "toup");
            return (Criteria) this;
        }

        public Criteria andToupLessThanOrEqualTo(Integer value) {
            addCriterion("toup <=", value, "toup");
            return (Criteria) this;
        }

        public Criteria andToupIn(List<Integer> values) {
            addCriterion("toup in", values, "toup");
            return (Criteria) this;
        }

        public Criteria andToupNotIn(List<Integer> values) {
            addCriterion("toup not in", values, "toup");
            return (Criteria) this;
        }

        public Criteria andToupBetween(Integer value1, Integer value2) {
            addCriterion("toup between", value1, value2, "toup");
            return (Criteria) this;
        }

        public Criteria andToupNotBetween(Integer value1, Integer value2) {
            addCriterion("toup not between", value1, value2, "toup");
            return (Criteria) this;
        }

        public Criteria andCutbackIsNull() {
            addCriterion("cutback is null");
            return (Criteria) this;
        }

        public Criteria andCutbackIsNotNull() {
            addCriterion("cutback is not null");
            return (Criteria) this;
        }

        public Criteria andCutbackEqualTo(Integer value) {
            addCriterion("cutback =", value, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackNotEqualTo(Integer value) {
            addCriterion("cutback <>", value, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackGreaterThan(Integer value) {
            addCriterion("cutback >", value, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackGreaterThanOrEqualTo(Integer value) {
            addCriterion("cutback >=", value, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackLessThan(Integer value) {
            addCriterion("cutback <", value, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackLessThanOrEqualTo(Integer value) {
            addCriterion("cutback <=", value, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackIn(List<Integer> values) {
            addCriterion("cutback in", values, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackNotIn(List<Integer> values) {
            addCriterion("cutback not in", values, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackBetween(Integer value1, Integer value2) {
            addCriterion("cutback between", value1, value2, "cutback");
            return (Criteria) this;
        }

        public Criteria andCutbackNotBetween(Integer value1, Integer value2) {
            addCriterion("cutback not between", value1, value2, "cutback");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Float value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Float value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Float value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Float value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Float value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Float> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Float> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Float value1, Float value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Float value1, Float value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andPermanentIsNull() {
            addCriterion("permanent is null");
            return (Criteria) this;
        }

        public Criteria andPermanentIsNotNull() {
            addCriterion("permanent is not null");
            return (Criteria) this;
        }

        public Criteria andPermanentEqualTo(Integer value) {
            addCriterion("permanent =", value, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentNotEqualTo(Integer value) {
            addCriterion("permanent <>", value, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentGreaterThan(Integer value) {
            addCriterion("permanent >", value, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentGreaterThanOrEqualTo(Integer value) {
            addCriterion("permanent >=", value, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentLessThan(Integer value) {
            addCriterion("permanent <", value, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentLessThanOrEqualTo(Integer value) {
            addCriterion("permanent <=", value, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentIn(List<Integer> values) {
            addCriterion("permanent in", values, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentNotIn(List<Integer> values) {
            addCriterion("permanent not in", values, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentBetween(Integer value1, Integer value2) {
            addCriterion("permanent between", value1, value2, "permanent");
            return (Criteria) this;
        }

        public Criteria andPermanentNotBetween(Integer value1, Integer value2) {
            addCriterion("permanent not between", value1, value2, "permanent");
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

        public Criteria andDescTextIsNull() {
            addCriterion("desc_text is null");
            return (Criteria) this;
        }

        public Criteria andDescTextIsNotNull() {
            addCriterion("desc_text is not null");
            return (Criteria) this;
        }

        public Criteria andDescTextEqualTo(String value) {
            addCriterion("desc_text =", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextNotEqualTo(String value) {
            addCriterion("desc_text <>", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextGreaterThan(String value) {
            addCriterion("desc_text >", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextGreaterThanOrEqualTo(String value) {
            addCriterion("desc_text >=", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextLessThan(String value) {
            addCriterion("desc_text <", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextLessThanOrEqualTo(String value) {
            addCriterion("desc_text <=", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextLike(String value) {
            addCriterion("desc_text like", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextNotLike(String value) {
            addCriterion("desc_text not like", value, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextIn(List<String> values) {
            addCriterion("desc_text in", values, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextNotIn(List<String> values) {
            addCriterion("desc_text not in", values, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextBetween(String value1, String value2) {
            addCriterion("desc_text between", value1, value2, "descText");
            return (Criteria) this;
        }

        public Criteria andDescTextNotBetween(String value1, String value2) {
            addCriterion("desc_text not between", value1, value2, "descText");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andExpirationDayIsNull() {
            addCriterion("expiration_day is null");
            return (Criteria) this;
        }

        public Criteria andExpirationDayIsNotNull() {
            addCriterion("expiration_day is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationDayEqualTo(Integer value) {
            addCriterion("expiration_day =", value, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayNotEqualTo(Integer value) {
            addCriterion("expiration_day <>", value, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayGreaterThan(Integer value) {
            addCriterion("expiration_day >", value, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("expiration_day >=", value, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayLessThan(Integer value) {
            addCriterion("expiration_day <", value, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayLessThanOrEqualTo(Integer value) {
            addCriterion("expiration_day <=", value, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayIn(List<Integer> values) {
            addCriterion("expiration_day in", values, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayNotIn(List<Integer> values) {
            addCriterion("expiration_day not in", values, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayBetween(Integer value1, Integer value2) {
            addCriterion("expiration_day between", value1, value2, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andExpirationDayNotBetween(Integer value1, Integer value2) {
            addCriterion("expiration_day not between", value1, value2, "expirationDay");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
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