package com.reminisense.ra.service;

import com.reminisense.ra.dao.UserDao;
import com.reminisense.ra.dto.factory.UserFactory;
import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
@Service

public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDto addUser(UserDto p) throws RegistrationException {

        // check email
        UserEntity user = userDao.findByEmail(p.getEmail());
        if (user != null) {
            throw new RegistrationException("Email is already registerd.");
        }
        return UserFactory.createUserDto(
                userDao.addUser(UserFactory.createUserEntity(p)));
    }

    @Override
    public UserDto updateUser(UserDto p) throws RegistrationException {

        // check email
        UserEntity user = userDao.findByEmail(p.getEmail());
        if (user == null) {
            throw new RegistrationException("User not found.");
        }
        return UserFactory.createUserDto(
                userDao.updateUser(UserFactory.createUserEntity(p)));
    }


    @Override
    public List<UserEntity> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public UserEntity getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void removeUser(int id) {userDao.removeUser(id);}

}
