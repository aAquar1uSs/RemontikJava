package com.project.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager dbManager;

    private DBManager() {

    }

    public static DBManager getInstance() {
        if(dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String url) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection("jdbc:mysql://root@127.0.0.1:3306/repair_shopdb","root",
                 "SanyaFrank111");
    }
}
