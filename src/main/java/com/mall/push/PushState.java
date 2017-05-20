package com.mall.push;

import java.util.Map;

public class PushState {

    // 发送成功
    // {"status":0, "messageId": "<message-id>"
    public static final int SUCCESS = 0;

    // 参数错误
    // {"status":1, "error": "invalid parameters"}
    public static final int PARAMTERS_INVALID = 1;

    // 内部服务错误
    // {"status":2, "error": "internal server"}
    public static final int INTERNAL_SERVER = 2;

    // 没有应用
    // {"status":3}
    public static final int NOT_APP = 3;

    // 超时
    // {"status":4, "error": "timeout"}
    public static final int TIMEOUT = 4;

    // 没有找到 Alias
    // {"status":5, "alias":"567a4a754407a3cd028aaf6b-test", "error": "alias not found"}
    public static final int NOT_EXISTS_ALIAS = 5;

    private int status;

    private String error;

    private String alias;

    private String messageId;

    private Map<String, String> results;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
