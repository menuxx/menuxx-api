package com.mall.model;

public class TConfig {
    private Integer id;

    private String name;

    private Integer value;

    private Integer corpId;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}