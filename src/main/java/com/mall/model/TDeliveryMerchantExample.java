package com.mall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDeliveryMerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDeliveryMerchantExample() {
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

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(Integer value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(Integer value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(Integer value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(Integer value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<Integer> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<Integer> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(Integer value1, Integer value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeIsNull() {
            addCriterion("dada_city_code is null");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeIsNotNull() {
            addCriterion("dada_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeEqualTo(String value) {
            addCriterion("dada_city_code =", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeNotEqualTo(String value) {
            addCriterion("dada_city_code <>", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeGreaterThan(String value) {
            addCriterion("dada_city_code >", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dada_city_code >=", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeLessThan(String value) {
            addCriterion("dada_city_code <", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeLessThanOrEqualTo(String value) {
            addCriterion("dada_city_code <=", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeLike(String value) {
            addCriterion("dada_city_code like", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeNotLike(String value) {
            addCriterion("dada_city_code not like", value, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeIn(List<String> values) {
            addCriterion("dada_city_code in", values, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeNotIn(List<String> values) {
            addCriterion("dada_city_code not in", values, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeBetween(String value1, String value2) {
            addCriterion("dada_city_code between", value1, value2, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andDadaCityCodeNotBetween(String value1, String value2) {
            addCriterion("dada_city_code not between", value1, value2, "dadaCityCode");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNull() {
            addCriterion("shop_address is null");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNotNull() {
            addCriterion("shop_address is not null");
            return (Criteria) this;
        }

        public Criteria andShopAddressEqualTo(String value) {
            addCriterion("shop_address =", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotEqualTo(String value) {
            addCriterion("shop_address <>", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThan(String value) {
            addCriterion("shop_address >", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_address >=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThan(String value) {
            addCriterion("shop_address <", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThanOrEqualTo(String value) {
            addCriterion("shop_address <=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLike(String value) {
            addCriterion("shop_address like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotLike(String value) {
            addCriterion("shop_address not like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressIn(List<String> values) {
            addCriterion("shop_address in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotIn(List<String> values) {
            addCriterion("shop_address not in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressBetween(String value1, String value2) {
            addCriterion("shop_address between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotBetween(String value1, String value2) {
            addCriterion("shop_address not between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(BigDecimal value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(BigDecimal value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(BigDecimal value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(BigDecimal value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<BigDecimal> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<BigDecimal> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lng not between", value1, value2, "lng");
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

        public Criteria andLatEqualTo(BigDecimal value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(BigDecimal value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(BigDecimal value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(BigDecimal value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<BigDecimal> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<BigDecimal> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andShopNoIsNull() {
            addCriterion("shop_no is null");
            return (Criteria) this;
        }

        public Criteria andShopNoIsNotNull() {
            addCriterion("shop_no is not null");
            return (Criteria) this;
        }

        public Criteria andShopNoEqualTo(String value) {
            addCriterion("shop_no =", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoNotEqualTo(String value) {
            addCriterion("shop_no <>", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoGreaterThan(String value) {
            addCriterion("shop_no >", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoGreaterThanOrEqualTo(String value) {
            addCriterion("shop_no >=", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoLessThan(String value) {
            addCriterion("shop_no <", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoLessThanOrEqualTo(String value) {
            addCriterion("shop_no <=", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoLike(String value) {
            addCriterion("shop_no like", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoNotLike(String value) {
            addCriterion("shop_no not like", value, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoIn(List<String> values) {
            addCriterion("shop_no in", values, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoNotIn(List<String> values) {
            addCriterion("shop_no not in", values, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoBetween(String value1, String value2) {
            addCriterion("shop_no between", value1, value2, "shopNo");
            return (Criteria) this;
        }

        public Criteria andShopNoNotBetween(String value1, String value2) {
            addCriterion("shop_no not between", value1, value2, "shopNo");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameIsNull() {
            addCriterion("imdada_username is null");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameIsNotNull() {
            addCriterion("imdada_username is not null");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameEqualTo(String value) {
            addCriterion("imdada_username =", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameNotEqualTo(String value) {
            addCriterion("imdada_username <>", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameGreaterThan(String value) {
            addCriterion("imdada_username >", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("imdada_username >=", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameLessThan(String value) {
            addCriterion("imdada_username <", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameLessThanOrEqualTo(String value) {
            addCriterion("imdada_username <=", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameLike(String value) {
            addCriterion("imdada_username like", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameNotLike(String value) {
            addCriterion("imdada_username not like", value, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameIn(List<String> values) {
            addCriterion("imdada_username in", values, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameNotIn(List<String> values) {
            addCriterion("imdada_username not in", values, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameBetween(String value1, String value2) {
            addCriterion("imdada_username between", value1, value2, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaUsernameNotBetween(String value1, String value2) {
            addCriterion("imdada_username not between", value1, value2, "imdadaUsername");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordIsNull() {
            addCriterion("imdada_password is null");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordIsNotNull() {
            addCriterion("imdada_password is not null");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordEqualTo(String value) {
            addCriterion("imdada_password =", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordNotEqualTo(String value) {
            addCriterion("imdada_password <>", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordGreaterThan(String value) {
            addCriterion("imdada_password >", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("imdada_password >=", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordLessThan(String value) {
            addCriterion("imdada_password <", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordLessThanOrEqualTo(String value) {
            addCriterion("imdada_password <=", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordLike(String value) {
            addCriterion("imdada_password like", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordNotLike(String value) {
            addCriterion("imdada_password not like", value, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordIn(List<String> values) {
            addCriterion("imdada_password in", values, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordNotIn(List<String> values) {
            addCriterion("imdada_password not in", values, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordBetween(String value1, String value2) {
            addCriterion("imdada_password between", value1, value2, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andImdadaPasswordNotBetween(String value1, String value2) {
            addCriterion("imdada_password not between", value1, value2, "imdadaPassword");
            return (Criteria) this;
        }

        public Criteria andEleAppIdIsNull() {
            addCriterion("ele_app_id is null");
            return (Criteria) this;
        }

        public Criteria andEleAppIdIsNotNull() {
            addCriterion("ele_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andEleAppIdEqualTo(String value) {
            addCriterion("ele_app_id =", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdNotEqualTo(String value) {
            addCriterion("ele_app_id <>", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdGreaterThan(String value) {
            addCriterion("ele_app_id >", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("ele_app_id >=", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdLessThan(String value) {
            addCriterion("ele_app_id <", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdLessThanOrEqualTo(String value) {
            addCriterion("ele_app_id <=", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdLike(String value) {
            addCriterion("ele_app_id like", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdNotLike(String value) {
            addCriterion("ele_app_id not like", value, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdIn(List<String> values) {
            addCriterion("ele_app_id in", values, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdNotIn(List<String> values) {
            addCriterion("ele_app_id not in", values, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdBetween(String value1, String value2) {
            addCriterion("ele_app_id between", value1, value2, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andEleAppIdNotBetween(String value1, String value2) {
            addCriterion("ele_app_id not between", value1, value2, "eleAppId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdIsNull() {
            addCriterion("dada_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdIsNotNull() {
            addCriterion("dada_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdEqualTo(Integer value) {
            addCriterion("dada_merchant_id =", value, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdNotEqualTo(Integer value) {
            addCriterion("dada_merchant_id <>", value, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdGreaterThan(Integer value) {
            addCriterion("dada_merchant_id >", value, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dada_merchant_id >=", value, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdLessThan(Integer value) {
            addCriterion("dada_merchant_id <", value, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdLessThanOrEqualTo(Integer value) {
            addCriterion("dada_merchant_id <=", value, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdIn(List<Integer> values) {
            addCriterion("dada_merchant_id in", values, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdNotIn(List<Integer> values) {
            addCriterion("dada_merchant_id not in", values, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdBetween(Integer value1, Integer value2) {
            addCriterion("dada_merchant_id between", value1, value2, "dadaMerchantId");
            return (Criteria) this;
        }

        public Criteria andDadaMerchantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dada_merchant_id not between", value1, value2, "dadaMerchantId");
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