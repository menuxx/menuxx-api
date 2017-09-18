package com.mall.model;

public class TCouponConfig {
    private Integer id;

    private Integer toup;

    private Integer cutback;

    private Float discount;

    private Integer permanent;

    private Integer categoryId;

    private String descText;

    private String name;

    private Integer expirationDay;

    private Integer type;

    private Integer shopId;

    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToup() {
        return toup;
    }

    public void setToup(Integer toup) {
        this.toup = toup;
    }

    public Integer getCutback() {
        return cutback;
    }

    public void setCutback(Integer cutback) {
        this.cutback = cutback;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getPermanent() {
        return permanent;
    }

    public void setPermanent(Integer permanent) {
        this.permanent = permanent;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText == null ? null : descText.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(Integer expirationDay) {
        this.expirationDay = expirationDay;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}