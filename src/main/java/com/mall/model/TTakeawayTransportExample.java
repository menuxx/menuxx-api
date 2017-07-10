package com.mall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTakeawayTransportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTakeawayTransportExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andTransportChannelIsNull() {
            addCriterion("transport_channel is null");
            return (Criteria) this;
        }

        public Criteria andTransportChannelIsNotNull() {
            addCriterion("transport_channel is not null");
            return (Criteria) this;
        }

        public Criteria andTransportChannelEqualTo(Integer value) {
            addCriterion("transport_channel =", value, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelNotEqualTo(Integer value) {
            addCriterion("transport_channel <>", value, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelGreaterThan(Integer value) {
            addCriterion("transport_channel >", value, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_channel >=", value, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelLessThan(Integer value) {
            addCriterion("transport_channel <", value, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelLessThanOrEqualTo(Integer value) {
            addCriterion("transport_channel <=", value, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelIn(List<Integer> values) {
            addCriterion("transport_channel in", values, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelNotIn(List<Integer> values) {
            addCriterion("transport_channel not in", values, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelBetween(Integer value1, Integer value2) {
            addCriterion("transport_channel between", value1, value2, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andTransportChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_channel not between", value1, value2, "transportChannel");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNull() {
            addCriterion("receiver_tel is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNotNull() {
            addCriterion("receiver_tel is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelEqualTo(String value) {
            addCriterion("receiver_tel =", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotEqualTo(String value) {
            addCriterion("receiver_tel <>", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThan(String value) {
            addCriterion("receiver_tel >", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_tel >=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThan(String value) {
            addCriterion("receiver_tel <", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThanOrEqualTo(String value) {
            addCriterion("receiver_tel <=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLike(String value) {
            addCriterion("receiver_tel like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotLike(String value) {
            addCriterion("receiver_tel not like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIn(List<String> values) {
            addCriterion("receiver_tel in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotIn(List<String> values) {
            addCriterion("receiver_tel not in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelBetween(String value1, String value2) {
            addCriterion("receiver_tel between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotBetween(String value1, String value2) {
            addCriterion("receiver_tel not between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverLatIsNull() {
            addCriterion("receiver_lat is null");
            return (Criteria) this;
        }

        public Criteria andReceiverLatIsNotNull() {
            addCriterion("receiver_lat is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverLatEqualTo(BigDecimal value) {
            addCriterion("receiver_lat =", value, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatNotEqualTo(BigDecimal value) {
            addCriterion("receiver_lat <>", value, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatGreaterThan(BigDecimal value) {
            addCriterion("receiver_lat >", value, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receiver_lat >=", value, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatLessThan(BigDecimal value) {
            addCriterion("receiver_lat <", value, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receiver_lat <=", value, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatIn(List<BigDecimal> values) {
            addCriterion("receiver_lat in", values, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatNotIn(List<BigDecimal> values) {
            addCriterion("receiver_lat not in", values, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receiver_lat between", value1, value2, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receiver_lat not between", value1, value2, "receiverLat");
            return (Criteria) this;
        }

        public Criteria andReceiverLngIsNull() {
            addCriterion("receiver_lng is null");
            return (Criteria) this;
        }

        public Criteria andReceiverLngIsNotNull() {
            addCriterion("receiver_lng is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverLngEqualTo(BigDecimal value) {
            addCriterion("receiver_lng =", value, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngNotEqualTo(BigDecimal value) {
            addCriterion("receiver_lng <>", value, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngGreaterThan(BigDecimal value) {
            addCriterion("receiver_lng >", value, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receiver_lng >=", value, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngLessThan(BigDecimal value) {
            addCriterion("receiver_lng <", value, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receiver_lng <=", value, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngIn(List<BigDecimal> values) {
            addCriterion("receiver_lng in", values, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngNotIn(List<BigDecimal> values) {
            addCriterion("receiver_lng not in", values, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receiver_lng between", value1, value2, "receiverLng");
            return (Criteria) this;
        }

        public Criteria andReceiverLngNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receiver_lng not between", value1, value2, "receiverLng");
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

        public Criteria andOrderTotalAmountIsNull() {
            addCriterion("order_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIsNotNull() {
            addCriterion("order_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountEqualTo(Integer value) {
            addCriterion("order_total_amount =", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotEqualTo(Integer value) {
            addCriterion("order_total_amount <>", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountGreaterThan(Integer value) {
            addCriterion("order_total_amount >", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_total_amount >=", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountLessThan(Integer value) {
            addCriterion("order_total_amount <", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("order_total_amount <=", value, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountIn(List<Integer> values) {
            addCriterion("order_total_amount in", values, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotIn(List<Integer> values) {
            addCriterion("order_total_amount not in", values, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("order_total_amount between", value1, value2, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_total_amount not between", value1, value2, "orderTotalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIsNull() {
            addCriterion("order_weight is null");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIsNotNull() {
            addCriterion("order_weight is not null");
            return (Criteria) this;
        }

        public Criteria andOrderWeightEqualTo(Double value) {
            addCriterion("order_weight =", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotEqualTo(Double value) {
            addCriterion("order_weight <>", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightGreaterThan(Double value) {
            addCriterion("order_weight >", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("order_weight >=", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightLessThan(Double value) {
            addCriterion("order_weight <", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightLessThanOrEqualTo(Double value) {
            addCriterion("order_weight <=", value, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightIn(List<Double> values) {
            addCriterion("order_weight in", values, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotIn(List<Double> values) {
            addCriterion("order_weight not in", values, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightBetween(Double value1, Double value2) {
            addCriterion("order_weight between", value1, value2, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderWeightNotBetween(Double value1, Double value2) {
            addCriterion("order_weight not between", value1, value2, "orderWeight");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNull() {
            addCriterion("goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedIsNull() {
            addCriterion("is_invoiced is null");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedIsNotNull() {
            addCriterion("is_invoiced is not null");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedEqualTo(Byte value) {
            addCriterion("is_invoiced =", value, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedNotEqualTo(Byte value) {
            addCriterion("is_invoiced <>", value, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedGreaterThan(Byte value) {
            addCriterion("is_invoiced >", value, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_invoiced >=", value, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedLessThan(Byte value) {
            addCriterion("is_invoiced <", value, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedLessThanOrEqualTo(Byte value) {
            addCriterion("is_invoiced <=", value, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedIn(List<Byte> values) {
            addCriterion("is_invoiced in", values, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedNotIn(List<Byte> values) {
            addCriterion("is_invoiced not in", values, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedBetween(Byte value1, Byte value2) {
            addCriterion("is_invoiced between", value1, value2, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andIsInvoicedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_invoiced not between", value1, value2, "isInvoiced");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(String value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(String value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(String value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(String value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(String value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLike(String value) {
            addCriterion("invoice like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotLike(String value) {
            addCriterion("invoice not like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<String> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<String> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(String value1, String value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(String value1, String value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeIsNull() {
            addCriterion("require_receive_time is null");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeIsNotNull() {
            addCriterion("require_receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeEqualTo(Date value) {
            addCriterion("require_receive_time =", value, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeNotEqualTo(Date value) {
            addCriterion("require_receive_time <>", value, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeGreaterThan(Date value) {
            addCriterion("require_receive_time >", value, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("require_receive_time >=", value, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeLessThan(Date value) {
            addCriterion("require_receive_time <", value, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("require_receive_time <=", value, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeIn(List<Date> values) {
            addCriterion("require_receive_time in", values, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeNotIn(List<Date> values) {
            addCriterion("require_receive_time not in", values, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("require_receive_time between", value1, value2, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andRequireReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("require_receive_time not between", value1, value2, "requireReceiveTime");
            return (Criteria) this;
        }

        public Criteria andTransportFeeIsNull() {
            addCriterion("transport_fee is null");
            return (Criteria) this;
        }

        public Criteria andTransportFeeIsNotNull() {
            addCriterion("transport_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTransportFeeEqualTo(Integer value) {
            addCriterion("transport_fee =", value, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeNotEqualTo(Integer value) {
            addCriterion("transport_fee <>", value, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeGreaterThan(Integer value) {
            addCriterion("transport_fee >", value, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_fee >=", value, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeLessThan(Integer value) {
            addCriterion("transport_fee <", value, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeLessThanOrEqualTo(Integer value) {
            addCriterion("transport_fee <=", value, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeIn(List<Integer> values) {
            addCriterion("transport_fee in", values, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeNotIn(List<Integer> values) {
            addCriterion("transport_fee not in", values, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeBetween(Integer value1, Integer value2) {
            addCriterion("transport_fee between", value1, value2, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_fee not between", value1, value2, "transportFee");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceIsNull() {
            addCriterion("transport_distance is null");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceIsNotNull() {
            addCriterion("transport_distance is not null");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceEqualTo(Long value) {
            addCriterion("transport_distance =", value, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceNotEqualTo(Long value) {
            addCriterion("transport_distance <>", value, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceGreaterThan(Long value) {
            addCriterion("transport_distance >", value, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceGreaterThanOrEqualTo(Long value) {
            addCriterion("transport_distance >=", value, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceLessThan(Long value) {
            addCriterion("transport_distance <", value, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceLessThanOrEqualTo(Long value) {
            addCriterion("transport_distance <=", value, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceIn(List<Long> values) {
            addCriterion("transport_distance in", values, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceNotIn(List<Long> values) {
            addCriterion("transport_distance not in", values, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceBetween(Long value1, Long value2) {
            addCriterion("transport_distance between", value1, value2, "transportDistance");
            return (Criteria) this;
        }

        public Criteria andTransportDistanceNotBetween(Long value1, Long value2) {
            addCriterion("transport_distance not between", value1, value2, "transportDistance");
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

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTransportNameIsNull() {
            addCriterion("transport_name is null");
            return (Criteria) this;
        }

        public Criteria andTransportNameIsNotNull() {
            addCriterion("transport_name is not null");
            return (Criteria) this;
        }

        public Criteria andTransportNameEqualTo(String value) {
            addCriterion("transport_name =", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameNotEqualTo(String value) {
            addCriterion("transport_name <>", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameGreaterThan(String value) {
            addCriterion("transport_name >", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameGreaterThanOrEqualTo(String value) {
            addCriterion("transport_name >=", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameLessThan(String value) {
            addCriterion("transport_name <", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameLessThanOrEqualTo(String value) {
            addCriterion("transport_name <=", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameLike(String value) {
            addCriterion("transport_name like", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameNotLike(String value) {
            addCriterion("transport_name not like", value, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameIn(List<String> values) {
            addCriterion("transport_name in", values, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameNotIn(List<String> values) {
            addCriterion("transport_name not in", values, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameBetween(String value1, String value2) {
            addCriterion("transport_name between", value1, value2, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportNameNotBetween(String value1, String value2) {
            addCriterion("transport_name not between", value1, value2, "transportName");
            return (Criteria) this;
        }

        public Criteria andTransportTelIsNull() {
            addCriterion("transport_tel is null");
            return (Criteria) this;
        }

        public Criteria andTransportTelIsNotNull() {
            addCriterion("transport_tel is not null");
            return (Criteria) this;
        }

        public Criteria andTransportTelEqualTo(String value) {
            addCriterion("transport_tel =", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelNotEqualTo(String value) {
            addCriterion("transport_tel <>", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelGreaterThan(String value) {
            addCriterion("transport_tel >", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelGreaterThanOrEqualTo(String value) {
            addCriterion("transport_tel >=", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelLessThan(String value) {
            addCriterion("transport_tel <", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelLessThanOrEqualTo(String value) {
            addCriterion("transport_tel <=", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelLike(String value) {
            addCriterion("transport_tel like", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelNotLike(String value) {
            addCriterion("transport_tel not like", value, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelIn(List<String> values) {
            addCriterion("transport_tel in", values, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelNotIn(List<String> values) {
            addCriterion("transport_tel not in", values, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelBetween(String value1, String value2) {
            addCriterion("transport_tel between", value1, value2, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportTelNotBetween(String value1, String value2) {
            addCriterion("transport_tel not between", value1, value2, "transportTel");
            return (Criteria) this;
        }

        public Criteria andTransportNoIsNull() {
            addCriterion("transport_no is null");
            return (Criteria) this;
        }

        public Criteria andTransportNoIsNotNull() {
            addCriterion("transport_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransportNoEqualTo(String value) {
            addCriterion("transport_no =", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotEqualTo(String value) {
            addCriterion("transport_no <>", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoGreaterThan(String value) {
            addCriterion("transport_no >", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoGreaterThanOrEqualTo(String value) {
            addCriterion("transport_no >=", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLessThan(String value) {
            addCriterion("transport_no <", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLessThanOrEqualTo(String value) {
            addCriterion("transport_no <=", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoLike(String value) {
            addCriterion("transport_no like", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotLike(String value) {
            addCriterion("transport_no not like", value, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoIn(List<String> values) {
            addCriterion("transport_no in", values, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotIn(List<String> values) {
            addCriterion("transport_no not in", values, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoBetween(String value1, String value2) {
            addCriterion("transport_no between", value1, value2, "transportNo");
            return (Criteria) this;
        }

        public Criteria andTransportNoNotBetween(String value1, String value2) {
            addCriterion("transport_no not between", value1, value2, "transportNo");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("accept_time is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("accept_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("accept_time =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("accept_time <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("accept_time >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accept_time >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("accept_time <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("accept_time <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("accept_time in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("accept_time not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("accept_time between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("accept_time not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
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