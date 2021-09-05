package com.project.daobd;

import com.project.constants.SqlConstants;
import com.project.model.Role;
import com.project.model.User;
import com.project.utils.WrapperConnector;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao<Integer> {

    private WrapperConnector wrapperConnection;

    public UserDaoImpl() {
        wrapperConnection = WrapperConnector.getInstance();
    }

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
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = wrapperConnection.getConnection();
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_FIND_USER_BY_ID);
            preparedStatement.setLong(1, integer);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = createUser(rs);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
        return user;
    }

    @Override
    public User findByUserName(String user_firstName) {
        return null;
    }

    @Override
    public void insertUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_INSERT_NEW_USER,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDouble(5, user.getCash_account());

            if (preparedStatement.executeUpdate() > 0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getLong(1));
                }
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            WrapperConnector.rollback(connection);
            throwables.getMessage();
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
    }

    @Override
    public boolean searchUserByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = wrapperConnection.getConnection();
            statement = connection.prepareStatement(SqlConstants.SEARCH_USER_BY_EMAIL);

            statement.setString(1,email);

            rs = statement.executeQuery();

            while (rs.next()) {
              return true;
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.getMessage();
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(statement);
            wrapperConnection.close(connection);
        }

        return false;
    }

    @Override
    public int getUserId(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int id = 0;
        try {
            connection = wrapperConnection.getConnection();
            preparedStatement = connection.prepareStatement(SqlConstants.GET_ID_USERS);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.getMessage();
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
        return id;
    }

    private User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        Role role = new Role();
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCash_account(rs.getDouble("cash_accounts"));
        role.setName(rs.getString("name"));
        user.setRole(role);
        return user;

    }
}
