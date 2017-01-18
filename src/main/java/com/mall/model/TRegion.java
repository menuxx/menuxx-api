package com.mall.model;

public class TRegion {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.id
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.postcode
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private String postcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.region_name
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private String regionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.parent_id
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.level
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.show_name
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private String showName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_region.shortname
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    private String shortname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.id
     *
     * @return the value of t_region.id
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.id
     *
     * @param id the value for t_region.id
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.postcode
     *
     * @return the value of t_region.postcode
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.postcode
     *
     * @param postcode the value for t_region.postcode
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.region_name
     *
     * @return the value of t_region.region_name
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.region_name
     *
     * @param regionName the value for t_region.region_name
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.parent_id
     *
     * @return the value of t_region.parent_id
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.parent_id
     *
     * @param parentId the value for t_region.parent_id
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.level
     *
     * @return the value of t_region.level
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.level
     *
     * @param level the value for t_region.level
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.show_name
     *
     * @return the value of t_region.show_name
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public String getShowName() {
        return showName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.show_name
     *
     * @param showName the value for t_region.show_name
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_region.shortname
     *
     * @return the value of t_region.shortname
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_region.shortname
     *
     * @param shortname the value for t_region.shortname
     *
     * @mbggenerated Tue Jan 17 16:14:07 CST 2017
     */
    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }
}