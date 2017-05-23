package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCorpTotalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCorpTotalExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Date value) {
            addCriterionForJDBCDate("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Date value) {
            addCriterionForJDBCDate("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Date value) {
            addCriterionForJDBCDate("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Date> values) {
            addCriterionForJDBCDate("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIsNull() {
            addCriterion("income_total is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIsNotNull() {
            addCriterion("income_total is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalEqualTo(Integer value) {
            addCriterion("income_total =", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotEqualTo(Integer value) {
            addCriterion("income_total <>", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalGreaterThan(Integer value) {
            addCriterion("income_total >", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("income_total >=", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalLessThan(Integer value) {
            addCriterion("income_total <", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalLessThanOrEqualTo(Integer value) {
            addCriterion("income_total <=", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIn(List<Integer> values) {
            addCriterion("income_total in", values, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotIn(List<Integer> values) {
            addCriterion("income_total not in", values, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalBetween(Integer value1, Integer value2) {
            addCriterion("income_total between", value1, value2, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("income_total not between", value1, value2, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalIsNull() {
            addCriterion("order_total is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalIsNotNull() {
            addCriterion("order_total is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalEqualTo(Integer value) {
            addCriterion("order_total =", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalNotEqualTo(Integer value) {
            addCriterion("order_total <>", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalGreaterThan(Integer value) {
            addCriterion("order_total >", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_total >=", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalLessThan(Integer value) {
            addCriterion("order_total <", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalLessThanOrEqualTo(Integer value) {
            addCriterion("order_total <=", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalIn(List<Integer> values) {
            addCriterion("order_total in", values, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalNotIn(List<Integer> values) {
            addCriterion("order_total not in", values, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalBetween(Integer value1, Integer value2) {
            addCriterion("order_total between", value1, value2, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("order_total not between", value1, value2, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andArerageIsNull() {
            addCriterion("arerage is null");
            return (Criteria) this;
        }

        public Criteria andArerageIsNotNull() {
            addCriterion("arerage is not null");
            return (Criteria) this;
        }

        public Criteria andArerageEqualTo(Integer value) {
            addCriterion("arerage =", value, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageNotEqualTo(Integer value) {
            addCriterion("arerage <>", value, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageGreaterThan(Integer value) {
            addCriterion("arerage >", value, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageGreaterThanOrEqualTo(Integer value) {
            addCriterion("arerage >=", value, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageLessThan(Integer value) {
            addCriterion("arerage <", value, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageLessThanOrEqualTo(Integer value) {
            addCriterion("arerage <=", value, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageIn(List<Integer> values) {
            addCriterion("arerage in", values, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageNotIn(List<Integer> values) {
            addCriterion("arerage not in", values, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageBetween(Integer value1, Integer value2) {
            addCriterion("arerage between", value1, value2, "arerage");
            return (Criteria) this;
        }

        public Criteria andArerageNotBetween(Integer value1, Integer value2) {
            addCriterion("arerage not between", value1, value2, "arerage");
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

        public Criteria andPayTotalIsNull() {
            addCriterion("pay_total is null");
            return (Criteria) this;
        }

        public Criteria andPayTotalIsNotNull() {
            addCriterion("pay_total is not null");
            return (Criteria) this;
        }

        public Criteria andPayTotalEqualTo(Integer value) {
            addCriterion("pay_total =", value, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalNotEqualTo(Integer value) {
            addCriterion("pay_total <>", value, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalGreaterThan(Integer value) {
            addCriterion("pay_total >", value, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_total >=", value, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalLessThan(Integer value) {
            addCriterion("pay_total <", value, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalLessThanOrEqualTo(Integer value) {
            addCriterion("pay_total <=", value, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalIn(List<Integer> values) {
            addCriterion("pay_total in", values, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalNotIn(List<Integer> values) {
            addCriterion("pay_total not in", values, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalBetween(Integer value1, Integer value2) {
            addCriterion("pay_total between", value1, value2, "payTotal");
            return (Criteria) this;
        }

        public Criteria andPayTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_total not between", value1, value2, "payTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalIsNull() {
            addCriterion("recharge_total is null");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalIsNotNull() {
            addCriterion("recharge_total is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalEqualTo(Integer value) {
            addCriterion("recharge_total =", value, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalNotEqualTo(Integer value) {
            addCriterion("recharge_total <>", value, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalGreaterThan(Integer value) {
            addCriterion("recharge_total >", value, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("recharge_total >=", value, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalLessThan(Integer value) {
            addCriterion("recharge_total <", value, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalLessThanOrEqualTo(Integer value) {
            addCriterion("recharge_total <=", value, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalIn(List<Integer> values) {
            addCriterion("recharge_total in", values, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalNotIn(List<Integer> values) {
            addCriterion("recharge_total not in", values, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalBetween(Integer value1, Integer value2) {
            addCriterion("recharge_total between", value1, value2, "rechargeTotal");
            return (Criteria) this;
        }

        public Criteria andRechargeTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("recharge_total not between", value1, value2, "rechargeTotal");
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