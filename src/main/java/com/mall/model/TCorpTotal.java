package com.mall.model;

import java.util.Date;

public class TCorpTotal {
    private Integer id;

    private Integer corpId;

    private Date day;

    private Integer incomeTotal;

    private Integer orderTotal;

    private Integer arerage;

    private Integer status;

    private Integer payTotal;

    private Integer rechargeTotal;

    private Date createTime;

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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(Integer incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getArerage() {
        return arerage;
    }

    public void setArerage(Integer arerage) {
        this.arerage = arerage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(Integer payTotal) {
        this.payTotal = payTotal;
    }

    public Integer getRechargeTotal() {
        return rechargeTotal;
    }

    public void setRechargeTotal(Integer rechargeTotal) {
        this.rechargeTotal = rechargeTotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}