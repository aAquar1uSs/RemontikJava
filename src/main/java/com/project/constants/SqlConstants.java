package com.project.constants;

public class SqlConstants {
    public static final String URL_CONNECT_TO_DB = "jdbc:mysql://localhost:3306/repair_shopdb?user=root&password=SanyaFrank111";

    public static final String SQL_INSERT_NEW_USER = "INSERT INTO users (firstname,lastname,email,password, cash_accounts) VALUES (?, ?, ?, ?, ?)";

    public static final String SQL_FIND_USER_BY_ID = "SELECT firstname, lastname, email, password, cash_accounts, roles.name FROM users JOIN roles ON id_users = users.id WHERE users.id = ?;";

    public static final String GET_ROLE_ID_BY_NAME = "SELECT roles.id AS id FROM roles WHERE roles.name = ?";

    public static final String SEARCH_USER_BY_LOGIN_AND_PASSWORD_AND_ROLE = "SELECT firstname, lastname, password, roles.name FROM users JOIN roles ON id_users = users.id WHERE firstname = ? AND lastname = ? AND password = ? AND roles.name = ?";

    public static final String GET_ID_USERS = "SELECT id FROM users WHERE email = ? AND password =?";

    public static final String GET_USER_ROLE = "SELECT roles.name FROM roles JOIN users ON users.id = id_users where users.id = ?";
}
