package com.project.DAO;

import com.project.model.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao extends AbstarctDao<Integer, Role> {
    int getRoleIdByName(String roleName) throws SQLException;

    Role setUserRole(int id,String userRole);

    String getUserRoleById(int id);

    List<Integer> findUsersIdByRole(String role);

}
