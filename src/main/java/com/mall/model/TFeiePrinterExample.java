package com.mall.model;

import java.util.ArrayList;
import java.util.List;

public class TFeiePrinterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFeiePrinterExample() {
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

        public Criteria andPrinterCodeIsNull() {
            addCriterion("printer_code is null");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeIsNotNull() {
            addCriterion("printer_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeEqualTo(String value) {
            addCriterion("printer_code =", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeNotEqualTo(String value) {
            addCriterion("printer_code <>", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeGreaterThan(String value) {
            addCriterion("printer_code >", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("printer_code >=", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeLessThan(String value) {
            addCriterion("printer_code <", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeLessThanOrEqualTo(String value) {
            addCriterion("printer_code <=", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeLike(String value) {
            addCriterion("printer_code like", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeNotLike(String value) {
            addCriterion("printer_code not like", value, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeIn(List<String> values) {
            addCriterion("printer_code in", values, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeNotIn(List<String> values) {
            addCriterion("printer_code not in", values, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeBetween(String value1, String value2) {
            addCriterion("printer_code between", value1, value2, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterCodeNotBetween(String value1, String value2) {
            addCriterion("printer_code not between", value1, value2, "printerCode");
            return (Criteria) this;
        }

        public Criteria andPrinterSnIsNull() {
            addCriterion("printer_sn is null");
            return (Criteria) this;
        }

        public Criteria andPrinterSnIsNotNull() {
            addCriterion("printer_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPrinterSnEqualTo(String value) {
            addCriterion("printer_sn =", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnNotEqualTo(String value) {
            addCriterion("printer_sn <>", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnGreaterThan(String value) {
            addCriterion("printer_sn >", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnGreaterThanOrEqualTo(String value) {
            addCriterion("printer_sn >=", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnLessThan(String value) {
            addCriterion("printer_sn <", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnLessThanOrEqualTo(String value) {
            addCriterion("printer_sn <=", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnLike(String value) {
            addCriterion("printer_sn like", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnNotLike(String value) {
            addCriterion("printer_sn not like", value, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnIn(List<String> values) {
            addCriterion("printer_sn in", values, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnNotIn(List<String> values) {
            addCriterion("printer_sn not in", values, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnBetween(String value1, String value2) {
            addCriterion("printer_sn between", value1, value2, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterSnNotBetween(String value1, String value2) {
            addCriterion("printer_sn not between", value1, value2, "printerSn");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyIsNull() {
            addCriterion("printer_key is null");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyIsNotNull() {
            addCriterion("printer_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyEqualTo(String value) {
            addCriterion("printer_key =", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyNotEqualTo(String value) {
            addCriterion("printer_key <>", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyGreaterThan(String value) {
            addCriterion("printer_key >", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyGreaterThanOrEqualTo(String value) {
            addCriterion("printer_key >=", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyLessThan(String value) {
            addCriterion("printer_key <", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyLessThanOrEqualTo(String value) {
            addCriterion("printer_key <=", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyLike(String value) {
            addCriterion("printer_key like", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyNotLike(String value) {
            addCriterion("printer_key not like", value, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyIn(List<String> values) {
            addCriterion("printer_key in", values, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyNotIn(List<String> values) {
            addCriterion("printer_key not in", values, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyBetween(String value1, String value2) {
            addCriterion("printer_key between", value1, value2, "printerKey");
            return (Criteria) this;
        }

        public Criteria andPrinterKeyNotBetween(String value1, String value2) {
            addCriterion("printer_key not between", value1, value2, "printerKey");
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

        public Criteria andSimCardCodeIsNull() {
            addCriterion("sim_card_code is null");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeIsNotNull() {
            addCriterion("sim_card_code is not null");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeEqualTo(String value) {
            addCriterion("sim_card_code =", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeNotEqualTo(String value) {
            addCriterion("sim_card_code <>", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeGreaterThan(String value) {
            addCriterion("sim_card_code >", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sim_card_code >=", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeLessThan(String value) {
            addCriterion("sim_card_code <", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeLessThanOrEqualTo(String value) {
            addCriterion("sim_card_code <=", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeLike(String value) {
            addCriterion("sim_card_code like", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeNotLike(String value) {
            addCriterion("sim_card_code not like", value, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeIn(List<String> values) {
            addCriterion("sim_card_code in", values, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeNotIn(List<String> values) {
            addCriterion("sim_card_code not in", values, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeBetween(String value1, String value2) {
            addCriterion("sim_card_code between", value1, value2, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andSimCardCodeNotBetween(String value1, String value2) {
            addCriterion("sim_card_code not between", value1, value2, "simCardCode");
            return (Criteria) this;
        }

        public Criteria andBindUserIsNull() {
            addCriterion("bind_user is null");
            return (Criteria) this;
        }

        public Criteria andBindUserIsNotNull() {
            addCriterion("bind_user is not null");
            return (Criteria) this;
        }

        public Criteria andBindUserEqualTo(String value) {
            addCriterion("bind_user =", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserNotEqualTo(String value) {
            addCriterion("bind_user <>", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserGreaterThan(String value) {
            addCriterion("bind_user >", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserGreaterThanOrEqualTo(String value) {
            addCriterion("bind_user >=", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserLessThan(String value) {
            addCriterion("bind_user <", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserLessThanOrEqualTo(String value) {
            addCriterion("bind_user <=", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserLike(String value) {
            addCriterion("bind_user like", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserNotLike(String value) {
            addCriterion("bind_user not like", value, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserIn(List<String> values) {
            addCriterion("bind_user in", values, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserNotIn(List<String> values) {
            addCriterion("bind_user not in", values, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserBetween(String value1, String value2) {
            addCriterion("bind_user between", value1, value2, "bindUser");
            return (Criteria) this;
        }

        public Criteria andBindUserNotBetween(String value1, String value2) {
            addCriterion("bind_user not between", value1, value2, "bindUser");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(Integer value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(Integer value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(Integer value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(Integer value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(Integer value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<Integer> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<Integer> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(Integer value1, Integer value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
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