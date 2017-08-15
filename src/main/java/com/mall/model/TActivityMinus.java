package com.mall.model;

import java.util.Date;

public class TActivityMinus {
    private Integer id;

    private String descText;

    private Integer toup;

    private Integer cutback;

    private Integer corpId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText == null ? null : descText.trim();
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

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}