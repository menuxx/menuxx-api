package com.mall.model;

public class TFeiePrinter {
    private Integer id;

    private String printerCode;

    private String printerSn;

    private String printerKey;

    private Integer shopId;

    private String simCardCode;

    private String bindUser;

    private String mark;

    private Integer scope;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrinterCode() {
        return printerCode;
    }

    public void setPrinterCode(String printerCode) {
        this.printerCode = printerCode == null ? null : printerCode.trim();
    }

    public String getPrinterSn() {
        return printerSn;
    }

    public void setPrinterSn(String printerSn) {
        this.printerSn = printerSn == null ? null : printerSn.trim();
    }

    public String getPrinterKey() {
        return printerKey;
    }

    public void setPrinterKey(String printerKey) {
        this.printerKey = printerKey == null ? null : printerKey.trim();
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getSimCardCode() {
        return simCardCode;
    }

    public void setSimCardCode(String simCardCode) {
        this.simCardCode = simCardCode == null ? null : simCardCode.trim();
    }

    public String getBindUser() {
        return bindUser;
    }

    public void setBindUser(String bindUser) {
        this.bindUser = bindUser == null ? null : bindUser.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
}