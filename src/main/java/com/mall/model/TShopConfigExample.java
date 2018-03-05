package com.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TShopConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShopConfigExample() {
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

        public Criteria andVipRechargeIsNull() {
            addCriterion("vip_recharge is null");
            return (Criteria) this;
        }

        public Criteria andVipRechargeIsNotNull() {
            addCriterion("vip_recharge is not null");
            return (Criteria) this;
        }

        public Criteria andVipRechargeEqualTo(Integer value) {
            addCriterion("vip_recharge =", value, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeNotEqualTo(Integer value) {
            addCriterion("vip_recharge <>", value, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeGreaterThan(Integer value) {
            addCriterion("vip_recharge >", value, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_recharge >=", value, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeLessThan(Integer value) {
            addCriterion("vip_recharge <", value, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeLessThanOrEqualTo(Integer value) {
            addCriterion("vip_recharge <=", value, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeIn(List<Integer> values) {
            addCriterion("vip_recharge in", values, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeNotIn(List<Integer> values) {
            addCriterion("vip_recharge not in", values, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeBetween(Integer value1, Integer value2) {
            addCriterion("vip_recharge between", value1, value2, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andVipRechargeNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_recharge not between", value1, value2, "vipRecharge");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitIsNull() {
            addCriterion("delivery_min_limit is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitIsNotNull() {
            addCriterion("delivery_min_limit is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitEqualTo(Integer value) {
            addCriterion("delivery_min_limit =", value, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitNotEqualTo(Integer value) {
            addCriterion("delivery_min_limit <>", value, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitGreaterThan(Integer value) {
            addCriterion("delivery_min_limit >", value, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_min_limit >=", value, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitLessThan(Integer value) {
            addCriterion("delivery_min_limit <", value, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_min_limit <=", value, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitIn(List<Integer> values) {
            addCriterion("delivery_min_limit in", values, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitNotIn(List<Integer> values) {
            addCriterion("delivery_min_limit not in", values, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitBetween(Integer value1, Integer value2) {
            addCriterion("delivery_min_limit between", value1, value2, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryMinLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_min_limit not between", value1, value2, "deliveryMinLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitIsNull() {
            addCriterion("delivery_nofee_limit is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitIsNotNull() {
            addCriterion("delivery_nofee_limit is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitEqualTo(Integer value) {
            addCriterion("delivery_nofee_limit =", value, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitNotEqualTo(Integer value) {
            addCriterion("delivery_nofee_limit <>", value, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitGreaterThan(Integer value) {
            addCriterion("delivery_nofee_limit >", value, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_nofee_limit >=", value, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitLessThan(Integer value) {
            addCriterion("delivery_nofee_limit <", value, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_nofee_limit <=", value, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitIn(List<Integer> values) {
            addCriterion("delivery_nofee_limit in", values, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitNotIn(List<Integer> values) {
            addCriterion("delivery_nofee_limit not in", values, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitBetween(Integer value1, Integer value2) {
            addCriterion("delivery_nofee_limit between", value1, value2, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andDeliveryNofeeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_nofee_limit not between", value1, value2, "deliveryNofeeLimit");
            return (Criteria) this;
        }

        public Criteria andBannerImagesIsNull() {
            addCriterion("banner_images is null");
            return (Criteria) this;
        }

        public Criteria andBannerImagesIsNotNull() {
            addCriterion("banner_images is not null");
            return (Criteria) this;
        }

        public Criteria andBannerImagesEqualTo(String value) {
            addCriterion("banner_images =", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesNotEqualTo(String value) {
            addCriterion("banner_images <>", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesGreaterThan(String value) {
            addCriterion("banner_images >", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesGreaterThanOrEqualTo(String value) {
            addCriterion("banner_images >=", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesLessThan(String value) {
            addCriterion("banner_images <", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesLessThanOrEqualTo(String value) {
            addCriterion("banner_images <=", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesLike(String value) {
            addCriterion("banner_images like", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesNotLike(String value) {
            addCriterion("banner_images not like", value, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesIn(List<String> values) {
            addCriterion("banner_images in", values, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesNotIn(List<String> values) {
            addCriterion("banner_images not in", values, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesBetween(String value1, String value2) {
            addCriterion("banner_images between", value1, value2, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andBannerImagesNotBetween(String value1, String value2) {
            addCriterion("banner_images not between", value1, value2, "bannerImages");
            return (Criteria) this;
        }

        public Criteria andPackFeeIsNull() {
            addCriterion("pack_fee is null");
            return (Criteria) this;
        }

        public Criteria andPackFeeIsNotNull() {
            addCriterion("pack_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPackFeeEqualTo(Integer value) {
            addCriterion("pack_fee =", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeNotEqualTo(Integer value) {
            addCriterion("pack_fee <>", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeGreaterThan(Integer value) {
            addCriterion("pack_fee >", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pack_fee >=", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeLessThan(Integer value) {
            addCriterion("pack_fee <", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeLessThanOrEqualTo(Integer value) {
            addCriterion("pack_fee <=", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeIn(List<Integer> values) {
            addCriterion("pack_fee in", values, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeNotIn(List<Integer> values) {
            addCriterion("pack_fee not in", values, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeBetween(Integer value1, Integer value2) {
            addCriterion("pack_fee between", value1, value2, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("pack_fee not between", value1, value2, "packFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNull() {
            addCriterion("delivery_fee is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNotNull() {
            addCriterion("delivery_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeEqualTo(Integer value) {
            addCriterion("delivery_fee =", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotEqualTo(Integer value) {
            addCriterion("delivery_fee <>", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThan(Integer value) {
            addCriterion("delivery_fee >", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_fee >=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThan(Integer value) {
            addCriterion("delivery_fee <", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_fee <=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIn(List<Integer> values) {
            addCriterion("delivery_fee in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotIn(List<Integer> values) {
            addCriterion("delivery_fee not in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeBetween(Integer value1, Integer value2) {
            addCriterion("delivery_fee between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_fee not between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextIsNull() {
            addCriterion("alter_order_text is null");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextIsNotNull() {
            addCriterion("alter_order_text is not null");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextEqualTo(String value) {
            addCriterion("alter_order_text =", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextNotEqualTo(String value) {
            addCriterion("alter_order_text <>", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextGreaterThan(String value) {
            addCriterion("alter_order_text >", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextGreaterThanOrEqualTo(String value) {
            addCriterion("alter_order_text >=", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextLessThan(String value) {
            addCriterion("alter_order_text <", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextLessThanOrEqualTo(String value) {
            addCriterion("alter_order_text <=", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextLike(String value) {
            addCriterion("alter_order_text like", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextNotLike(String value) {
            addCriterion("alter_order_text not like", value, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextIn(List<String> values) {
            addCriterion("alter_order_text in", values, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextNotIn(List<String> values) {
            addCriterion("alter_order_text not in", values, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextBetween(String value1, String value2) {
            addCriterion("alter_order_text between", value1, value2, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andAlterOrderTextNotBetween(String value1, String value2) {
            addCriterion("alter_order_text not between", value1, value2, "alterOrderText");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelIsNull() {
            addCriterion("delivery_channel is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelIsNotNull() {
            addCriterion("delivery_channel is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelEqualTo(Integer value) {
            addCriterion("delivery_channel =", value, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelNotEqualTo(Integer value) {
            addCriterion("delivery_channel <>", value, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelGreaterThan(Integer value) {
            addCriterion("delivery_channel >", value, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_channel >=", value, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelLessThan(Integer value) {
            addCriterion("delivery_channel <", value, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_channel <=", value, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelIn(List<Integer> values) {
            addCriterion("delivery_channel in", values, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelNotIn(List<Integer> values) {
            addCriterion("delivery_channel not in", values, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelBetween(Integer value1, Integer value2) {
            addCriterion("delivery_channel between", value1, value2, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_channel not between", value1, value2, "deliveryChannel");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceIsNull() {
            addCriterion("delivery_distance is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceIsNotNull() {
            addCriterion("delivery_distance is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceEqualTo(Integer value) {
            addCriterion("delivery_distance =", value, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceNotEqualTo(Integer value) {
            addCriterion("delivery_distance <>", value, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceGreaterThan(Integer value) {
            addCriterion("delivery_distance >", value, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_distance >=", value, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceLessThan(Integer value) {
            addCriterion("delivery_distance <", value, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_distance <=", value, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceIn(List<Integer> values) {
            addCriterion("delivery_distance in", values, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceNotIn(List<Integer> values) {
            addCriterion("delivery_distance not in", values, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceBetween(Integer value1, Integer value2) {
            addCriterion("delivery_distance between", value1, value2, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_distance not between", value1, value2, "deliveryDistance");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineIsNull() {
            addCriterion("business_timeline is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineIsNotNull() {
            addCriterion("business_timeline is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineEqualTo(String value) {
            addCriterion("business_timeline =", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineNotEqualTo(String value) {
            addCriterion("business_timeline <>", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineGreaterThan(String value) {
            addCriterion("business_timeline >", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineGreaterThanOrEqualTo(String value) {
            addCriterion("business_timeline >=", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineLessThan(String value) {
            addCriterion("business_timeline <", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineLessThanOrEqualTo(String value) {
            addCriterion("business_timeline <=", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineLike(String value) {
            addCriterion("business_timeline like", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineNotLike(String value) {
            addCriterion("business_timeline not like", value, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineIn(List<String> values) {
            addCriterion("business_timeline in", values, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineNotIn(List<String> values) {
            addCriterion("business_timeline not in", values, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineBetween(String value1, String value2) {
            addCriterion("business_timeline between", value1, value2, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andBusinessTimelineNotBetween(String value1, String value2) {
            addCriterion("business_timeline not between", value1, value2, "businessTimeline");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdIsNull() {
            addCriterion("delivery_auto_3rd is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdIsNotNull() {
            addCriterion("delivery_auto_3rd is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdEqualTo(Integer value) {
            addCriterion("delivery_auto_3rd =", value, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdNotEqualTo(Integer value) {
            addCriterion("delivery_auto_3rd <>", value, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdGreaterThan(Integer value) {
            addCriterion("delivery_auto_3rd >", value, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_auto_3rd >=", value, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdLessThan(Integer value) {
            addCriterion("delivery_auto_3rd <", value, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_auto_3rd <=", value, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdIn(List<Integer> values) {
            addCriterion("delivery_auto_3rd in", values, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdNotIn(List<Integer> values) {
            addCriterion("delivery_auto_3rd not in", values, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdBetween(Integer value1, Integer value2) {
            addCriterion("delivery_auto_3rd between", value1, value2, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andDeliveryAuto3rdNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_auto_3rd not between", value1, value2, "deliveryAuto3rd");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextIsNull() {
            addCriterion("activity_notice_text is null");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextIsNotNull() {
            addCriterion("activity_notice_text is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextEqualTo(String value) {
            addCriterion("activity_notice_text =", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextNotEqualTo(String value) {
            addCriterion("activity_notice_text <>", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextGreaterThan(String value) {
            addCriterion("activity_notice_text >", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextGreaterThanOrEqualTo(String value) {
            addCriterion("activity_notice_text >=", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextLessThan(String value) {
            addCriterion("activity_notice_text <", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextLessThanOrEqualTo(String value) {
            addCriterion("activity_notice_text <=", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextLike(String value) {
            addCriterion("activity_notice_text like", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextNotLike(String value) {
            addCriterion("activity_notice_text not like", value, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextIn(List<String> values) {
            addCriterion("activity_notice_text in", values, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextNotIn(List<String> values) {
            addCriterion("activity_notice_text not in", values, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextBetween(String value1, String value2) {
            addCriterion("activity_notice_text between", value1, value2, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andActivityNoticeTextNotBetween(String value1, String value2) {
            addCriterion("activity_notice_text not between", value1, value2, "activityNoticeText");
            return (Criteria) this;
        }

        public Criteria andTicketStyleIsNull() {
            addCriterion("ticket_style is null");
            return (Criteria) this;
        }

        public Criteria andTicketStyleIsNotNull() {
            addCriterion("ticket_style is not null");
            return (Criteria) this;
        }

        public Criteria andTicketStyleEqualTo(Integer value) {
            addCriterion("ticket_style =", value, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleNotEqualTo(Integer value) {
            addCriterion("ticket_style <>", value, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleGreaterThan(Integer value) {
            addCriterion("ticket_style >", value, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_style >=", value, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleLessThan(Integer value) {
            addCriterion("ticket_style <", value, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_style <=", value, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleIn(List<Integer> values) {
            addCriterion("ticket_style in", values, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleNotIn(List<Integer> values) {
            addCriterion("ticket_style not in", values, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleBetween(Integer value1, Integer value2) {
            addCriterion("ticket_style between", value1, value2, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketStyleNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_style not between", value1, value2, "ticketStyle");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeIsNull() {
            addCriterion("ticket_wxlite_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeIsNotNull() {
            addCriterion("ticket_wxlite_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeEqualTo(String value) {
            addCriterion("ticket_wxlite_qrcode =", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeNotEqualTo(String value) {
            addCriterion("ticket_wxlite_qrcode <>", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeGreaterThan(String value) {
            addCriterion("ticket_wxlite_qrcode >", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_wxlite_qrcode >=", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeLessThan(String value) {
            addCriterion("ticket_wxlite_qrcode <", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeLessThanOrEqualTo(String value) {
            addCriterion("ticket_wxlite_qrcode <=", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeLike(String value) {
            addCriterion("ticket_wxlite_qrcode like", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeNotLike(String value) {
            addCriterion("ticket_wxlite_qrcode not like", value, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeIn(List<String> values) {
            addCriterion("ticket_wxlite_qrcode in", values, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeNotIn(List<String> values) {
            addCriterion("ticket_wxlite_qrcode not in", values, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeBetween(String value1, String value2) {
            addCriterion("ticket_wxlite_qrcode between", value1, value2, "ticketWxliteQrcode");
            return (Criteria) this;
        }

        public Criteria andTicketWxliteQrcodeNotBetween(String value1, String value2) {
            addCriterion("ticket_wxlite_qrcode not between", value1, value2, "ticketWxliteQrcode");
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

        public Criteria andCouponPolicyIsNull() {
            addCriterion("coupon_policy is null");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyIsNotNull() {
            addCriterion("coupon_policy is not null");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyEqualTo(Integer value) {
            addCriterion("coupon_policy =", value, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyNotEqualTo(Integer value) {
            addCriterion("coupon_policy <>", value, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyGreaterThan(Integer value) {
            addCriterion("coupon_policy >", value, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_policy >=", value, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyLessThan(Integer value) {
            addCriterion("coupon_policy <", value, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_policy <=", value, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyIn(List<Integer> values) {
            addCriterion("coupon_policy in", values, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyNotIn(List<Integer> values) {
            addCriterion("coupon_policy not in", values, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyBetween(Integer value1, Integer value2) {
            addCriterion("coupon_policy between", value1, value2, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andCouponPolicyNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_policy not between", value1, value2, "couponPolicy");
            return (Criteria) this;
        }

        public Criteria andInWorkIsNull() {
            addCriterion("in_work is null");
            return (Criteria) this;
        }

        public Criteria andInWorkIsNotNull() {
            addCriterion("in_work is not null");
            return (Criteria) this;
        }

        public Criteria andInWorkEqualTo(Integer value) {
            addCriterion("in_work =", value, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkNotEqualTo(Integer value) {
            addCriterion("in_work <>", value, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkGreaterThan(Integer value) {
            addCriterion("in_work >", value, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_work >=", value, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkLessThan(Integer value) {
            addCriterion("in_work <", value, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkLessThanOrEqualTo(Integer value) {
            addCriterion("in_work <=", value, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkIn(List<Integer> values) {
            addCriterion("in_work in", values, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkNotIn(List<Integer> values) {
            addCriterion("in_work not in", values, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkBetween(Integer value1, Integer value2) {
            addCriterion("in_work between", value1, value2, "inWork");
            return (Criteria) this;
        }

        public Criteria andInWorkNotBetween(Integer value1, Integer value2) {
            addCriterion("in_work not between", value1, value2, "inWork");
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