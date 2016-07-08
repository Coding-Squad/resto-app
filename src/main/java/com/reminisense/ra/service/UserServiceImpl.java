package com.reminisense.ra.service;

import com.reminisense.ra.dao.UserDao;
import com.reminisense.ra.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yumi on 7/7/2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(UserEntity p) {userDao.addUser(p);
    }

    @Override
    public void updateUser(UserEntity p) {
        userDao.updateUser(p);
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
