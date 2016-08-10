package com.reminisense.ra.controllers;

import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.exception.UserNotFoundException;
import com.reminisense.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by Yumi on 7/7/2016.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUser", this.userService.listUsers());
        return "user.jsp";
    }


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserDto u) throws RegistrationException {

        if (u.getUserId() == 0) {
            this.userService.addUser(u);
        } else {
            this.userService.updateUser(u);
        }

        return "redirect:/user";

    }

    @RequestMapping("/user/edit/{userId}")
    public String editUser(@PathVariable("userId") int userId, Model model) throws UserNotFoundException {

        UserEntity user = this.userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        model.addAttribute("user", user);
        model.addAttribute("listUser", this.userService.listUsers());
        return "user.jsp";
    }


    @RequestMapping("/user/remove/{userId}")
    public String removeUser(@PathVariable("userId") int userId) {

        this.userService.removeUser(userId);
        return "redirect:/user";
    }


}
