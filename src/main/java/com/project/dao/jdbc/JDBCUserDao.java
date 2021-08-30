package com.project.dao.jdbc;

import com.project.constants.SqlConstants;
import com.project.entity.User;

import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;


class JDBCUserDao implements Dao<User> {

    public static Logger LOGGER = Logger.getLogger("JDBCUserDao");

    @Override
    public void insert(Connection connection, User user) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_INSERT_NEW_USER,
                    Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            if (preparedStatement.executeUpdate() > 0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    user.setId((int) rs.getLong(1));
                }
            }
            connection.commit();

        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                LOGGER.debug(e.getMessage());
            }
            LOGGER.debug(throwables.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                LOGGER.debug(e.getMessage());
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                LOGGER.debug(e.getMessage());
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                LOGGER.debug(e.getMessage());
            }
        }
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void update(User adr) {

    }

    @Override
    public void delete(User adr) {

    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
