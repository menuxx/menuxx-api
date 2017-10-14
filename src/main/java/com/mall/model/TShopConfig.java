package com.mall.model;

import java.util.Date;

public class TShopConfig {
    private Integer id;

    private Integer shopId;

    private Integer vipRecharge;

    private Integer deliveryMinLimit;

    private Integer deliveryNofeeLimit;

    private Integer packFee;

    private Integer deliveryFee;

    private String alterOrderText;

    private Integer deliveryChannel;

    private String businessTimeline;

    private Integer transportAuto3rd;

    private String activityNoticeText;

    private Integer ticketStyle;

    private String ticketWxliteQrcode;

    private Date updateTime;

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

    public String getBusinessTimeline() {
        return businessTimeline;
    }

    public void setBusinessTimeline(String businessTimeline) {
        this.businessTimeline = businessTimeline == null ? null : businessTimeline.trim();
    }

    public Integer getTransportAuto3rd() {
        return transportAuto3rd;
    }

    public void setTransportAuto3rd(Integer transportAuto3rd) {
        this.transportAuto3rd = transportAuto3rd;
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
}