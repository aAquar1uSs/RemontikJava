package com.project.daobd;

import com.project.model.Role;

public interface RoleDao extends AbstarctDao<Integer, Role> {
    int getRoleIdByName(String roleName);
}
