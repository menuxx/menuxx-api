package com.mall.push;

public class PushState {

    private boolean ok;

    private String errorMsg;

    private String messageId;

    public PushState(boolean ok, String errorMsg) {
        this.ok = ok;
        this.errorMsg = errorMsg;
    }

    public PushState(boolean ok, String errorMsg, String messageId) {
        this.ok = ok;
        this.errorMsg = errorMsg;
        this.messageId = messageId;
    }

    public boolean isOk() {
        return ok;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
