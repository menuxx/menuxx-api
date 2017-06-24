package com.mall.utils;

import com.mall.push.PushState;
import com.mall.push.pusher.GeTuiPusher;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetuiPusherTest {

    @Test
    public void test1() {
        GeTuiPusher pusher = new GeTuiPusher(
                "http://sdk.open.api.igexin.com/apiex.htm",
                "HfjIXkSa678sZItfbXS9h1",
                "wzPc6cj0C58imrFxwydQZ",
                "IzWWccEz3K9ZxpMbepUEL4",
                true
        );
        pusher.initialize();
        Map<String, Object> opts = new HashMap<>();
        opts.putAll(pusher.getDefaultOpts(opts));
        PushState state = pusher.pushToDevice("f5ab3d845967a74bcbb764f665fbd1d3", "wdu39ym983mvm34v", opts);
        System.out.println(state.getErrorMsg());
    }

}
