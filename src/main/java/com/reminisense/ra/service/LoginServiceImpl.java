package com.reminisense.ra.service;

import com.reminisense.ra.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yumi on 7/5/2016.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public boolean checkLogin(String username, String password){
        System.out.println("In Service class...Check Login");
        return loginDao.checkLogin(username, password);
    }
}
