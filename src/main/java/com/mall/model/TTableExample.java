package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTableExample() {
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

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
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

        public Criteria andWxQrcodeUrlIsNull() {
            addCriterion("wx_qrcode_url is null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlIsNotNull() {
            addCriterion("wx_qrcode_url is not null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlEqualTo(String value) {
            addCriterion("wx_qrcode_url =", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlNotEqualTo(String value) {
            addCriterion("wx_qrcode_url <>", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlGreaterThan(String value) {
            addCriterion("wx_qrcode_url >", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wx_qrcode_url >=", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlLessThan(String value) {
            addCriterion("wx_qrcode_url <", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlLessThanOrEqualTo(String value) {
            addCriterion("wx_qrcode_url <=", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlLike(String value) {
            addCriterion("wx_qrcode_url like", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlNotLike(String value) {
            addCriterion("wx_qrcode_url not like", value, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlIn(List<String> values) {
            addCriterion("wx_qrcode_url in", values, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlNotIn(List<String> values) {
            addCriterion("wx_qrcode_url not in", values, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlBetween(String value1, String value2) {
            addCriterion("wx_qrcode_url between", value1, value2, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeUrlNotBetween(String value1, String value2) {
            addCriterion("wx_qrcode_url not between", value1, value2, "wxQrcodeUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataIsNull() {
            addCriterion("wx_qrcode_data is null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataIsNotNull() {
            addCriterion("wx_qrcode_data is not null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataEqualTo(String value) {
            addCriterion("wx_qrcode_data =", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataNotEqualTo(String value) {
            addCriterion("wx_qrcode_data <>", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataGreaterThan(String value) {
            addCriterion("wx_qrcode_data >", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataGreaterThanOrEqualTo(String value) {
            addCriterion("wx_qrcode_data >=", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataLessThan(String value) {
            addCriterion("wx_qrcode_data <", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataLessThanOrEqualTo(String value) {
            addCriterion("wx_qrcode_data <=", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataLike(String value) {
            addCriterion("wx_qrcode_data like", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataNotLike(String value) {
            addCriterion("wx_qrcode_data not like", value, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataIn(List<String> values) {
            addCriterion("wx_qrcode_data in", values, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataNotIn(List<String> values) {
            addCriterion("wx_qrcode_data not in", values, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataBetween(String value1, String value2) {
            addCriterion("wx_qrcode_data between", value1, value2, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeDataNotBetween(String value1, String value2) {
            addCriterion("wx_qrcode_data not between", value1, value2, "wxQrcodeData");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathIsNull() {
            addCriterion("wx_qrcode_path is null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathIsNotNull() {
            addCriterion("wx_qrcode_path is not null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathEqualTo(String value) {
            addCriterion("wx_qrcode_path =", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathNotEqualTo(String value) {
            addCriterion("wx_qrcode_path <>", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathGreaterThan(String value) {
            addCriterion("wx_qrcode_path >", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathGreaterThanOrEqualTo(String value) {
            addCriterion("wx_qrcode_path >=", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathLessThan(String value) {
            addCriterion("wx_qrcode_path <", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathLessThanOrEqualTo(String value) {
            addCriterion("wx_qrcode_path <=", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathLike(String value) {
            addCriterion("wx_qrcode_path like", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathNotLike(String value) {
            addCriterion("wx_qrcode_path not like", value, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathIn(List<String> values) {
            addCriterion("wx_qrcode_path in", values, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathNotIn(List<String> values) {
            addCriterion("wx_qrcode_path not in", values, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathBetween(String value1, String value2) {
            addCriterion("wx_qrcode_path between", value1, value2, "wxQrcodePath");
            return (Criteria) this;
        }

        public Criteria andWxQrcodePathNotBetween(String value1, String value2) {
            addCriterion("wx_qrcode_path not between", value1, value2, "wxQrcodePath");
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