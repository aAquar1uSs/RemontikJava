package com.project.service;

import com.project.daobd.UserDao;
import com.project.daoImpl.UserDaoImpl;
import com.project.model.User;

public class UserService {
    private final UserDao<Integer> userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public int getIdUser(String email, String password) {
        return  userDao.getUserId(email,password);
    }

    public User getUserById(int id){
        return userDao.getById(id);
    }

    public boolean searchUserByEmail(String email) {
        return userDao.searchUserByEmail(email);
    }

    public User setNewUser(String firstName,String lastName,
                           String email, String password, double cashBalance) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setCash_account(cashBalance);

        return user;
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

}
