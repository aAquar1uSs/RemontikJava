package com.project.dao;

import com.project.model.Role;
import com.project.model.User;

public interface RoleDao extends AbstarctDao<Integer, Role>{
    int getRoleIdByName(String roleName);
}
