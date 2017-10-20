package com.mall.model;

import java.util.Date;

public class TTable {
    private Integer id;

    private Integer corpId;

    private String tableName;

    private Integer sortId;

    private Date createTime;

    private Integer status;

    private String wxQrcodeUrl;

    private String wxQrcodeData;

    private String wxQrcodePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWxQrcodeUrl() {
        return wxQrcodeUrl;
    }

    public void setWxQrcodeUrl(String wxQrcodeUrl) {
        this.wxQrcodeUrl = wxQrcodeUrl == null ? null : wxQrcodeUrl.trim();
    }

    public String getWxQrcodeData() {
        return wxQrcodeData;
    }

    public void setWxQrcodeData(String wxQrcodeData) {
        this.wxQrcodeData = wxQrcodeData == null ? null : wxQrcodeData.trim();
    }

    public String getWxQrcodePath() {
        return wxQrcodePath;
    }

    public void setWxQrcodePath(String wxQrcodePath) {
        this.wxQrcodePath = wxQrcodePath == null ? null : wxQrcodePath.trim();
    }
}