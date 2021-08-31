package com.project.constants;

public class SqlConstants {
    //private static final String URL_CONNECT_TO_DB = "jdbc:mysql://localhost:3306/repair_shopdb?user=root&password=SanyaFrank111";

    public static final String SQL_INSERT_NEW_USER = "INSERT INTO users (firstname,secondname,email,password, cash_accounts) VALUES (?, ?, ?, ?, ?)";

    public static final String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE Id LIKE ?";

    public static final String GET_ROLE_ID_BY_NAME = "SELECT roles.id AS id FROM roles WHERE roles.name = ?";

}
