package com.project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class WrapperConnector {
    private static WrapperConnector wrapperConnector;
    private String driverClassName;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    private WrapperConnector() {

    }

    public static WrapperConnector getInstance() {
        if (wrapperConnector == null) {
            wrapperConnector = new WrapperConnector();
        }
        return wrapperConnector;
    }

    private void readPropertiesFile() {
        Properties connectionProperties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\Project\\FinalProjectForEpam\\src\\main\\resources\\database.properties");
            connectionProperties.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }

        driverClassName = connectionProperties.getProperty("jdbc.driverClassName");
        jdbcUrl = connectionProperties.getProperty("jdbc.url");
        jdbcUsername = connectionProperties.getProperty("jdbc.username");
        jdbcPassword = connectionProperties.getProperty("jdbc.password");
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        readPropertiesFile();
        Class.forName(driverClassName);
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    public void close(AutoCloseable object) {
        if (object != null) {
            try {
                object.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public static void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }
}
