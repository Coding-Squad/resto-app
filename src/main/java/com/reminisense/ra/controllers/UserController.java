package com.reminisense.ra.controllers;

import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.UserNotFoundException;
import com.reminisense.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "user";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUser", this.userService.listUsers());
        return "userInfo";
    }





    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserEntity c) {

        if (c.getUserId() == 0) {
            this.userService.addUser(c);
        } else {
            this.userService.updateUser(c);
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
        return "user";
    }


    @RequestMapping("/user/remove/{userId}")
    public String removeUser(@PathVariable("userId") int userId) {

        this.userService.removeUser(userId);
        return "redirect:/user";
    }
}
