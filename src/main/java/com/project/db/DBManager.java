package com.project.db;

import com.project.db.constants.SqlConstants;
import com.project.db.entity.User;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    private static final Logger LOGGER = Logger.getLogger(DBManager.class.getName());
    private static DBManager dbManager;

    private DBManager() {

    }

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String url) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url);
    }


    public void insertUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = getConnection(SqlConstants.URL_CONNECT_TO_DB);
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_INSERT_NEW_USER,
                    Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getEmal());
            preparedStatement.setString(4, user.getPassword());

            if (preparedStatement.executeUpdate() > 0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    user.setId((int) rs.getLong(1));
                }
            }
            connection.commit();

        } catch (SQLException | ClassNotFoundException throwables) {
            connection.rollback();
            LOGGER.log(Level.SEVERE, throwables.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,
                        e.getMessage());
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE,
                        e.getMessage());
            }
        }
    }

}
