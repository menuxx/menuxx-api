package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TChargeApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChargeApplyExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andAttachIsNull() {
            addCriterion("attach is null");
            return (Criteria) this;
        }

        public Criteria andAttachIsNotNull() {
            addCriterion("attach is not null");
            return (Criteria) this;
        }

        public Criteria andAttachEqualTo(String value) {
            addCriterion("attach =", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotEqualTo(String value) {
            addCriterion("attach <>", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachGreaterThan(String value) {
            addCriterion("attach >", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachGreaterThanOrEqualTo(String value) {
            addCriterion("attach >=", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLessThan(String value) {
            addCriterion("attach <", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLessThanOrEqualTo(String value) {
            addCriterion("attach <=", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLike(String value) {
            addCriterion("attach like", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotLike(String value) {
            addCriterion("attach not like", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachIn(List<String> values) {
            addCriterion("attach in", values, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotIn(List<String> values) {
            addCriterion("attach not in", values, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachBetween(String value1, String value2) {
            addCriterion("attach between", value1, value2, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotBetween(String value1, String value2) {
            addCriterion("attach not between", value1, value2, "attach");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNull() {
            addCriterion("bank_type is null");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNotNull() {
            addCriterion("bank_type is not null");
            return (Criteria) this;
        }

        public Criteria andBankTypeEqualTo(String value) {
            addCriterion("bank_type =", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotEqualTo(String value) {
            addCriterion("bank_type <>", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThan(String value) {
            addCriterion("bank_type >", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_type >=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThan(String value) {
            addCriterion("bank_type <", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThanOrEqualTo(String value) {
            addCriterion("bank_type <=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLike(String value) {
            addCriterion("bank_type like", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotLike(String value) {
            addCriterion("bank_type not like", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeIn(List<String> values) {
            addCriterion("bank_type in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotIn(List<String> values) {
            addCriterion("bank_type not in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeBetween(String value1, String value2) {
            addCriterion("bank_type between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotBetween(String value1, String value2) {
            addCriterion("bank_type not between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andCashFeeIsNull() {
            addCriterion("cash_fee is null");
            return (Criteria) this;
        }

        public Criteria andCashFeeIsNotNull() {
            addCriterion("cash_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCashFeeEqualTo(Integer value) {
            addCriterion("cash_fee =", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeNotEqualTo(Integer value) {
            addCriterion("cash_fee <>", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeGreaterThan(Integer value) {
            addCriterion("cash_fee >", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cash_fee >=", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeLessThan(Integer value) {
            addCriterion("cash_fee <", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeLessThanOrEqualTo(Integer value) {
            addCriterion("cash_fee <=", value, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeIn(List<Integer> values) {
            addCriterion("cash_fee in", values, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeNotIn(List<Integer> values) {
            addCriterion("cash_fee not in", values, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeBetween(Integer value1, Integer value2) {
            addCriterion("cash_fee between", value1, value2, "cashFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("cash_fee not between", value1, value2, "cashFee");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("fee_type is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("fee_type =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(String value) {
            addCriterion("fee_type <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(String value) {
            addCriterion("fee_type >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fee_type >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(String value) {
            addCriterion("fee_type <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("fee_type <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLike(String value) {
            addCriterion("fee_type like", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotLike(String value) {
            addCriterion("fee_type not like", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<String> values) {
            addCriterion("fee_type in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<String> values) {
            addCriterion("fee_type not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(String value1, String value2) {
            addCriterion("fee_type between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(String value1, String value2) {
            addCriterion("fee_type not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeIsNull() {
            addCriterion("is_subscribe is null");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeIsNotNull() {
            addCriterion("is_subscribe is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeEqualTo(String value) {
            addCriterion("is_subscribe =", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotEqualTo(String value) {
            addCriterion("is_subscribe <>", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeGreaterThan(String value) {
            addCriterion("is_subscribe >", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeGreaterThanOrEqualTo(String value) {
            addCriterion("is_subscribe >=", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeLessThan(String value) {
            addCriterion("is_subscribe <", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeLessThanOrEqualTo(String value) {
            addCriterion("is_subscribe <=", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeLike(String value) {
            addCriterion("is_subscribe like", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotLike(String value) {
            addCriterion("is_subscribe not like", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeIn(List<String> values) {
            addCriterion("is_subscribe in", values, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotIn(List<String> values) {
            addCriterion("is_subscribe not in", values, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeBetween(String value1, String value2) {
            addCriterion("is_subscribe between", value1, value2, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotBetween(String value1, String value2) {
            addCriterion("is_subscribe not between", value1, value2, "isSubscribe");
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

        public Criteria andNonceStrIsNull() {
            addCriterion("nonce_str is null");
            return (Criteria) this;
        }

        public Criteria andNonceStrIsNotNull() {
            addCriterion("nonce_str is not null");
            return (Criteria) this;
        }

        public Criteria andNonceStrEqualTo(String value) {
            addCriterion("nonce_str =", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotEqualTo(String value) {
            addCriterion("nonce_str <>", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrGreaterThan(String value) {
            addCriterion("nonce_str >", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrGreaterThanOrEqualTo(String value) {
            addCriterion("nonce_str >=", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLessThan(String value) {
            addCriterion("nonce_str <", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLessThanOrEqualTo(String value) {
            addCriterion("nonce_str <=", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLike(String value) {
            addCriterion("nonce_str like", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotLike(String value) {
            addCriterion("nonce_str not like", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrIn(List<String> values) {
            addCriterion("nonce_str in", values, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotIn(List<String> values) {
            addCriterion("nonce_str not in", values, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrBetween(String value1, String value2) {
            addCriterion("nonce_str between", value1, value2, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotBetween(String value1, String value2) {
            addCriterion("nonce_str not between", value1, value2, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNull() {
            addCriterion("result_code is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("result_code is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("result_code =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("result_code <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("result_code >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("result_code >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("result_code <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("result_code <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("result_code like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("result_code not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("result_code in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("result_code not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("result_code between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("result_code not between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNull() {
            addCriterion("return_code is null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNotNull() {
            addCriterion("return_code is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeEqualTo(String value) {
            addCriterion("return_code =", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotEqualTo(String value) {
            addCriterion("return_code <>", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThan(String value) {
            addCriterion("return_code >", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("return_code >=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThan(String value) {
            addCriterion("return_code <", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("return_code <=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLike(String value) {
            addCriterion("return_code like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotLike(String value) {
            addCriterion("return_code not like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIn(List<String> values) {
            addCriterion("return_code in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotIn(List<String> values) {
            addCriterion("return_code not in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeBetween(String value1, String value2) {
            addCriterion("return_code between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotBetween(String value1, String value2) {
            addCriterion("return_code not between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andTimeEndIsNull() {
            addCriterion("time_end is null");
            return (Criteria) this;
        }

        public Criteria andTimeEndIsNotNull() {
            addCriterion("time_end is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEndEqualTo(String value) {
            addCriterion("time_end =", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotEqualTo(String value) {
            addCriterion("time_end <>", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndGreaterThan(String value) {
            addCriterion("time_end >", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndGreaterThanOrEqualTo(String value) {
            addCriterion("time_end >=", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndLessThan(String value) {
            addCriterion("time_end <", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndLessThanOrEqualTo(String value) {
            addCriterion("time_end <=", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndLike(String value) {
            addCriterion("time_end like", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotLike(String value) {
            addCriterion("time_end not like", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndIn(List<String> values) {
            addCriterion("time_end in", values, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotIn(List<String> values) {
            addCriterion("time_end not in", values, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndBetween(String value1, String value2) {
            addCriterion("time_end between", value1, value2, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotBetween(String value1, String value2) {
            addCriterion("time_end not between", value1, value2, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Integer value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Integer value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Integer value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Integer value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Integer value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Integer> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Integer> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Integer value1, Integer value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoIsNull() {
            addCriterion("divice_info is null");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoIsNotNull() {
            addCriterion("divice_info is not null");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoEqualTo(String value) {
            addCriterion("divice_info =", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoNotEqualTo(String value) {
            addCriterion("divice_info <>", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoGreaterThan(String value) {
            addCriterion("divice_info >", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("divice_info >=", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoLessThan(String value) {
            addCriterion("divice_info <", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoLessThanOrEqualTo(String value) {
            addCriterion("divice_info <=", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoLike(String value) {
            addCriterion("divice_info like", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoNotLike(String value) {
            addCriterion("divice_info not like", value, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoIn(List<String> values) {
            addCriterion("divice_info in", values, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoNotIn(List<String> values) {
            addCriterion("divice_info not in", values, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoBetween(String value1, String value2) {
            addCriterion("divice_info between", value1, value2, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andDiviceInfoNotBetween(String value1, String value2) {
            addCriterion("divice_info not between", value1, value2, "diviceInfo");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNull() {
            addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(String value) {
            addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(String value) {
            addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(String value) {
            addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(String value) {
            addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(String value) {
            addCriterion("sign_type <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLike(String value) {
            addCriterion("sign_type like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotLike(String value) {
            addCriterion("sign_type not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<String> values) {
            addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<String> values) {
            addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(String value1, String value2) {
            addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(String value1, String value2) {
            addCriterion("sign_type not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("err_code is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("err_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(String value) {
            addCriterion("err_code =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(String value) {
            addCriterion("err_code <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(String value) {
            addCriterion("err_code >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("err_code >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(String value) {
            addCriterion("err_code <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(String value) {
            addCriterion("err_code <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLike(String value) {
            addCriterion("err_code like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotLike(String value) {
            addCriterion("err_code not like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<String> values) {
            addCriterion("err_code in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<String> values) {
            addCriterion("err_code not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(String value1, String value2) {
            addCriterion("err_code between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(String value1, String value2) {
            addCriterion("err_code not between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesIsNull() {
            addCriterion("err_code_des is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesIsNotNull() {
            addCriterion("err_code_des is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesEqualTo(String value) {
            addCriterion("err_code_des =", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotEqualTo(String value) {
            addCriterion("err_code_des <>", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesGreaterThan(String value) {
            addCriterion("err_code_des >", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesGreaterThanOrEqualTo(String value) {
            addCriterion("err_code_des >=", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesLessThan(String value) {
            addCriterion("err_code_des <", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesLessThanOrEqualTo(String value) {
            addCriterion("err_code_des <=", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesLike(String value) {
            addCriterion("err_code_des like", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotLike(String value) {
            addCriterion("err_code_des not like", value, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesIn(List<String> values) {
            addCriterion("err_code_des in", values, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotIn(List<String> values) {
            addCriterion("err_code_des not in", values, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesBetween(String value1, String value2) {
            addCriterion("err_code_des between", value1, value2, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andErrCodeDesNotBetween(String value1, String value2) {
            addCriterion("err_code_des not between", value1, value2, "errCodeDes");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeIsNull() {
            addCriterion("settlement_total_fee is null");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeIsNotNull() {
            addCriterion("settlement_total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeEqualTo(Integer value) {
            addCriterion("settlement_total_fee =", value, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeNotEqualTo(Integer value) {
            addCriterion("settlement_total_fee <>", value, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeGreaterThan(Integer value) {
            addCriterion("settlement_total_fee >", value, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("settlement_total_fee >=", value, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeLessThan(Integer value) {
            addCriterion("settlement_total_fee <", value, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeLessThanOrEqualTo(Integer value) {
            addCriterion("settlement_total_fee <=", value, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeIn(List<Integer> values) {
            addCriterion("settlement_total_fee in", values, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeNotIn(List<Integer> values) {
            addCriterion("settlement_total_fee not in", values, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeBetween(Integer value1, Integer value2) {
            addCriterion("settlement_total_fee between", value1, value2, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andSettlementTotalFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("settlement_total_fee not between", value1, value2, "settlementTotalFee");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeIsNull() {
            addCriterion("cash_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeIsNotNull() {
            addCriterion("cash_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeEqualTo(String value) {
            addCriterion("cash_fee_type =", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeNotEqualTo(String value) {
            addCriterion("cash_fee_type <>", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeGreaterThan(String value) {
            addCriterion("cash_fee_type >", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cash_fee_type >=", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeLessThan(String value) {
            addCriterion("cash_fee_type <", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("cash_fee_type <=", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeLike(String value) {
            addCriterion("cash_fee_type like", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeNotLike(String value) {
            addCriterion("cash_fee_type not like", value, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeIn(List<String> values) {
            addCriterion("cash_fee_type in", values, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeNotIn(List<String> values) {
            addCriterion("cash_fee_type not in", values, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeBetween(String value1, String value2) {
            addCriterion("cash_fee_type between", value1, value2, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCashFeeTypeNotBetween(String value1, String value2) {
            addCriterion("cash_fee_type not between", value1, value2, "cashFeeType");
            return (Criteria) this;
        }

        public Criteria andCouponFeeIsNull() {
            addCriterion("coupon_fee is null");
            return (Criteria) this;
        }

        public Criteria andCouponFeeIsNotNull() {
            addCriterion("coupon_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFeeEqualTo(Integer value) {
            addCriterion("coupon_fee =", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeNotEqualTo(Integer value) {
            addCriterion("coupon_fee <>", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeGreaterThan(Integer value) {
            addCriterion("coupon_fee >", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee >=", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeLessThan(Integer value) {
            addCriterion("coupon_fee <", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee <=", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeIn(List<Integer> values) {
            addCriterion("coupon_fee in", values, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeNotIn(List<Integer> values) {
            addCriterion("coupon_fee not in", values, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee between", value1, value2, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee not between", value1, value2, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNull() {
            addCriterion("coupon_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNotNull() {
            addCriterion("coupon_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCountEqualTo(Integer value) {
            addCriterion("coupon_count =", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotEqualTo(Integer value) {
            addCriterion("coupon_count <>", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThan(Integer value) {
            addCriterion("coupon_count >", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_count >=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThan(Integer value) {
            addCriterion("coupon_count <", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_count <=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIn(List<Integer> values) {
            addCriterion("coupon_count in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotIn(List<Integer> values) {
            addCriterion("coupon_count not in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count not between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponType0IsNull() {
            addCriterion("coupon_type_0 is null");
            return (Criteria) this;
        }

        public Criteria andCouponType0IsNotNull() {
            addCriterion("coupon_type_0 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponType0EqualTo(Integer value) {
            addCriterion("coupon_type_0 =", value, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0NotEqualTo(Integer value) {
            addCriterion("coupon_type_0 <>", value, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0GreaterThan(Integer value) {
            addCriterion("coupon_type_0 >", value, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type_0 >=", value, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0LessThan(Integer value) {
            addCriterion("coupon_type_0 <", value, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type_0 <=", value, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0In(List<Integer> values) {
            addCriterion("coupon_type_0 in", values, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0NotIn(List<Integer> values) {
            addCriterion("coupon_type_0 not in", values, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0Between(Integer value1, Integer value2) {
            addCriterion("coupon_type_0 between", value1, value2, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType0NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type_0 not between", value1, value2, "couponType0");
            return (Criteria) this;
        }

        public Criteria andCouponType1IsNull() {
            addCriterion("coupon_type_1 is null");
            return (Criteria) this;
        }

        public Criteria andCouponType1IsNotNull() {
            addCriterion("coupon_type_1 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponType1EqualTo(Integer value) {
            addCriterion("coupon_type_1 =", value, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1NotEqualTo(Integer value) {
            addCriterion("coupon_type_1 <>", value, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1GreaterThan(Integer value) {
            addCriterion("coupon_type_1 >", value, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type_1 >=", value, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1LessThan(Integer value) {
            addCriterion("coupon_type_1 <", value, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type_1 <=", value, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1In(List<Integer> values) {
            addCriterion("coupon_type_1 in", values, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1NotIn(List<Integer> values) {
            addCriterion("coupon_type_1 not in", values, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1Between(Integer value1, Integer value2) {
            addCriterion("coupon_type_1 between", value1, value2, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponType1NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type_1 not between", value1, value2, "couponType1");
            return (Criteria) this;
        }

        public Criteria andCouponId0IsNull() {
            addCriterion("coupon_id_0 is null");
            return (Criteria) this;
        }

        public Criteria andCouponId0IsNotNull() {
            addCriterion("coupon_id_0 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponId0EqualTo(String value) {
            addCriterion("coupon_id_0 =", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0NotEqualTo(String value) {
            addCriterion("coupon_id_0 <>", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0GreaterThan(String value) {
            addCriterion("coupon_id_0 >", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0GreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id_0 >=", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0LessThan(String value) {
            addCriterion("coupon_id_0 <", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0LessThanOrEqualTo(String value) {
            addCriterion("coupon_id_0 <=", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0Like(String value) {
            addCriterion("coupon_id_0 like", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0NotLike(String value) {
            addCriterion("coupon_id_0 not like", value, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0In(List<String> values) {
            addCriterion("coupon_id_0 in", values, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0NotIn(List<String> values) {
            addCriterion("coupon_id_0 not in", values, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0Between(String value1, String value2) {
            addCriterion("coupon_id_0 between", value1, value2, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId0NotBetween(String value1, String value2) {
            addCriterion("coupon_id_0 not between", value1, value2, "couponId0");
            return (Criteria) this;
        }

        public Criteria andCouponId1IsNull() {
            addCriterion("coupon_id_1 is null");
            return (Criteria) this;
        }

        public Criteria andCouponId1IsNotNull() {
            addCriterion("coupon_id_1 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponId1EqualTo(String value) {
            addCriterion("coupon_id_1 =", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1NotEqualTo(String value) {
            addCriterion("coupon_id_1 <>", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1GreaterThan(String value) {
            addCriterion("coupon_id_1 >", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1GreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id_1 >=", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1LessThan(String value) {
            addCriterion("coupon_id_1 <", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1LessThanOrEqualTo(String value) {
            addCriterion("coupon_id_1 <=", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1Like(String value) {
            addCriterion("coupon_id_1 like", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1NotLike(String value) {
            addCriterion("coupon_id_1 not like", value, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1In(List<String> values) {
            addCriterion("coupon_id_1 in", values, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1NotIn(List<String> values) {
            addCriterion("coupon_id_1 not in", values, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1Between(String value1, String value2) {
            addCriterion("coupon_id_1 between", value1, value2, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId1NotBetween(String value1, String value2) {
            addCriterion("coupon_id_1 not between", value1, value2, "couponId1");
            return (Criteria) this;
        }

        public Criteria andCouponId2IsNull() {
            addCriterion("coupon_id_2 is null");
            return (Criteria) this;
        }

        public Criteria andCouponId2IsNotNull() {
            addCriterion("coupon_id_2 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponId2EqualTo(String value) {
            addCriterion("coupon_id_2 =", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2NotEqualTo(String value) {
            addCriterion("coupon_id_2 <>", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2GreaterThan(String value) {
            addCriterion("coupon_id_2 >", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2GreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id_2 >=", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2LessThan(String value) {
            addCriterion("coupon_id_2 <", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2LessThanOrEqualTo(String value) {
            addCriterion("coupon_id_2 <=", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2Like(String value) {
            addCriterion("coupon_id_2 like", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2NotLike(String value) {
            addCriterion("coupon_id_2 not like", value, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2In(List<String> values) {
            addCriterion("coupon_id_2 in", values, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2NotIn(List<String> values) {
            addCriterion("coupon_id_2 not in", values, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2Between(String value1, String value2) {
            addCriterion("coupon_id_2 between", value1, value2, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId2NotBetween(String value1, String value2) {
            addCriterion("coupon_id_2 not between", value1, value2, "couponId2");
            return (Criteria) this;
        }

        public Criteria andCouponId3IsNull() {
            addCriterion("coupon_id_3 is null");
            return (Criteria) this;
        }

        public Criteria andCouponId3IsNotNull() {
            addCriterion("coupon_id_3 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponId3EqualTo(String value) {
            addCriterion("coupon_id_3 =", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3NotEqualTo(String value) {
            addCriterion("coupon_id_3 <>", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3GreaterThan(String value) {
            addCriterion("coupon_id_3 >", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3GreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id_3 >=", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3LessThan(String value) {
            addCriterion("coupon_id_3 <", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3LessThanOrEqualTo(String value) {
            addCriterion("coupon_id_3 <=", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3Like(String value) {
            addCriterion("coupon_id_3 like", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3NotLike(String value) {
            addCriterion("coupon_id_3 not like", value, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3In(List<String> values) {
            addCriterion("coupon_id_3 in", values, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3NotIn(List<String> values) {
            addCriterion("coupon_id_3 not in", values, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3Between(String value1, String value2) {
            addCriterion("coupon_id_3 between", value1, value2, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId3NotBetween(String value1, String value2) {
            addCriterion("coupon_id_3 not between", value1, value2, "couponId3");
            return (Criteria) this;
        }

        public Criteria andCouponId4IsNull() {
            addCriterion("coupon_id_4 is null");
            return (Criteria) this;
        }

        public Criteria andCouponId4IsNotNull() {
            addCriterion("coupon_id_4 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponId4EqualTo(String value) {
            addCriterion("coupon_id_4 =", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4NotEqualTo(String value) {
            addCriterion("coupon_id_4 <>", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4GreaterThan(String value) {
            addCriterion("coupon_id_4 >", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4GreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id_4 >=", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4LessThan(String value) {
            addCriterion("coupon_id_4 <", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4LessThanOrEqualTo(String value) {
            addCriterion("coupon_id_4 <=", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4Like(String value) {
            addCriterion("coupon_id_4 like", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4NotLike(String value) {
            addCriterion("coupon_id_4 not like", value, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4In(List<String> values) {
            addCriterion("coupon_id_4 in", values, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4NotIn(List<String> values) {
            addCriterion("coupon_id_4 not in", values, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4Between(String value1, String value2) {
            addCriterion("coupon_id_4 between", value1, value2, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId4NotBetween(String value1, String value2) {
            addCriterion("coupon_id_4 not between", value1, value2, "couponId4");
            return (Criteria) this;
        }

        public Criteria andCouponId5IsNull() {
            addCriterion("coupon_id_5 is null");
            return (Criteria) this;
        }

        public Criteria andCouponId5IsNotNull() {
            addCriterion("coupon_id_5 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponId5EqualTo(String value) {
            addCriterion("coupon_id_5 =", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5NotEqualTo(String value) {
            addCriterion("coupon_id_5 <>", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5GreaterThan(String value) {
            addCriterion("coupon_id_5 >", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5GreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id_5 >=", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5LessThan(String value) {
            addCriterion("coupon_id_5 <", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5LessThanOrEqualTo(String value) {
            addCriterion("coupon_id_5 <=", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5Like(String value) {
            addCriterion("coupon_id_5 like", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5NotLike(String value) {
            addCriterion("coupon_id_5 not like", value, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5In(List<String> values) {
            addCriterion("coupon_id_5 in", values, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5NotIn(List<String> values) {
            addCriterion("coupon_id_5 not in", values, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5Between(String value1, String value2) {
            addCriterion("coupon_id_5 between", value1, value2, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponId5NotBetween(String value1, String value2) {
            addCriterion("coupon_id_5 not between", value1, value2, "couponId5");
            return (Criteria) this;
        }

        public Criteria andCouponFee0IsNull() {
            addCriterion("coupon_fee_0 is null");
            return (Criteria) this;
        }

        public Criteria andCouponFee0IsNotNull() {
            addCriterion("coupon_fee_0 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFee0EqualTo(Integer value) {
            addCriterion("coupon_fee_0 =", value, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0NotEqualTo(Integer value) {
            addCriterion("coupon_fee_0 <>", value, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0GreaterThan(Integer value) {
            addCriterion("coupon_fee_0 >", value, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_0 >=", value, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0LessThan(Integer value) {
            addCriterion("coupon_fee_0 <", value, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_0 <=", value, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0In(List<Integer> values) {
            addCriterion("coupon_fee_0 in", values, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0NotIn(List<Integer> values) {
            addCriterion("coupon_fee_0 not in", values, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0Between(Integer value1, Integer value2) {
            addCriterion("coupon_fee_0 between", value1, value2, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee0NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee_0 not between", value1, value2, "couponFee0");
            return (Criteria) this;
        }

        public Criteria andCouponFee1IsNull() {
            addCriterion("coupon_fee_1 is null");
            return (Criteria) this;
        }

        public Criteria andCouponFee1IsNotNull() {
            addCriterion("coupon_fee_1 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFee1EqualTo(Integer value) {
            addCriterion("coupon_fee_1 =", value, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1NotEqualTo(Integer value) {
            addCriterion("coupon_fee_1 <>", value, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1GreaterThan(Integer value) {
            addCriterion("coupon_fee_1 >", value, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_1 >=", value, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1LessThan(Integer value) {
            addCriterion("coupon_fee_1 <", value, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_1 <=", value, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1In(List<Integer> values) {
            addCriterion("coupon_fee_1 in", values, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1NotIn(List<Integer> values) {
            addCriterion("coupon_fee_1 not in", values, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1Between(Integer value1, Integer value2) {
            addCriterion("coupon_fee_1 between", value1, value2, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee1NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee_1 not between", value1, value2, "couponFee1");
            return (Criteria) this;
        }

        public Criteria andCouponFee2IsNull() {
            addCriterion("coupon_fee_2 is null");
            return (Criteria) this;
        }

        public Criteria andCouponFee2IsNotNull() {
            addCriterion("coupon_fee_2 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFee2EqualTo(Integer value) {
            addCriterion("coupon_fee_2 =", value, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2NotEqualTo(Integer value) {
            addCriterion("coupon_fee_2 <>", value, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2GreaterThan(Integer value) {
            addCriterion("coupon_fee_2 >", value, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_2 >=", value, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2LessThan(Integer value) {
            addCriterion("coupon_fee_2 <", value, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_2 <=", value, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2In(List<Integer> values) {
            addCriterion("coupon_fee_2 in", values, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2NotIn(List<Integer> values) {
            addCriterion("coupon_fee_2 not in", values, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2Between(Integer value1, Integer value2) {
            addCriterion("coupon_fee_2 between", value1, value2, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee2NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee_2 not between", value1, value2, "couponFee2");
            return (Criteria) this;
        }

        public Criteria andCouponFee3IsNull() {
            addCriterion("coupon_fee_3 is null");
            return (Criteria) this;
        }

        public Criteria andCouponFee3IsNotNull() {
            addCriterion("coupon_fee_3 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFee3EqualTo(Integer value) {
            addCriterion("coupon_fee_3 =", value, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3NotEqualTo(Integer value) {
            addCriterion("coupon_fee_3 <>", value, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3GreaterThan(Integer value) {
            addCriterion("coupon_fee_3 >", value, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_3 >=", value, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3LessThan(Integer value) {
            addCriterion("coupon_fee_3 <", value, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_3 <=", value, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3In(List<Integer> values) {
            addCriterion("coupon_fee_3 in", values, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3NotIn(List<Integer> values) {
            addCriterion("coupon_fee_3 not in", values, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3Between(Integer value1, Integer value2) {
            addCriterion("coupon_fee_3 between", value1, value2, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee3NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee_3 not between", value1, value2, "couponFee3");
            return (Criteria) this;
        }

        public Criteria andCouponFee4IsNull() {
            addCriterion("coupon_fee_4 is null");
            return (Criteria) this;
        }

        public Criteria andCouponFee4IsNotNull() {
            addCriterion("coupon_fee_4 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFee4EqualTo(Integer value) {
            addCriterion("coupon_fee_4 =", value, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4NotEqualTo(Integer value) {
            addCriterion("coupon_fee_4 <>", value, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4GreaterThan(Integer value) {
            addCriterion("coupon_fee_4 >", value, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_4 >=", value, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4LessThan(Integer value) {
            addCriterion("coupon_fee_4 <", value, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_4 <=", value, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4In(List<Integer> values) {
            addCriterion("coupon_fee_4 in", values, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4NotIn(List<Integer> values) {
            addCriterion("coupon_fee_4 not in", values, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4Between(Integer value1, Integer value2) {
            addCriterion("coupon_fee_4 between", value1, value2, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee4NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee_4 not between", value1, value2, "couponFee4");
            return (Criteria) this;
        }

        public Criteria andCouponFee5IsNull() {
            addCriterion("coupon_fee_5 is null");
            return (Criteria) this;
        }

        public Criteria andCouponFee5IsNotNull() {
            addCriterion("coupon_fee_5 is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFee5EqualTo(Integer value) {
            addCriterion("coupon_fee_5 =", value, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5NotEqualTo(Integer value) {
            addCriterion("coupon_fee_5 <>", value, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5GreaterThan(Integer value) {
            addCriterion("coupon_fee_5 >", value, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5GreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_5 >=", value, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5LessThan(Integer value) {
            addCriterion("coupon_fee_5 <", value, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5LessThanOrEqualTo(Integer value) {
            addCriterion("coupon_fee_5 <=", value, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5In(List<Integer> values) {
            addCriterion("coupon_fee_5 in", values, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5NotIn(List<Integer> values) {
            addCriterion("coupon_fee_5 not in", values, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5Between(Integer value1, Integer value2) {
            addCriterion("coupon_fee_5 between", value1, value2, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andCouponFee5NotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_fee_5 not between", value1, value2, "couponFee5");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIsNull() {
            addCriterion("return_msg is null");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIsNotNull() {
            addCriterion("return_msg is not null");
            return (Criteria) this;
        }

        public Criteria andReturnMsgEqualTo(String value) {
            addCriterion("return_msg =", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotEqualTo(String value) {
            addCriterion("return_msg <>", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgGreaterThan(String value) {
            addCriterion("return_msg >", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgGreaterThanOrEqualTo(String value) {
            addCriterion("return_msg >=", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLessThan(String value) {
            addCriterion("return_msg <", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLessThanOrEqualTo(String value) {
            addCriterion("return_msg <=", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgLike(String value) {
            addCriterion("return_msg like", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotLike(String value) {
            addCriterion("return_msg not like", value, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgIn(List<String> values) {
            addCriterion("return_msg in", values, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotIn(List<String> values) {
            addCriterion("return_msg not in", values, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgBetween(String value1, String value2) {
            addCriterion("return_msg between", value1, value2, "returnMsg");
            return (Criteria) this;
        }

        public Criteria andReturnMsgNotBetween(String value1, String value2) {
            addCriterion("return_msg not between", value1, value2, "returnMsg");
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