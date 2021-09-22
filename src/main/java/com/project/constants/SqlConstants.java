package com.project.constants;

public class SqlConstants {

    public static final String SQL_INSERT_NEW_USER = "INSERT INTO users (firstname,lastname,email,password," +
            "cash_accounts) VALUES (?, ?, ?, ?, ?)";

    public static final String SQL_FIND_USER_BY_ID = "SELECT firstname, lastname, email, password, cash_accounts, "
            + "roles.name FROM users JOIN roles ON id_users = users.id WHERE users.id = ?;";

    public static final String GET_ROLE_ID_BY_NAME = "SELECT roles.id AS id FROM roles WHERE roles.name = ?";

    public static final String SEARCH_USER_BY_LOGIN_AND_EMAIL = "SELECT firstname, lastname, password, " +
            "roles.name FROM users JOIN roles ON id_users = users.id WHERE firstname = ? AND lastname = ? " +
            "AND password = ? AND roles.name = ?";

    public static final String SEARCH_USER_BY_EMAIL = "SELECT email FROM users WHERE email= ?";

    public static final String GET_ID_USERS = "SELECT id FROM users WHERE email = ? AND password =?";

    public static final String GET_USER_ROLE = "SELECT roles.name FROM roles JOIN users ON users.id = id_users " +
            "WHERE users.id = ?";

    public static final String SET_NEW_ROLE_FOR_USER = "INSERT INTO roles (name,id_users) VALUES (?, ?)";

    public static final String INSERT_NEW_ORDER = "INSERT INTO orders(order_name, order_price, order_date, " +
            "order_status, paymant_status, id_user) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String SQL_FIND_ALL_ORDERS = "SELECT * FROM orders";

    public static final String SQL_FIND_USER_ORDERS = "SELECT order_name, order_price, order_date, order_status, " +
            "paymant_status, id_user FROM orders JOIN users WHERE users.id = ?";

    public static final String FIND_USERS_ID_BY_ROLES = "SELECT * FROM roles WHERE name = ?";

    public static final String DELETE_USER_ROLE_BY_ID = "DELETE FROM roles WHERE id_users =";

    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id =";

    public static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    public static final String SQL_PASSWORD_VERIFICATION = "SELECT * FROM users WHERE email = ? AND password = ?";

}
