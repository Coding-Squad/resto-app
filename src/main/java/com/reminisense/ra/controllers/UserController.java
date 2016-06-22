package com.reminisense.ra.controllers;

import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.exception.RegistrationException;
import com.reminisense.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nigs on 2016-05-22.
 */
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listUser", this.userService.listUsers());
        return "user";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserDto u) throws RegistrationException {

        if (u.getUserId() == 0) {
            this.userService.addUser(u);
        } else {
            this.userService.updateUser(u);
        }

        return "redirect:/company";

    }

    @RequestMapping("/user/remove/{userId}")
    public String removeUser(@PathVariable("userId") int userId) {

        this.userService.removeUser(userId);
        return "redirect:/user";
    }

    @RequestMapping("/user/edit/{userId}")
    public String editCompany(@PathVariable("userId") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUser", this.userService.listUsers());
        return "user";
    }

}
