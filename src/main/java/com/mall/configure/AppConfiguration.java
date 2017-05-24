package com.mall.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * Created by Supeng on 9/10/16.
 */
@Component
@ConfigurationProperties(prefix = "appconfig")
public class AppConfiguration {

    @NestedConfigurationProperty
    private WXComponent wxComponent;

    public static class WXComponent {

        private String appId;

        private String appSecret;

        private String appKey;

        private String token;

        private String encodingAESKey;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getEncodingAESKey() {
            return encodingAESKey;
        }

        public void setEncodingAESKey(String encodingAESKey) {
            this.encodingAESKey = encodingAESKey;
        }
    }

    public WXComponent getWxComponent() {
        return wxComponent;
    }

    public void setWxComponent(WXComponent wxComponent) {
        this.wxComponent = wxComponent;
    }

    private String ipushAppId;

    private String ipushAppKey;

    private String ipushMasterSecret;

    private String ipushUrl;

    private String payNotifyUrl;

    private String transmissionType;

    private String rechargeNotifyUrl;

    private String yunBaPushEntryPointUrl;

    private String yunBaAppKey;

    private String yunBaSecretKey;

    public String getYunBaSecretKey() {
        return yunBaSecretKey;
    }

    public void setYunBaSecretKey(String yunBaSecretKey) {
        this.yunBaSecretKey = yunBaSecretKey;
    }

    public String getYunBaPushEntryPointUrl() {
        return yunBaPushEntryPointUrl;
    }

    public void setYunBaPushEntryPointUrl(String yunBaPushEntryPointUrl) {
        this.yunBaPushEntryPointUrl = yunBaPushEntryPointUrl;
    }

    public String getYunBaAppKey() {
        return yunBaAppKey;
    }

    public void setYunBaAppKey(String yunBaAppKey) {
        this.yunBaAppKey = yunBaAppKey;
    }

    public String getIpushAppId() {
        return ipushAppId;
    }

    public void setIpushAppId(String ipushAppId) {
        this.ipushAppId = ipushAppId;
    }

    public String getIpushAppKey() {
        return ipushAppKey;
    }

    public void setIpushAppKey(String ipushAppKey) {
        this.ipushAppKey = ipushAppKey;
    }

    public String getIpushMasterSecret() {
        return ipushMasterSecret;
    }

    public void setIpushMasterSecret(String ipushMasterSecret) {
        this.ipushMasterSecret = ipushMasterSecret;
    }

    public String getIpushUrl() {
        return ipushUrl;
    }

    public void setIpushUrl(String ipushUrl) {
        this.ipushUrl = ipushUrl;
    }

    public String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        this.payNotifyUrl = payNotifyUrl;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public void setRechargeNotifyUrl(String rechargeNotifyUrl) {
        this.rechargeNotifyUrl = rechargeNotifyUrl;
    }

    public String getRechargeNotifyUrl() {
        return rechargeNotifyUrl;
    }
}
