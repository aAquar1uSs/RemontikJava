package com.project.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class WrapperConnector {
    private static final Logger LOGGER = Logger.getLogger(WrapperConnector.class.getName());
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

    private static void readPropertiesFile() {
        Properties properties = new Properties();

        try(InputStream inputStream = Files.newInputStream(Paths.get("database.properties"))){
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }

        driverClassName = properties.getProperty("jdbc.driverClassName");
        jdbcUrl = properties.getProperty("jdbc.url");
        jdbcUsername = properties.getProperty("jdbc.username");
        jdbcPassword = properties.getProperty("jdbc.password");

    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        readPropertiesFile();
        Class.forName(driverClassName);
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    public void close(AutoCloseable object) {
        if(object != null) {
            try {
                object.close();
            } catch (Exception e) {
                LOGGER.debug(e.getMessage());
            }
        }
    }



}
