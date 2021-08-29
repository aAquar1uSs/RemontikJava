package com.project.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBManager {
    private static DBManager dbManager;

    private DBManager() {

    }

    public static DBManager getInstance() {
        if(dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String url) throws SQLException {
         return DriverManager.getConnection(url);
    }
}
