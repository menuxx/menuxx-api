package com.mall.model;

import java.util.Date;

public class TActivityMinus {
    private Integer id;

    private Integer activityId;

    private String descText;

    private Integer toup;

    private Integer cutback;

    private Date createTime;

    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}