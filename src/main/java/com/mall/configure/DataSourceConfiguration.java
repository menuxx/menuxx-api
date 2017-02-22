package com.mall.configure;

import com.mall.configure.properties.HikariCPConfigureProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

@Configuration
public class DataSourceConfiguration {

    @Autowired
    @NotNull
    HikariCPConfigureProperties hikariConfig;

    /**
     * 创建者：尹昶胜
     * 描述：
     * \@ConfigurationProperties 会自动读取，并解析 application.properties 文件，此处将使用HikariCP作为数据库连接池
     * HikariCP连接池文档 https://github.com/brettwooldridge/HikariCP/
     * @return HikariDataSource
     */
    @Bean(destroyMethod = "close")
    @Order(1000)
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();

        config.setConnectionTestQuery(hikariConfig.getConnectionTestQuery());
        config.setAutoCommit(hikariConfig.isAutoCommit());
        config.setConnectionTimeout(hikariConfig.getConnectionTimeout());
        config.setDriverClassName(hikariConfig.getDriverClassName());

        config.setJdbcUrl(hikariConfig.getDataSourceProperties().getUrl()); // jdbc uri
        config.setUsername(hikariConfig.getDataSourceProperties().getUser());   // jdbc username
        config.setPassword(hikariConfig.getDataSourceProperties().getPassword());   // password
        config.setDataSourceClassName(hikariConfig.getDataSourceClassName());

        config.setInitializationFailFast(hikariConfig.isInitializationFailFast()); //初始化快速失败，提高可靠性
        config.setMaximumPoolSize(hikariConfig.getMaximumPoolSize());
        config.setMaxLifetime(hikariConfig.getMaxLifetime());   // 单个链接最大生存时间
        config.setMinimumIdle(hikariConfig.getMinimumIdle());   // 最少空闲连接数
        config.setIdleTimeout(hikariConfig.getIdleTimeout());   // 空闲连接超时
        config.setValidationTimeout(hikariConfig.getValidationTimeout());

        config.setPoolName(hikariConfig.getPoolName());

        return new HikariDataSource(config);

    }

}
