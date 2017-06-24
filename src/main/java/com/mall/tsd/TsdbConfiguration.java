package com.mall.tsd;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.tsdb.TsdbClient;
import com.mall.configure.properties.BceConfigureProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TsdbConfiguration {

    @Autowired
    BceConfigureProperties bceConfig;

    /**
     * docs: https://cloud.baidu.com/doc/TSDB/Java-SDK.html#.E5.88.9B.E5.BB.BATsdbClient
     * BceClientConfiguration中有更多的配置项，可配置如下参数：
     *
     * 参数	说明
     * connectionTimeoutInMillis	建立连接的超时时间（单位：毫秒）
     * localAddress	本地地址
     * maxConnections	允许打开的最大HTTP连接数
     * protocol	连接协议类型
     * proxyDomain	访问NTLM验证的代理服务器的Windows域名
     * proxyHost	代理服务器主机地址
     * proxyPassword	代理服务器验证的密码
     * proxyPort	代理服务器端口
     * proxyPreemptiveAuthenticationEnabled	是否设置用户代理认证
     * proxyUsername	代理服务器验证的用户名
     * proxyWorkstation	NTLM代理服务器的Windows工作站名称
     * retryPolicy	连接重试策略
     * socketBufferSizeInBytes	Socket缓冲区大小
     * socketTimeoutInMillis	通过打开的连接传输数据的超时时间（单位：毫秒）
     * userAgent	用户代理，指HTTP的User-Agent头
     * @return
     */
    private BceClientConfiguration bceClientConfig() {
        BceClientConfiguration config = new BceClientConfiguration()
                .withCredentials(new DefaultBceCredentials(bceConfig.getAccessKeyId(), bceConfig.getSecretAccessKey()))
                .withEndpoint(bceConfig.getTsdEndpoint());
        return config;
    }

    public TsdbClient tsdbClient() {
        return new TsdbClient(bceClientConfig());
    }

}
