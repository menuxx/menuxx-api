package com.mall.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
@Order(900)
public class HikariCPConfigureProperties {

    /**
     * This is the name of the DataSource class provided by the JDBC driver.
     * Consult the documentation for your specific JDBC driver to get this class name, or see the table below.
     * Note XA data sources are not supported.
     * XA requires a real transaction manager like bitronix.
     * Note that you do not need this property if you are using jdbcUrl for "old-school" DriverManager-based JDBC driver configuration.
     * Default: none
     */
    private String dataSourceClassName;

    /**
     * @alias connectionTestQuery
     * If your driver supports JDBC4 we strongly recommend not setting this property.
     * This is for "legacy" databases that do not support the JDBC4 Connection.isValid() API.
     * This is the query that will be executed just before a connection is given to you from the pool to validate that the connection to the database is still alive.
     * Again, try running the pool without this property, HikariCP will log an error if your driver is not JDBC4 compliant to let you know.
     * Default: none
     */
    private String connectionTestQuery;

    /**
     * This property controls the default auto-commit behavior of connections returned from the pool.
     * It is a boolean value.
     * Default: true
     */
    private boolean autoCommit;

    /**
     * This property controls the maximum number of milliseconds that a client (that's you) will wait for a connection from the pool.
     * If this time is exceeded without a connection becoming available, a SQLException will be thrown.
     * 1000ms is the minimum value.
     * Default: 30000 (30 seconds)
     */
    private int connectionTimeout;

    /**
     * This property controls the maximum amount of time that a connection is allowed to sit idle in the pool.
     * This setting only applies when minimumIdle is defined to be less than maximumPoolSize.
     * Whether a connection is retired as idle or not is subject to a maximum variation of +30 seconds, and average variation of +15 seconds.
     * A connection will never be retired as idle before this timeout.
     * A value of 0 means that idle connections are never removed from the pool.
     * Default: 600000 (10 minutes)
     */
    private int idleTimeout;

    /**
     * This property controls the maximum size that the pool is allowed to reach, including both idle and in-use connections.
     * Basically this value will determine the maximum number of actual connections to the database backend.
     * A reasonable value for this is best determined by your execution environment.
     * When the pool reaches this size, and no idle connections are available, calls to getConnection() will block for up to connectionTimeout milliseconds before timing out.
     * Default: 10
     */
    private int maximumPoolSize;

    /**
     * This property represents a user-defined name for the connection pool and appears mainly in logging and JMX management consoles to identify pools and pool configurations.
     * Default: auto-generated
     */
    private String poolName;

    /**
     * This property controls whether the pool will "fail fast" if the pool cannot be seeded with initial connections successfully.
     * If you want your application to start even when the database is down/unavailable, set this property to false.
     * Default: true
     */
    private boolean initializationFailFast;

    /**
     * HikariCP will attempt to resolve a driver through the DriverManager based solely on the jdbcUrl, but for some older drivers the driverClassName must also be specified.
     * Omit this property unless you get an obvious error message indicating that the driver was not found.
     * Default: none
     */
    private String driverClassName;

    /**
     * This property controls the maximum amount of time that a connection will be tested for aliveness.
     * This value must be less than the connectionTimeout.
     * The lowest accepted validation timeout is 1000ms (1 second).
     * Default: 5000
     */
    private int validationTimeout;

    /**
     * This property controls the maximum lifetime of a connection in the pool.
     * When a connection reaches this timeout it will be retired from the pool, subject to a maximum variation of +30 seconds.
     * An in-use connection will never be retired, only when it is closed will it then be removed.
     * We strongly recommend setting this value, and it should be at least 30 seconds less than any database-level connection timeout.
     * A value of 0 indicates no maximum lifetime (infinite lifetime), subject of course to the idleTimeout setting.
     * Default: 1800000 (30 minutes)
     */
    private int maxLifetime;

    /**
     * This property controls the minimum number of idle connections that HikariCP tries to maintain in the pool.
     * If the idle connections dip below this value, HikariCP will make a best effort to add additional connections quickly and efficiently.
     * However, for maximum performance and responsiveness to spike demands, we recommend not setting this value and instead allowing HikariCP to act as a fixed size connection pool.
     * Default: same as maximumPoolSize
     */
    private int minimumIdle;

    @NestedConfigurationProperty
    private DataSourceProperties dataSourceProperties = new DataSourceProperties();

    public DataSourceProperties getDataSourceProperties() {
        return dataSourceProperties;
    }

    public void setDataSourceProperties(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    public int getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(int maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public int getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(int minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public String getDataSourceClassName() {
        return dataSourceClassName;
    }

    public void setDataSourceClassName(String dataSourceClassName) {
        this.dataSourceClassName = dataSourceClassName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public boolean isInitializationFailFast() {
        return initializationFailFast;
    }

    public void setInitializationFailFast(boolean initializationFailFast) {
        this.initializationFailFast = initializationFailFast;
    }

    public int getValidationTimeout() {
        return validationTimeout;
    }

    public void setValidationTimeout(int validationTimeout) {
        this.validationTimeout = validationTimeout;
    }

    @ConfigurationProperties(prefix = "data-source-properties")
    public class DataSourceProperties {

        private String url;

        private String user;

        private String password;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

}
