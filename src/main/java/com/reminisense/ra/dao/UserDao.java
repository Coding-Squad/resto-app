package com.reminisense.ra.dao;

import com.reminisense.ra.entity.UserEntity;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
public interface UserDao {
    UserEntity addUser(UserEntity c);

    UserEntity updateUser(UserEntity c);

    List<UserEntity> listUsers();

    UserEntity getUserById(int id);

    void removeUser(int id);
}
