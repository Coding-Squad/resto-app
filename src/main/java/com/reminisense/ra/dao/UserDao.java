package com.reminisense.ra.dao;

import com.reminisense.ra.entity.UserEntity;

import java.util.List;

/**
 * Created by Nigs on 2016-05-16.
 */
public interface UserDao {
    UserEntity addUser(UserEntity p);

    UserEntity updateUser(UserEntity p);

    List<UserEntity> listUsers();

    List<UserEntity> listUsersByCompanyId(int companyId);

    UserEntity getUserById(int id);

    void removeUser(int id);

    UserEntity findByEmail(String email);
}
