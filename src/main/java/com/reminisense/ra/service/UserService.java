package com.reminisense.ra.service;

import com.reminisense.ra.entity.UserEntity;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
public interface UserService {
    void addUser(UserEntity p);

    void updateUser(UserEntity p);

    List<UserEntity> listUsers();

    UserEntity getUserById(int id);

    void removeUser(int id);
}
