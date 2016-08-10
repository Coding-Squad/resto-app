package com.reminisense.ra.service;

import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.RegistrationException;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
public interface UserService {
    UserDto addUser(UserDto p) throws RegistrationException;

    UserDto updateUser(UserDto p) throws RegistrationException;

    List<UserEntity> listUsers();

    UserEntity getUserById(int id);

    void removeUser(int id);

}
