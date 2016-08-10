package com.reminisense.ra.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by caspe on 7/11/2016.
 */
// @Repository  magic word for "No qualifying bean of type found for dependency" error
public class UserDto {
    private int userId;

    @NotNull
    private String firstName;
    @NotNull

    private String lastName;
    private String address;
    private String phone;
    private String username;
    @NotNull
    private String email;
    @NotNull

    @Size(min = 6, max = 15)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;
    @NotNull
    private String authorities;

    public UserDto() {
    }

    public UserDto(int userId, String firstName, String lastName, String address, String phone, String email, String username, String password, String confirmPassword, String authorities) {
        this.userId=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.phone=phone;
        this.email=email;
        this.username=username;
        this.password=password;
        this.confirmPassword=confirmPassword;
        this.authorities=authorities;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
