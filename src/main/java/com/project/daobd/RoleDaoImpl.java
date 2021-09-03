package com.project.daobd;

import com.project.constants.SqlConstants;
import com.project.model.Role;
import com.project.utils.WrapperConnector;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private static Logger LOGGER = Logger.getLogger(RoleDaoImpl.class.getName());
    private WrapperConnector wrapperConnection;

    public RoleDaoImpl(Connection connection) {
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
        return false;
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
            statement = connection.prepareStatement(SqlConstants.GET_ROLE_ID_BY_NAME);
            statement.setString(1, roleName);
            resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("id");
        }catch (SQLException e){
           LOGGER.error(e.getMessage());
        }finally {
            wrapperConnection.close(resultSet);
            wrapperConnection.close(statement);
            wrapperConnection.close(connection);
        }
        return result;
    }

}
