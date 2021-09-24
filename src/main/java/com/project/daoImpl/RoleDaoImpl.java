package com.project.daoImpl;

import com.project.constants.SqlConstants;
import com.project.daobd.RoleDao;
import com.project.model.Role;
import com.project.utils.WrapperConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private static Logger logger = LogManager.getLogger(RoleDaoImpl.class.getName());
    private WrapperConnector wrapperConnection;

    public RoleDaoImpl() {
        wrapperConnection = WrapperConnector.getInstance();
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public boolean update(Role entity) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean create(Role entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Role getById(Integer integer) {
        return null;
    }

    @Override
    public int getRoleIdByName(String roleName) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SqlConstants.SQL_GET_ROLE_ID_BY_NAME);
            statement.setString(1, roleName);
            resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("id");
            connection.commit();
        }catch (SQLException | ClassNotFoundException e){
            WrapperConnector.rollback(connection);
           logger.error(e.getMessage());
        }finally {
            wrapperConnection.close(resultSet);
            wrapperConnection.close(statement);
            wrapperConnection.close(connection);
        }
        return result;
    }

    @Override
    public Role setUserRole(int id, String userRole) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Role role = new Role();
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_SET_NEW_ROLE_FOR_USER,
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,userRole);
            preparedStatement.setInt(2,id);

            if (preparedStatement.executeUpdate() > 0) {
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    role.setId(rs.getLong(1));
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

        return role;
    }

    @Override
    public String getUserRoleById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String role = null;
        try {
            connection = wrapperConnection.getConnection();
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_GET_USER_ROLE);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                role = rs.getString("name");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
        return role;
    }

    @Override
    public void deleteUserRoleById(int userId) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute(SqlConstants.SQL_DELETE_USER_ROLE_BY_ID + userId);
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
    public List<Integer> findUsersIdByRole(String role) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Integer> idUsersArray = new ArrayList<>();
        try {
            connection = wrapperConnection.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SqlConstants.SQL_FIND_USERS_ID_BY_ROLES);
            preparedStatement.setString(1, role);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                idUsersArray.add(rs.getInt("id_users"));
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.error(throwables.getMessage());
        } finally {
            wrapperConnection.close(rs);
            wrapperConnection.close(preparedStatement);
            wrapperConnection.close(connection);
        }
        return idUsersArray;
    }

}
