package com.project.dao;

import com.project.constants.SqlConstants;
import com.project.utils.WrapperConnector;
import com.project.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao<Integer>{

    private WrapperConnector connectionPool = WrapperConnector.getInstance();

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean create(User entity) {

        return false;
    }

    @Override
    public User getById(Integer integer) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_FIND_USER_BY_ID);
            preparedStatement.setLong(1,integer);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = createUser(rs);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUserName(String user_firstName) {
        return null;
    }

    @Override
    public void insertUser(User user) {

    }

    private User createUser(ResultSet rs) throws SQLException {
        User user;
        user = new User();
        user.setFirstName(rs.getString("fistname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCash_account(rs.getDouble("cash_account"));
        return user;

    }
}
