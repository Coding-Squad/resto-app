package com.reminisense.ra.service;

import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.RegistrationException;

import java.util.List;

/**
 * Created by Nigs on 2016-05-16.
 */
public interface UserService {
    UserDto addUser(UserDto p) throws RegistrationException;

    UserDto updateUser(UserDto p);

    List<UserDto> listUsers();

    List<UserDto> listUsersByCompany(int companyId);

    UserEntity getUserById(int id);

    void removeUser(int id);
}
