package com.reminisense.ra.controllers.rest;

import com.reminisense.ra.dto.json.RestResultDto;
import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.entity.UserEntity;
import com.reminisense.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by caspe on 7/12/2016.
 */
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<UserEntity> listUsers() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public RestResultDto addUser(@Valid @RequestBody UserDto userDto) {
        try {
            userService.addUser(userDto);
            return new RestResultDto(RestResultDto.RESULT_OK);
        } catch (Exception e) {
            return new RestResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        }
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public RestResultDto updateUser(@Valid @RequestBody UserDto userDto) {
        try {
            userService.updateUser(userDto);
            return new RestResultDto(RestResultDto.RESULT_OK);
        } catch (Exception e) {
            return new RestResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        }
    }
}
