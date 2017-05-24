package com.mall.weixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mall.exception.WXErrorMsg;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WXCodeSession extends WXErrorMsg {

        private String openid;

        private String sessionKey;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getSessionKey() {
            if (sessionKey == null) {
                sessionKey = "session_key";
            }
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }
}

