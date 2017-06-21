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
}
