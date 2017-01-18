package com.mall.model;

import java.util.Date;

public class TAddress {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.user_id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.phone
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.region
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private String region;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.defaulted
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private Integer defaulted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.consignee
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private String consignee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.region_id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private Integer regionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.status
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_address.create_time
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.id
     *
     * @return the value of t_address.id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.id
     *
     * @param id the value for t_address.id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.user_id
     *
     * @return the value of t_address.user_id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.user_id
     *
     * @param userId the value for t_address.user_id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.phone
     *
     * @return the value of t_address.phone
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.phone
     *
     * @param phone the value for t_address.phone
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.region
     *
     * @return the value of t_address.region
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.region
     *
     * @param region the value for t_address.region
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.address
     *
     * @return the value of t_address.address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.address
     *
     * @param address the value for t_address.address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.defaulted
     *
     * @return the value of t_address.defaulted
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public Integer getDefaulted() {
        return defaulted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.defaulted
     *
     * @param defaulted the value for t_address.defaulted
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setDefaulted(Integer defaulted) {
        this.defaulted = defaulted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.consignee
     *
     * @return the value of t_address.consignee
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.consignee
     *
     * @param consignee the value for t_address.consignee
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.region_id
     *
     * @return the value of t_address.region_id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.region_id
     *
     * @param regionId the value for t_address.region_id
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.status
     *
     * @return the value of t_address.status
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.status
     *
     * @param status the value for t_address.status
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_address.create_time
     *
     * @return the value of t_address.create_time
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_address.create_time
     *
     * @param createTime the value for t_address.create_time
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}