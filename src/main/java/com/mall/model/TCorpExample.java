package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCorpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCorpExample() {
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

        public Criteria andCorpNameIsNull() {
            addCriterion("corp_name is null");
            return (Criteria) this;
        }

        public Criteria andCorpNameIsNotNull() {
            addCriterion("corp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCorpNameEqualTo(String value) {
            addCriterion("corp_name =", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotEqualTo(String value) {
            addCriterion("corp_name <>", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThan(String value) {
            addCriterion("corp_name >", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("corp_name >=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThan(String value) {
            addCriterion("corp_name <", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThanOrEqualTo(String value) {
            addCriterion("corp_name <=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLike(String value) {
            addCriterion("corp_name like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotLike(String value) {
            addCriterion("corp_name not like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameIn(List<String> values) {
            addCriterion("corp_name in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotIn(List<String> values) {
            addCriterion("corp_name not in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameBetween(String value1, String value2) {
            addCriterion("corp_name between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotBetween(String value1, String value2) {
            addCriterion("corp_name not between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("app_key is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("app_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("app_key =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("app_key <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("app_key >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_key >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("app_key <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("app_key <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("app_key like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("app_key not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("app_key in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("app_key not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("app_key between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("app_key not between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidIsNull() {
            addCriterion("authorizer_appid is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidIsNotNull() {
            addCriterion("authorizer_appid is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidEqualTo(String value) {
            addCriterion("authorizer_appid =", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotEqualTo(String value) {
            addCriterion("authorizer_appid <>", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidGreaterThan(String value) {
            addCriterion("authorizer_appid >", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidGreaterThanOrEqualTo(String value) {
            addCriterion("authorizer_appid >=", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidLessThan(String value) {
            addCriterion("authorizer_appid <", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidLessThanOrEqualTo(String value) {
            addCriterion("authorizer_appid <=", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidLike(String value) {
            addCriterion("authorizer_appid like", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotLike(String value) {
            addCriterion("authorizer_appid not like", value, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidIn(List<String> values) {
            addCriterion("authorizer_appid in", values, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotIn(List<String> values) {
            addCriterion("authorizer_appid not in", values, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidBetween(String value1, String value2) {
            addCriterion("authorizer_appid between", value1, value2, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andAuthorizerAppidNotBetween(String value1, String value2) {
            addCriterion("authorizer_appid not between", value1, value2, "authorizerAppid");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeIsNull() {
            addCriterion("wxlite_template_type is null");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeIsNotNull() {
            addCriterion("wxlite_template_type is not null");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeEqualTo(Integer value) {
            addCriterion("wxlite_template_type =", value, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeNotEqualTo(Integer value) {
            addCriterion("wxlite_template_type <>", value, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeGreaterThan(Integer value) {
            addCriterion("wxlite_template_type >", value, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wxlite_template_type >=", value, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeLessThan(Integer value) {
            addCriterion("wxlite_template_type <", value, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("wxlite_template_type <=", value, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeIn(List<Integer> values) {
            addCriterion("wxlite_template_type in", values, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeNotIn(List<Integer> values) {
            addCriterion("wxlite_template_type not in", values, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeBetween(Integer value1, Integer value2) {
            addCriterion("wxlite_template_type between", value1, value2, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andWxliteTemplateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("wxlite_template_type not between", value1, value2, "wxliteTemplateType");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusIsNull() {
            addCriterion("authorizer_status is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusIsNotNull() {
            addCriterion("authorizer_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusEqualTo(Integer value) {
            addCriterion("authorizer_status =", value, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusNotEqualTo(Integer value) {
            addCriterion("authorizer_status <>", value, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusGreaterThan(Integer value) {
            addCriterion("authorizer_status >", value, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorizer_status >=", value, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusLessThan(Integer value) {
            addCriterion("authorizer_status <", value, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("authorizer_status <=", value, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusIn(List<Integer> values) {
            addCriterion("authorizer_status in", values, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusNotIn(List<Integer> values) {
            addCriterion("authorizer_status not in", values, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusBetween(Integer value1, Integer value2) {
            addCriterion("authorizer_status between", value1, value2, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorizerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("authorizer_status not between", value1, value2, "authorizerStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusIsNull() {
            addCriterion("wxlite_status is null");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusIsNotNull() {
            addCriterion("wxlite_status is not null");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusEqualTo(Integer value) {
            addCriterion("wxlite_status =", value, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusNotEqualTo(Integer value) {
            addCriterion("wxlite_status <>", value, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusGreaterThan(Integer value) {
            addCriterion("wxlite_status >", value, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wxlite_status >=", value, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusLessThan(Integer value) {
            addCriterion("wxlite_status <", value, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wxlite_status <=", value, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusIn(List<Integer> values) {
            addCriterion("wxlite_status in", values, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusNotIn(List<Integer> values) {
            addCriterion("wxlite_status not in", values, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusBetween(Integer value1, Integer value2) {
            addCriterion("wxlite_status between", value1, value2, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andWxliteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wxlite_status not between", value1, value2, "wxliteStatus");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdIsNull() {
            addCriterion("origin_app_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdIsNotNull() {
            addCriterion("origin_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdEqualTo(String value) {
            addCriterion("origin_app_id =", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdNotEqualTo(String value) {
            addCriterion("origin_app_id <>", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdGreaterThan(String value) {
            addCriterion("origin_app_id >", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("origin_app_id >=", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdLessThan(String value) {
            addCriterion("origin_app_id <", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdLessThanOrEqualTo(String value) {
            addCriterion("origin_app_id <=", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdLike(String value) {
            addCriterion("origin_app_id like", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdNotLike(String value) {
            addCriterion("origin_app_id not like", value, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdIn(List<String> values) {
            addCriterion("origin_app_id in", values, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdNotIn(List<String> values) {
            addCriterion("origin_app_id not in", values, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdBetween(String value1, String value2) {
            addCriterion("origin_app_id between", value1, value2, "originAppId");
            return (Criteria) this;
        }

        public Criteria andOriginAppIdNotBetween(String value1, String value2) {
            addCriterion("origin_app_id not between", value1, value2, "originAppId");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionIsNull() {
            addCriterion("wxlite_version is null");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionIsNotNull() {
            addCriterion("wxlite_version is not null");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionEqualTo(String value) {
            addCriterion("wxlite_version =", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionNotEqualTo(String value) {
            addCriterion("wxlite_version <>", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionGreaterThan(String value) {
            addCriterion("wxlite_version >", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionGreaterThanOrEqualTo(String value) {
            addCriterion("wxlite_version >=", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionLessThan(String value) {
            addCriterion("wxlite_version <", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionLessThanOrEqualTo(String value) {
            addCriterion("wxlite_version <=", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionLike(String value) {
            addCriterion("wxlite_version like", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionNotLike(String value) {
            addCriterion("wxlite_version not like", value, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionIn(List<String> values) {
            addCriterion("wxlite_version in", values, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionNotIn(List<String> values) {
            addCriterion("wxlite_version not in", values, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionBetween(String value1, String value2) {
            addCriterion("wxlite_version between", value1, value2, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andWxliteVersionNotBetween(String value1, String value2) {
            addCriterion("wxlite_version not between", value1, value2, "wxliteVersion");
            return (Criteria) this;
        }

        public Criteria andLogoPathIsNull() {
            addCriterion("logo_path is null");
            return (Criteria) this;
        }

        public Criteria andLogoPathIsNotNull() {
            addCriterion("logo_path is not null");
            return (Criteria) this;
        }

        public Criteria andLogoPathEqualTo(String value) {
            addCriterion("logo_path =", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathNotEqualTo(String value) {
            addCriterion("logo_path <>", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathGreaterThan(String value) {
            addCriterion("logo_path >", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathGreaterThanOrEqualTo(String value) {
            addCriterion("logo_path >=", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathLessThan(String value) {
            addCriterion("logo_path <", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathLessThanOrEqualTo(String value) {
            addCriterion("logo_path <=", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathLike(String value) {
            addCriterion("logo_path like", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathNotLike(String value) {
            addCriterion("logo_path not like", value, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathIn(List<String> values) {
            addCriterion("logo_path in", values, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathNotIn(List<String> values) {
            addCriterion("logo_path not in", values, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathBetween(String value1, String value2) {
            addCriterion("logo_path between", value1, value2, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLogoPathNotBetween(String value1, String value2) {
            addCriterion("logo_path not between", value1, value2, "logoPath");
            return (Criteria) this;
        }

        public Criteria andLegalEntityIsNull() {
            addCriterion("legal_entity is null");
            return (Criteria) this;
        }

        public Criteria andLegalEntityIsNotNull() {
            addCriterion("legal_entity is not null");
            return (Criteria) this;
        }

        public Criteria andLegalEntityEqualTo(String value) {
            addCriterion("legal_entity =", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityNotEqualTo(String value) {
            addCriterion("legal_entity <>", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityGreaterThan(String value) {
            addCriterion("legal_entity >", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityGreaterThanOrEqualTo(String value) {
            addCriterion("legal_entity >=", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityLessThan(String value) {
            addCriterion("legal_entity <", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityLessThanOrEqualTo(String value) {
            addCriterion("legal_entity <=", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityLike(String value) {
            addCriterion("legal_entity like", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityNotLike(String value) {
            addCriterion("legal_entity not like", value, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityIn(List<String> values) {
            addCriterion("legal_entity in", values, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityNotIn(List<String> values) {
            addCriterion("legal_entity not in", values, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityBetween(String value1, String value2) {
            addCriterion("legal_entity between", value1, value2, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andLegalEntityNotBetween(String value1, String value2) {
            addCriterion("legal_entity not between", value1, value2, "legalEntity");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgIsNull() {
            addCriterion("business_license_img is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgIsNotNull() {
            addCriterion("business_license_img is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgEqualTo(String value) {
            addCriterion("business_license_img =", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgNotEqualTo(String value) {
            addCriterion("business_license_img <>", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgGreaterThan(String value) {
            addCriterion("business_license_img >", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_img >=", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgLessThan(String value) {
            addCriterion("business_license_img <", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgLessThanOrEqualTo(String value) {
            addCriterion("business_license_img <=", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgLike(String value) {
            addCriterion("business_license_img like", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgNotLike(String value) {
            addCriterion("business_license_img not like", value, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgIn(List<String> values) {
            addCriterion("business_license_img in", values, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgNotIn(List<String> values) {
            addCriterion("business_license_img not in", values, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgBetween(String value1, String value2) {
            addCriterion("business_license_img between", value1, value2, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseImgNotBetween(String value1, String value2) {
            addCriterion("business_license_img not between", value1, value2, "businessLicenseImg");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andMasterNameIsNull() {
            addCriterion("master_name is null");
            return (Criteria) this;
        }

        public Criteria andMasterNameIsNotNull() {
            addCriterion("master_name is not null");
            return (Criteria) this;
        }

        public Criteria andMasterNameEqualTo(String value) {
            addCriterion("master_name =", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotEqualTo(String value) {
            addCriterion("master_name <>", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameGreaterThan(String value) {
            addCriterion("master_name >", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameGreaterThanOrEqualTo(String value) {
            addCriterion("master_name >=", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLessThan(String value) {
            addCriterion("master_name <", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLessThanOrEqualTo(String value) {
            addCriterion("master_name <=", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLike(String value) {
            addCriterion("master_name like", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotLike(String value) {
            addCriterion("master_name not like", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameIn(List<String> values) {
            addCriterion("master_name in", values, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotIn(List<String> values) {
            addCriterion("master_name not in", values, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameBetween(String value1, String value2) {
            addCriterion("master_name between", value1, value2, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotBetween(String value1, String value2) {
            addCriterion("master_name not between", value1, value2, "masterName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneIsNull() {
            addCriterion("corp_phone is null");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneIsNotNull() {
            addCriterion("corp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneEqualTo(String value) {
            addCriterion("corp_phone =", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneNotEqualTo(String value) {
            addCriterion("corp_phone <>", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneGreaterThan(String value) {
            addCriterion("corp_phone >", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("corp_phone >=", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneLessThan(String value) {
            addCriterion("corp_phone <", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneLessThanOrEqualTo(String value) {
            addCriterion("corp_phone <=", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneLike(String value) {
            addCriterion("corp_phone like", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneNotLike(String value) {
            addCriterion("corp_phone not like", value, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneIn(List<String> values) {
            addCriterion("corp_phone in", values, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneNotIn(List<String> values) {
            addCriterion("corp_phone not in", values, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneBetween(String value1, String value2) {
            addCriterion("corp_phone between", value1, value2, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andCorpPhoneNotBetween(String value1, String value2) {
            addCriterion("corp_phone not between", value1, value2, "corpPhone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursIsNull() {
            addCriterion("business_hours is null");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursIsNotNull() {
            addCriterion("business_hours is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursEqualTo(String value) {
            addCriterion("business_hours =", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursNotEqualTo(String value) {
            addCriterion("business_hours <>", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursGreaterThan(String value) {
            addCriterion("business_hours >", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursGreaterThanOrEqualTo(String value) {
            addCriterion("business_hours >=", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursLessThan(String value) {
            addCriterion("business_hours <", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursLessThanOrEqualTo(String value) {
            addCriterion("business_hours <=", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursLike(String value) {
            addCriterion("business_hours like", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursNotLike(String value) {
            addCriterion("business_hours not like", value, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursIn(List<String> values) {
            addCriterion("business_hours in", values, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursNotIn(List<String> values) {
            addCriterion("business_hours not in", values, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursBetween(String value1, String value2) {
            addCriterion("business_hours between", value1, value2, "businessHours");
            return (Criteria) this;
        }

        public Criteria andBusinessHoursNotBetween(String value1, String value2) {
            addCriterion("business_hours not between", value1, value2, "businessHours");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIsNull() {
            addCriterion("master_phone is null");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIsNotNull() {
            addCriterion("master_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneEqualTo(String value) {
            addCriterion("master_phone =", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotEqualTo(String value) {
            addCriterion("master_phone <>", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneGreaterThan(String value) {
            addCriterion("master_phone >", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("master_phone >=", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLessThan(String value) {
            addCriterion("master_phone <", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLessThanOrEqualTo(String value) {
            addCriterion("master_phone <=", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLike(String value) {
            addCriterion("master_phone like", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotLike(String value) {
            addCriterion("master_phone not like", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIn(List<String> values) {
            addCriterion("master_phone in", values, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotIn(List<String> values) {
            addCriterion("master_phone not in", values, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneBetween(String value1, String value2) {
            addCriterion("master_phone between", value1, value2, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotBetween(String value1, String value2) {
            addCriterion("master_phone not between", value1, value2, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andWechatIdIsNull() {
            addCriterion("wechat_id is null");
            return (Criteria) this;
        }

        public Criteria andWechatIdIsNotNull() {
            addCriterion("wechat_id is not null");
            return (Criteria) this;
        }

        public Criteria andWechatIdEqualTo(String value) {
            addCriterion("wechat_id =", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotEqualTo(String value) {
            addCriterion("wechat_id <>", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdGreaterThan(String value) {
            addCriterion("wechat_id >", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_id >=", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdLessThan(String value) {
            addCriterion("wechat_id <", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdLessThanOrEqualTo(String value) {
            addCriterion("wechat_id <=", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdLike(String value) {
            addCriterion("wechat_id like", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotLike(String value) {
            addCriterion("wechat_id not like", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdIn(List<String> values) {
            addCriterion("wechat_id in", values, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotIn(List<String> values) {
            addCriterion("wechat_id not in", values, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdBetween(String value1, String value2) {
            addCriterion("wechat_id between", value1, value2, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotBetween(String value1, String value2) {
            addCriterion("wechat_id not between", value1, value2, "wechatId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretIsNull() {
            addCriterion("pay_secret is null");
            return (Criteria) this;
        }

        public Criteria andPaySecretIsNotNull() {
            addCriterion("pay_secret is not null");
            return (Criteria) this;
        }

        public Criteria andPaySecretEqualTo(String value) {
            addCriterion("pay_secret =", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretNotEqualTo(String value) {
            addCriterion("pay_secret <>", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretGreaterThan(String value) {
            addCriterion("pay_secret >", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretGreaterThanOrEqualTo(String value) {
            addCriterion("pay_secret >=", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretLessThan(String value) {
            addCriterion("pay_secret <", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretLessThanOrEqualTo(String value) {
            addCriterion("pay_secret <=", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretLike(String value) {
            addCriterion("pay_secret like", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretNotLike(String value) {
            addCriterion("pay_secret not like", value, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretIn(List<String> values) {
            addCriterion("pay_secret in", values, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretNotIn(List<String> values) {
            addCriterion("pay_secret not in", values, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretBetween(String value1, String value2) {
            addCriterion("pay_secret between", value1, value2, "paySecret");
            return (Criteria) this;
        }

        public Criteria andPaySecretNotBetween(String value1, String value2) {
            addCriterion("pay_secret not between", value1, value2, "paySecret");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andCorpTypeIsNull() {
            addCriterion("corp_type is null");
            return (Criteria) this;
        }

        public Criteria andCorpTypeIsNotNull() {
            addCriterion("corp_type is not null");
            return (Criteria) this;
        }

        public Criteria andCorpTypeEqualTo(Integer value) {
            addCriterion("corp_type =", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotEqualTo(Integer value) {
            addCriterion("corp_type <>", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeGreaterThan(Integer value) {
            addCriterion("corp_type >", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("corp_type >=", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeLessThan(Integer value) {
            addCriterion("corp_type <", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("corp_type <=", value, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeIn(List<Integer> values) {
            addCriterion("corp_type in", values, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotIn(List<Integer> values) {
            addCriterion("corp_type not in", values, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeBetween(Integer value1, Integer value2) {
            addCriterion("corp_type between", value1, value2, "corpType");
            return (Criteria) this;
        }

        public Criteria andCorpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("corp_type not between", value1, value2, "corpType");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNull() {
            addCriterion("platform_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIsNotNull() {
            addCriterion("platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdEqualTo(Integer value) {
            addCriterion("platform_id =", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotEqualTo(Integer value) {
            addCriterion("platform_id <>", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThan(Integer value) {
            addCriterion("platform_id >", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_id >=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThan(Integer value) {
            addCriterion("platform_id <", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdLessThanOrEqualTo(Integer value) {
            addCriterion("platform_id <=", value, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdIn(List<Integer> values) {
            addCriterion("platform_id in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotIn(List<Integer> values) {
            addCriterion("platform_id not in", values, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdBetween(Integer value1, Integer value2) {
            addCriterion("platform_id between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andPlatformIdNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_id not between", value1, value2, "platformId");
            return (Criteria) this;
        }

        public Criteria andLablesIsNull() {
            addCriterion("lables is null");
            return (Criteria) this;
        }

        public Criteria andLablesIsNotNull() {
            addCriterion("lables is not null");
            return (Criteria) this;
        }

        public Criteria andLablesEqualTo(String value) {
            addCriterion("lables =", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotEqualTo(String value) {
            addCriterion("lables <>", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesGreaterThan(String value) {
            addCriterion("lables >", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesGreaterThanOrEqualTo(String value) {
            addCriterion("lables >=", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesLessThan(String value) {
            addCriterion("lables <", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesLessThanOrEqualTo(String value) {
            addCriterion("lables <=", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesLike(String value) {
            addCriterion("lables like", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotLike(String value) {
            addCriterion("lables not like", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesIn(List<String> values) {
            addCriterion("lables in", values, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotIn(List<String> values) {
            addCriterion("lables not in", values, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesBetween(String value1, String value2) {
            addCriterion("lables between", value1, value2, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotBetween(String value1, String value2) {
            addCriterion("lables not between", value1, value2, "lables");
            return (Criteria) this;
        }

        public Criteria andLonIsNull() {
            addCriterion("lon is null");
            return (Criteria) this;
        }

        public Criteria andLonIsNotNull() {
            addCriterion("lon is not null");
            return (Criteria) this;
        }

        public Criteria andLonEqualTo(Double value) {
            addCriterion("lon =", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotEqualTo(Double value) {
            addCriterion("lon <>", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThan(Double value) {
            addCriterion("lon >", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonGreaterThanOrEqualTo(Double value) {
            addCriterion("lon >=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThan(Double value) {
            addCriterion("lon <", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonLessThanOrEqualTo(Double value) {
            addCriterion("lon <=", value, "lon");
            return (Criteria) this;
        }

        public Criteria andLonIn(List<Double> values) {
            addCriterion("lon in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotIn(List<Double> values) {
            addCriterion("lon not in", values, "lon");
            return (Criteria) this;
        }

        public Criteria andLonBetween(Double value1, Double value2) {
            addCriterion("lon between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLonNotBetween(Double value1, Double value2) {
            addCriterion("lon not between", value1, value2, "lon");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
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

        public Criteria andVersionTypeIsNull() {
            addCriterion("version_type is null");
            return (Criteria) this;
        }

        public Criteria andVersionTypeIsNotNull() {
            addCriterion("version_type is not null");
            return (Criteria) this;
        }

        public Criteria andVersionTypeEqualTo(Integer value) {
            addCriterion("version_type =", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotEqualTo(Integer value) {
            addCriterion("version_type <>", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeGreaterThan(Integer value) {
            addCriterion("version_type >", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_type >=", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeLessThan(Integer value) {
            addCriterion("version_type <", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("version_type <=", value, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeIn(List<Integer> values) {
            addCriterion("version_type in", values, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotIn(List<Integer> values) {
            addCriterion("version_type not in", values, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeBetween(Integer value1, Integer value2) {
            addCriterion("version_type between", value1, value2, "versionType");
            return (Criteria) this;
        }

        public Criteria andVersionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("version_type not between", value1, value2, "versionType");
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