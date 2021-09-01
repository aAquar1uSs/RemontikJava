package com.project.daobd;

import com.project.constants.SqlConstants;
import com.project.model.Role;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private static Logger LOGGER = Logger.getLogger(RoleDaoImpl.class.getName());
    private Connection connection;

    public RoleDaoImpl(Connection connection) {
        this.connection = connection;
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
        int result = 0;
        try(PreparedStatement statement = connection.prepareStatement(
                SqlConstants.GET_ROLE_ID_BY_NAME)){
            statement.setString(1, roleName);
            resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("id");
        }catch (SQLException e){
           LOGGER.error(e.getMessage());
        }finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return result;
    }
}
