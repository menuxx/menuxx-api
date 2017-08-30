package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TActivityNewUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TActivityNewUserExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
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