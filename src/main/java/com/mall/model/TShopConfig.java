package com.mall.model;

import java.util.Date;

public class TShopConfig {
    private Integer id;

    private Integer shopId;

    private Integer vipRecharge;

    private Integer deliveryMinLimit;

    private Integer deliveryNofeeLimit;

    private String bannerImages;

    private Integer packFee;

    private Integer deliveryFee;

    private String alterOrderText;

    private Integer deliveryChannel;

    private Integer deliveryDistance;

    private String businessTimeline;

    private Integer deliveryAuto3rd;

    private String activityNoticeText;

    private Integer ticketStyle;

    private String ticketWxliteQrcode;

    private Date updateTime;

    private Integer couponPolicy;

    private Integer inWork;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getVipRecharge() {
        return vipRecharge;
    }

    public void setVipRecharge(Integer vipRecharge) {
        this.vipRecharge = vipRecharge;
    }

    public Integer getDeliveryMinLimit() {
        return deliveryMinLimit;
    }

    public void setDeliveryMinLimit(Integer deliveryMinLimit) {
        this.deliveryMinLimit = deliveryMinLimit;
    }

    public Integer getDeliveryNofeeLimit() {
        return deliveryNofeeLimit;
    }

    public void setDeliveryNofeeLimit(Integer deliveryNofeeLimit) {
        this.deliveryNofeeLimit = deliveryNofeeLimit;
    }

    public String getBannerImages() {
        return bannerImages;
    }

    public void setBannerImages(String bannerImages) {
        this.bannerImages = bannerImages == null ? null : bannerImages.trim();
    }

    public Integer getPackFee() {
        return packFee;
    }

    public void setPackFee(Integer packFee) {
        this.packFee = packFee;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getAlterOrderText() {
        return alterOrderText;
    }

    public void setAlterOrderText(String alterOrderText) {
        this.alterOrderText = alterOrderText == null ? null : alterOrderText.trim();
    }

    public Integer getDeliveryChannel() {
        return deliveryChannel;
    }

    public void setDeliveryChannel(Integer deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }

    public Integer getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(Integer deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public String getBusinessTimeline() {
        return businessTimeline;
    }

    public void setBusinessTimeline(String businessTimeline) {
        this.businessTimeline = businessTimeline == null ? null : businessTimeline.trim();
    }

    public Integer getDeliveryAuto3rd() {
        return deliveryAuto3rd;
    }

    public void setDeliveryAuto3rd(Integer deliveryAuto3rd) {
        this.deliveryAuto3rd = deliveryAuto3rd;
    }

    public String getActivityNoticeText() {
        return activityNoticeText;
    }

    public void setActivityNoticeText(String activityNoticeText) {
        this.activityNoticeText = activityNoticeText == null ? null : activityNoticeText.trim();
    }

    public Integer getTicketStyle() {
        return ticketStyle;
    }

    public void setTicketStyle(Integer ticketStyle) {
        this.ticketStyle = ticketStyle;
    }

    public String getTicketWxliteQrcode() {
        return ticketWxliteQrcode;
    }

    public void setTicketWxliteQrcode(String ticketWxliteQrcode) {
        this.ticketWxliteQrcode = ticketWxliteQrcode == null ? null : ticketWxliteQrcode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCouponPolicy() {
        return couponPolicy;
    }

    public void setCouponPolicy(Integer couponPolicy) {
        this.couponPolicy = couponPolicy;
    }

    public Integer getInWork() {
        return inWork;
    }

    public void setInWork(Integer inWork) {
        this.inWork = inWork;
    }
}