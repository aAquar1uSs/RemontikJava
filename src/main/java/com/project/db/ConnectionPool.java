package com.project.db;

import com.project.constants.SqlConstants;

import java.sql.*;
import org.apache.log4j.Logger;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool connectionPool;

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(SqlConstants.getUrlConnectToDb());
    }



}
