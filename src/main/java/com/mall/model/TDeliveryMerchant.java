package com.mall.model;

import java.math.BigDecimal;

public class TDeliveryMerchant {

    private Integer id;

    private Integer shopId;

    private String shopName;

    private Integer shopType;

    private String cityName;

    private String dadaCityCode;

    private String areaName;

    private String shopAddress;

    private BigDecimal lng;

    private BigDecimal lat;

    private String contactName;

    private String contactPhone;

    private String shopNo;

    private String imdadaUsername;

    private String imdadaPassword;

    private String eleAppId;

    private Integer dadaMerchantId;

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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getDadaCityCode() {
        return dadaCityCode;
    }

    public void setDadaCityCode(String dadaCityCode) {
        this.dadaCityCode = dadaCityCode == null ? null : dadaCityCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public String getImdadaUsername() {
        return imdadaUsername;
    }

    public void setImdadaUsername(String imdadaUsername) {
        this.imdadaUsername = imdadaUsername == null ? null : imdadaUsername.trim();
    }

    public String getImdadaPassword() {
        return imdadaPassword;
    }

    public void setImdadaPassword(String imdadaPassword) {
        this.imdadaPassword = imdadaPassword == null ? null : imdadaPassword.trim();
    }

    public String getEleAppId() {
        return eleAppId;
    }

    public void setEleAppId(String eleAppId) {
        this.eleAppId = eleAppId == null ? null : eleAppId.trim();
    }

    public Integer getDadaMerchantId() {
        return dadaMerchantId;
    }

    public void setDadaMerchantId(Integer dadaMerchantId) {
        this.dadaMerchantId = dadaMerchantId;
    }
}