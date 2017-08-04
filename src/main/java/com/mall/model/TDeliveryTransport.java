package com.mall.model;

import java.math.BigDecimal;
import java.util.Date;

public class TDeliveryTransport {
    private Integer id;

    private Integer shopId;

    private String orderNo;

    private Integer transportChannel;

    private String receiverAddress;

    private String receiverName;

    private String receiverTel;

    private BigDecimal receiverLat;

    private BigDecimal receiverLng;

    private Integer status;

    private Integer orderTotalAmount;

    private Double orderWeight;

    private String orderRemark;

    private String goodsRemark;

    private Integer goodsCount;

    private Byte isInvoiced;

    private String invoice;

    private Date requireReceiveTime;

    private Integer transportFee;

    private Integer transportTips;

    private Long transportDistance;

    private Date createTime;

    private String cancelReason;

    private String errorMsg;

    private Date updateTime;

    private String transporterName;

    private String transporterTel;

    private String transporterNo;

    private Date acceptTime;

    private Date finishTime;

    private Date fetchTime;

    private Date cancelTime;

    private Date expireTime;

    private Date resendTime;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getTransportChannel() {
        return transportChannel;
    }

    public void setTransportChannel(Integer transportChannel) {
        this.transportChannel = transportChannel;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel == null ? null : receiverTel.trim();
    }

    public BigDecimal getReceiverLat() {
        return receiverLat;
    }

    public void setReceiverLat(BigDecimal receiverLat) {
        this.receiverLat = receiverLat;
    }

    public BigDecimal getReceiverLng() {
        return receiverLng;
    }

    public void setReceiverLng(BigDecimal receiverLng) {
        this.receiverLng = receiverLng;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Integer orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Double getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(Double orderWeight) {
        this.orderWeight = orderWeight;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark == null ? null : goodsRemark.trim();
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Byte getIsInvoiced() {
        return isInvoiced;
    }

    public void setIsInvoiced(Byte isInvoiced) {
        this.isInvoiced = isInvoiced;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public Date getRequireReceiveTime() {
        return requireReceiveTime;
    }

    public void setRequireReceiveTime(Date requireReceiveTime) {
        this.requireReceiveTime = requireReceiveTime;
    }

    public Integer getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(Integer transportFee) {
        this.transportFee = transportFee;
    }

    public Integer getTransportTips() {
        return transportTips;
    }

    public void setTransportTips(Integer transportTips) {
        this.transportTips = transportTips;
    }

    public Long getTransportDistance() {
        return transportDistance;
    }

    public void setTransportDistance(Long transportDistance) {
        this.transportDistance = transportDistance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName == null ? null : transporterName.trim();
    }

    public String getTransporterTel() {
        return transporterTel;
    }

    public void setTransporterTel(String transporterTel) {
        this.transporterTel = transporterTel == null ? null : transporterTel.trim();
    }

    public String getTransporterNo() {
        return transporterNo;
    }

    public void setTransporterNo(String transporterNo) {
        this.transporterNo = transporterNo == null ? null : transporterNo.trim();
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getResendTime() {
        return resendTime;
    }

    public void setResendTime(Date resendTime) {
        this.resendTime = resendTime;
    }
}