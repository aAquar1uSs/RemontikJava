package com.project.daobd;

import com.project.model.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao extends AbstarctDao<Integer, Role> {
    int getRoleIdByName(String roleName) throws SQLException;

    Role setUserRole(int id,String userRole);

    String getUserRoleById(int id);

    void deleteUserRoleById(int userId);

    List<Integer> findUsersIdByRole(String role);

}
