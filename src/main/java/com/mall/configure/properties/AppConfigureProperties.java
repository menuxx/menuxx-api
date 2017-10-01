package com.mall.configure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "appconfig")
public class AppConfigureProperties {

    @NestedConfigurationProperty
    private WXComponent wxComponent;

    public static class WXComponent {

        private String appId;

        private String appSecret;

        private String appKey;

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
