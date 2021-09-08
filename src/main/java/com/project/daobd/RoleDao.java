package com.project.daobd;

import com.project.model.Role;

import java.sql.SQLException;

public interface RoleDao extends AbstarctDao<Integer, Role> {
    int getRoleIdByName(String roleName) throws SQLException;

    Role setUserRole(int id);

    String getUserRoleById(int id);

}
