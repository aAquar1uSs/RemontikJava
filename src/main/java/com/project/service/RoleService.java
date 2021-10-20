package com.project.service;

import com.project.DAO.RoleDao;
import com.project.DAO.daoImpl.RoleDaoImpl;

import java.util.List;

public class RoleService {
    RoleDao roleDao;

    public RoleService() {
        roleDao = new RoleDaoImpl();
    }

    public void setRoleForUser(int userId,String userRole) {
        roleDao.setUserRole(userId,userRole);
    }

    public void deleteRoleByUserId(int id){
        roleDao.delete(id);
    }

    public String getUserRoleById(int id) {
        return  roleDao.getUserRoleById(id);
    }

    public List<Integer> findUsersIdByRole(String role) {
        return roleDao.findUsersIdByRole(role);
    }
}
