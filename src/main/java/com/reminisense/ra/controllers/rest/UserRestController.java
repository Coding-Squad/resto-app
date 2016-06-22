package com.reminisense.ra.controllers.rest;

import com.reminisense.ra.dto.json.RestResultDto;
import com.reminisense.ra.dto.json.UserDto;
import com.reminisense.ra.exception.UserNotFoundException;
import com.reminisense.ra.service.AssetService;
import com.reminisense.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nigs on 2016-05-22.
 */
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<UserDto> listUsers() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/user/list/{companyId}", method = RequestMethod.GET)
    public List<UserDto> listUsers(@PathVariable("companyId") int companyId) {
        return userService.listUsersByCompany(companyId);
    }

    @RequestMapping(value = "/user/{userId}/assets/list", method = RequestMethod.GET)
    public ResponseEntity<?> listUserAssets(@PathVariable("userId") int userId) {
        try {
            return new ResponseEntity<>(assetService.listAssetsByUser(userId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new RestResultDto(RestResultDto.RESULT_ERROR, "User not found."), HttpStatus.NOT_FOUND);
        }
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
        // TODO
        userService.updateUser(userDto);
        return null;
    }

}
