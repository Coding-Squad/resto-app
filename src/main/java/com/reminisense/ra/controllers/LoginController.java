package com.reminisense.ra.controllers;

import com.reminisense.ra.entity.CustomerEntity;
import com.reminisense.ra.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Yumi on 7/5/2016.
 */

@Controller

public class LoginController {


    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "loginForm", method = RequestMethod.GET)
    public String showForm(Map model) {
        CustomerEntity loginForm = new CustomerEntity();
        model.put("home", loginForm);
        return "home";
    }


    @RequestMapping(value = "loginForm", method = RequestMethod.POST)
    public String processForm(@Valid CustomerEntity loginForm, BindingResult result,
                              Map model) {


        if (result.hasErrors()) {
            return "home";
        }

		/*
		String userName = "UserName";
		String password = "password";
		loginForm = (LoginForm) model.get("loginForm");
		if (!loginForm.getUserName().equals(userName)
				|| !loginForm.getPassword().equals(password)) {
			return "loginform";
		}
		*/
        boolean userExists = loginService.checkLogin(loginForm.getUsername(),loginForm.getPassword());
        if(userExists){
            model.put("home", loginForm);
            return "redirect:/customer/list";
        }else{
            result.rejectValue("username","invaliduser  ");
            return "ErrorMsg";
        }

    }

}
