package com.project.daoImpl;

import com.project.constants.SqlConstants;
import com.project.daobd.UserDao;
import com.project.model.Role;
import com.project.model.User;
import com.project.utils.WrapperConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao<Integer> {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());
    private final WrapperConnector wrapperConnection;

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
            logger.error(throwables.getMessage());
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
            logger.error(throwables.getMessage());
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
            statement = connection.prepareStatement(SqlConstants.SQL_SEARCH_USER_BY_EMAIL);

            statement.setString(1,email);

            rs = statement.executeQuery();

            while (rs.next()) {
              return true;
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(statement);
            wrapperConnection.close(connection);
        }

        return false;
    }

    @Override
    public boolean verificationPassword(String email,String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = wrapperConnection.getConnection();
            statement = connection.prepareStatement(SqlConstants.SQL_PASSWORD_VERIFICATION);
            statement.setString(1,email);
            statement.setString(2,password);
            rs = statement.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables.getMessage());
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
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_GET_ID_USERS);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            WrapperConnector.rollback(connection);
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
        return id;
    }

    @Override
    public int getUserIdByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int id = 0;
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SqlConstants.SQL_FIND_USER_BY_EMAIL);

            statement.setString(1,email);

            rs = statement.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            WrapperConnector.rollback(connection);
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(statement);
            wrapperConnection.close(connection);
        }
        return id;
    }

    @Override
    public void deleteUserById(int id) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute(SqlConstants.SQL_DELETE_USER_BY_ID + id);
            connection.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            WrapperConnector.rollback(connection);
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(statement);
            wrapperConnection.close(connection);
        }
    }

    @Override
    public List<User> findAllUserWithManagerRole() {
        return null;
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
