package com.mall.push;

public class PushState {

    private boolean ok;

    private String errorMsg;

    public PushState(boolean ok, String errorMsg) {
        this.ok = ok;
        this.errorMsg = errorMsg;
    }

    public boolean isOk() {
        return ok;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
