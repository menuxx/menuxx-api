package com.mall.push;

import java.util.List;

public class PayloadFactory {

    private String appKey;

    private String appSecret;

    public PayloadFactory(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public BroadcastPayload createBroadcast(String msg, String[] topics) {
        return null;
    }

    public EndToEndPayload createEndToEnd(String msg, String alias) {
        return new EndToEndPayload("publish2_to_alias", appKey, appSecret, msg, alias);
    }

    public EndToEndsPayload createEndToEnds(String msg, List<String> aliases) {
        return new EndToEndsPayload("publish_to_alias_batch", appKey, appSecret, msg, aliases);
    }

}
