package com.project.DAO;

import com.project.model.User;

import java.util.List;

public interface UserDao<K> extends AbstarctDao<K, User> {
    User findByUserName(String user_firstName);

    void insertUser(User user);

    boolean searchUserByEmail(String email);

    boolean verificationPassword(String email, String password);

    int getUserId(String email, String password);

    int getUserIdByEmail(String email);

    List<User> findAllUserWithManagerRole();
}
