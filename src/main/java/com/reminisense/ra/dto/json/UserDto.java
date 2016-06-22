package com.reminisense.ra.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Nigs on 2016-05-16.
 */
public class UserDto {
    private int userId;
    private int companyId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String position;
    private String description;
    private String imageUrl;
    @NotNull
    private String email;
    @NotNull
    @Size(min = 6, max = 15)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;
    @NotNull
    private String authorities;

    public UserDto() {
    }

    /**
     * @param userId
     * @param companyId
     * @param firstName
     * @param lastName
     * @param position
     * @param description
     * @param imageUrl
     * @param email
     * @param password
     * @param confirmPassword
     * @param authorities
     */
    public UserDto(int userId, int companyId, String firstName, String lastName, String position, String description, String imageUrl, String email, String password, String confirmPassword, String authorities) {
        this.userId = userId;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.description = description;
        this.imageUrl = imageUrl;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.authorities = authorities;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
