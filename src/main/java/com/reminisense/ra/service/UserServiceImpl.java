package com.reminisense.ra.service;

import com.reminisense.ra.dao.CompanyDao;
import com.reminisense.ra.dao.UserDao;
import com.reminisense.ra.dto.factory.UserFactory;
import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.CompanyEntity;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.RegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nigs on 2016-05-16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CompanyDao companyDao;

    @Override
    public UserDto addUser(UserDto p) throws RegistrationException {
        // check company
        CompanyEntity company = companyDao.getCompanyById(p.getCompanyId());
        if (company == null) {
            throw new RegistrationException("Company does not exist.");
        }
        // check email
        UserEntity user = userDao.findByEmail(p.getEmail());
        if (user != null) {
            throw new RegistrationException("Email is already registerd.");
        }
        return UserFactory.createUserDto(userDao.addUser(UserFactory.createUserEntity(p)));
    }

    @Override
    public UserDto updateUser(UserDto p) {
        return UserFactory.createUserDto(userDao.updateUser(UserFactory.createUserEntity(p)));
    }

    @Override
    public List<UserDto> listUsers() {
        List<UserDto> users = new ArrayList<UserDto>();
        List<UserEntity> userEntities = userDao.listUsers();
        for (UserEntity userEntity : userEntities) {
            users.add(UserFactory.createUserDto(userEntity));
        }
        return users;
    }

    @Override
    public List<UserDto> listUsersByCompany(int companyId) {
        List<UserDto> users = new ArrayList<UserDto>();
        List<UserEntity> userEntities = userDao.listUsersByCompanyId(companyId);
        for (UserEntity userEntity : userEntities) {
            users.add(UserFactory.createUserDto(userEntity));
        }
        return users;
    }

    @Override
    public UserEntity getUserById(int id) {
        return null;
    }

    @Override
    public void removeUser(int id) {
        //TODO
    }
}
