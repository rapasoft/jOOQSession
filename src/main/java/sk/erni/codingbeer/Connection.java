package sk.erni.codingbeer;

import lombok.SneakyThrows;
import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Pavol Rajzak, www.rapasoft.eu
 */
public enum Connection {

    INSTANCE;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String JDBC_URL = "url";
    private static final String DRIVER_CLASS = "driver";

    private final DataSource dataSource;

    @SneakyThrows
    public java.sql.Connection getConnection() {
        return dataSource.getConnection();
    }

    @SneakyThrows
    private Connection() {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("database.properties"));

        String userName = properties.getProperty(USERNAME);
        String password = properties.getProperty(PASSWORD);
        String url = properties.getProperty(JDBC_URL);

        Class.forName(properties.getProperty(DRIVER_CLASS)).newInstance();
        dataSource = setupDataSource(url, userName, password);
    }

    private DataSource setupDataSource(String connectURI, String userName, String password) {
        ConnectionFactory connectionFactory =
                new DriverManagerConnectionFactory(connectURI, userName, password);

        PoolableConnectionFactory poolableConnectionFactory =
                new PoolableConnectionFactory(connectionFactory, null);

        ObjectPool<PoolableConnection> connectionPool =
                new GenericObjectPool<>(poolableConnectionFactory);

        poolableConnectionFactory.setPool(connectionPool);

        return new PoolingDataSource<>(connectionPool);
    }

}
