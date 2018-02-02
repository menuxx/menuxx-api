package com.mall.model;

import java.util.ArrayList;
import java.util.List;

public class TShopBusinessTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShopBusinessTimeExample() {
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

        public Criteria andTimeStartNodeIsNull() {
            addCriterion("time_start_node is null");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeIsNotNull() {
            addCriterion("time_start_node is not null");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeEqualTo(String value) {
            addCriterion("time_start_node =", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeNotEqualTo(String value) {
            addCriterion("time_start_node <>", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeGreaterThan(String value) {
            addCriterion("time_start_node >", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeGreaterThanOrEqualTo(String value) {
            addCriterion("time_start_node >=", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeLessThan(String value) {
            addCriterion("time_start_node <", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeLessThanOrEqualTo(String value) {
            addCriterion("time_start_node <=", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeLike(String value) {
            addCriterion("time_start_node like", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeNotLike(String value) {
            addCriterion("time_start_node not like", value, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeIn(List<String> values) {
            addCriterion("time_start_node in", values, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeNotIn(List<String> values) {
            addCriterion("time_start_node not in", values, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeBetween(String value1, String value2) {
            addCriterion("time_start_node between", value1, value2, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeStartNodeNotBetween(String value1, String value2) {
            addCriterion("time_start_node not between", value1, value2, "timeStartNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeIsNull() {
            addCriterion("time_end_node is null");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeIsNotNull() {
            addCriterion("time_end_node is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeEqualTo(String value) {
            addCriterion("time_end_node =", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeNotEqualTo(String value) {
            addCriterion("time_end_node <>", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeGreaterThan(String value) {
            addCriterion("time_end_node >", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeGreaterThanOrEqualTo(String value) {
            addCriterion("time_end_node >=", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeLessThan(String value) {
            addCriterion("time_end_node <", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeLessThanOrEqualTo(String value) {
            addCriterion("time_end_node <=", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeLike(String value) {
            addCriterion("time_end_node like", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeNotLike(String value) {
            addCriterion("time_end_node not like", value, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeIn(List<String> values) {
            addCriterion("time_end_node in", values, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeNotIn(List<String> values) {
            addCriterion("time_end_node not in", values, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeBetween(String value1, String value2) {
            addCriterion("time_end_node between", value1, value2, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andTimeEndNodeNotBetween(String value1, String value2) {
            addCriterion("time_end_node not between", value1, value2, "timeEndNode");
            return (Criteria) this;
        }

        public Criteria andWeekDayIsNull() {
            addCriterion("week_day is null");
            return (Criteria) this;
        }

        public Criteria andWeekDayIsNotNull() {
            addCriterion("week_day is not null");
            return (Criteria) this;
        }

        public Criteria andWeekDayEqualTo(Integer value) {
            addCriterion("week_day =", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayNotEqualTo(Integer value) {
            addCriterion("week_day <>", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayGreaterThan(Integer value) {
            addCriterion("week_day >", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_day >=", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayLessThan(Integer value) {
            addCriterion("week_day <", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayLessThanOrEqualTo(Integer value) {
            addCriterion("week_day <=", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayIn(List<Integer> values) {
            addCriterion("week_day in", values, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayNotIn(List<Integer> values) {
            addCriterion("week_day not in", values, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayBetween(Integer value1, Integer value2) {
            addCriterion("week_day between", value1, value2, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayNotBetween(Integer value1, Integer value2) {
            addCriterion("week_day not between", value1, value2, "weekDay");
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

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(Integer value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(Integer value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(Integer value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(Integer value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(Integer value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<Integer> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<Integer> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(Integer value1, Integer value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(Integer value1, Integer value2) {
            addCriterion("online not between", value1, value2, "online");
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