package com.mall.configure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "push")
public class PushConfigProperties {

    private Long xingeAccessId;

    private String xingeSecretKey;

    private String getuiPushUrl;

    private String getuiAppId;

    private String getuiAppKey;

    private String getuiMasterSecret;

    private String alipushAccessKeyId;

    private Long alipushAppkey;

    private String alipushAccessKeySecret;

    private String baidupushApiKey;

    private String baidupushSecretKey;

    public Long getXingeAccessId() {
        return xingeAccessId;
    }

    public void setXingeAccessId(Long xingeAccessId) {
        this.xingeAccessId = xingeAccessId;
    }

    public String getXingeSecretKey() {
        return xingeSecretKey;
    }

    public void setXingeSecretKey(String xingeSecretKey) {
        this.xingeSecretKey = xingeSecretKey;
    }

    public String getGetuiPushUrl() {
        return getuiPushUrl;
    }

    public void setGetuiPushUrl(String getuiPushUrl) {
        this.getuiPushUrl = getuiPushUrl;
    }

    public String getGetuiMasterSecret() {
        return getuiMasterSecret;
    }

    public void setGetuiMasterSecret(String getuiMasterSecret) {
        this.getuiMasterSecret = getuiMasterSecret;
    }

    public String getGetuiAppId() {
        return getuiAppId;
    }

    public void setGetuiAppId(String getuiAppId) {
        this.getuiAppId = getuiAppId;
    }

    public String getGetuiAppKey() {
        return getuiAppKey;
    }

    public void setGetuiAppKey(String getuiAppKey) {
        this.getuiAppKey = getuiAppKey;
    }

    public String getAlipushAccessKeyId() {
        return alipushAccessKeyId;
    }

    public void setAlipushAccessKeyId(String alipushAccessKeyId) {
        this.alipushAccessKeyId = alipushAccessKeyId;
    }

    public Long getAlipushAppkey() {
        return alipushAppkey;
    }

    public void setAlipushAppkey(Long alipushAppkey) {
        this.alipushAppkey = alipushAppkey;
    }

    public String getAlipushAccessKeySecret() {
        return alipushAccessKeySecret;
    }

    public void setAlipushAccessKeySecret(String alipushAccessKeySecret) {
        this.alipushAccessKeySecret = alipushAccessKeySecret;
    }

    public String getBaidupushApiKey() {
        return baidupushApiKey;
    }

    public void setBaidupushApiKey(String baidupushApiKey) {
        this.baidupushApiKey = baidupushApiKey;
    }

    public String getBaidupushSecretKey() {
        return baidupushSecretKey;
    }

    public void setBaidupushSecretKey(String baidupushSecretKey) {
        this.baidupushSecretKey = baidupushSecretKey;
    }
}
