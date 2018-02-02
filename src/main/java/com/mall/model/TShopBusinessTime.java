package com.mall.model;

public class TShopBusinessTime {
    private Integer id;

    private String timeStartNode;

    private String timeEndNode;

    private Integer weekDay;

    private Integer shopId;

    private Integer online;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeStartNode() {
        return timeStartNode;
    }

    public void setTimeStartNode(String timeStartNode) {
        this.timeStartNode = timeStartNode == null ? null : timeStartNode.trim();
    }

    public String getTimeEndNode() {
        return timeEndNode;
    }

    public void setTimeEndNode(String timeEndNode) {
        this.timeEndNode = timeEndNode == null ? null : timeEndNode.trim();
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}