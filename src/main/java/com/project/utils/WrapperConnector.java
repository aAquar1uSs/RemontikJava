package com.project.utils;

import com.project.constants.SqlConstants;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;



public class WrapperConnector {
    private static WrapperConnector wrapperConnector;
    private static String driverClassName;
    private static String jdbcUrl;
    private static String jdbcUsername;
    private static String jdbcPassword;

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

        try(InputStream inputStream = Files.newInputStream((Path) this.getClass().getResourceAsStream("resources/database.properties"))){
            connectionProperties.load(inputStream);
        } catch (IOException e) {
            e.getMessage();
        }


        driverClassName = connectionProperties.getProperty("jdbc.driverClassName");
        jdbcUrl = connectionProperties.getProperty("jdbc.url");
        jdbcUsername = connectionProperties.getProperty("jdbc.username");
        jdbcPassword = connectionProperties.getProperty("jdbc.password");

    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

       // readPropertiesFile();
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(SqlConstants.URL_CONNECT_TO_DB);
    }

    public  void close(AutoCloseable object) {
        if(object != null) {
            try {
                object.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }



}
