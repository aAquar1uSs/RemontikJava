package com.project.service;

import com.project.daobd.UserDao;
import com.project.daobd.UserDaoImpl;
import com.project.model.User;

public class UserService {
    private UserDao<Integer> userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public int getIdUser(String email, String password) {
        return  userDao.getUserId(email,password);
    }

    public String getUserRoleById(int id) {
        return  userDao.getUserRoleById(id);
    }

    public User getUserById(int id){
        return userDao.getById(id);
    }


}
