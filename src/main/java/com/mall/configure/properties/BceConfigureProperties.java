package com.mall.configure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 时序数据库（Time Series Database，下简称TSDB）
 * 使用百度提供的 TSD
 */
@Configuration
@ConfigurationProperties("bce")
public class BceConfigureProperties {

    private String accessKeyId;

    private String secretAccessKey;

    private String tsdEndpoint;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getTsdEndpoint() {
        return tsdEndpoint;
    }

    public void setTsdEndpoint(String tsdEndpoint) {
        this.tsdEndpoint = tsdEndpoint;
    }
}
