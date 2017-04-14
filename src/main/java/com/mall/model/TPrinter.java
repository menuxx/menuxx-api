package com.mall.model;

public class TPrinter {
    private Integer id;

    private String macPrefix;

    private String productName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMacPrefix() {
        return macPrefix;
    }

    public void setMacPrefix(String macPrefix) {
        this.macPrefix = macPrefix == null ? null : macPrefix.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }
}