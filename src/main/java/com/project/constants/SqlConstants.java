package com.project.constants;

public class SqlConstants {
    private static final String URL_CONNECT_TO_DB = "jdbc:mysql://localhost:3306/repair_shopdb?user=root&password=SanyaFrank111";

    public static final String SQL_INSERT_NEW_USER = "INSERT INTO users (firstname,secondname,email,password) VALUES (?, ?, ?,?)";

    public static String getUrlConnectToDb() {
        return URL_CONNECT_TO_DB;
    }
}
