package com.project.service;

import com.project.daobd.RoleDao;
import com.project.daoImpl.RoleDaoImpl;

public class RoleService {
    RoleDao roleDao;

    public RoleService() {
        roleDao = new RoleDaoImpl();
    }

    public void setRoleForUser(int user_id) {
        roleDao.setUserRole(user_id);
    }

    public String getUserRoleById(int id) {
        return  roleDao.getUserRoleById(id);
    }
}
