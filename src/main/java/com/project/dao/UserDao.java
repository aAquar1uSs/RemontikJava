package com.project.dao;

import com.project.model.User;

public interface UserDao<K> extends AbstarctDao<K,User>{
    User findByUserName(String user_firstName);
    void insertUser(User user);
}
