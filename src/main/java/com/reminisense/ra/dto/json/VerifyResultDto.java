package com.reminisense.ra.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nigs on 2016-05-17.
 */
public class VerifyResultDto extends RestResultDto {

    private String name;
    private String description;
    private String imageUrls;
    private boolean takeOutAllowed;
    private String takeOutInfo;
    @JsonProperty("owner")
    private UserDto userDto;

    public VerifyResultDto() {
        super();
    }

    public VerifyResultDto(String result, String message) {
        super(result, message);
    }

    public VerifyResultDto(String name, String description, String imageUrls, boolean takeOutAllowed, String takeOutInfo) {
        this.name = name;
        this.description = description;
        this.imageUrls = imageUrls;
        this.takeOutAllowed = takeOutAllowed;
        this.takeOutInfo = takeOutInfo;
    }

    public VerifyResultDto(String result, String name, String description, String imageUrls, boolean takeOutAllowed, String takeOutInfo) {
        super(result);
        this.name = name;
        this.description = description;
        this.imageUrls = imageUrls;
        this.takeOutAllowed = takeOutAllowed;
        this.takeOutInfo = takeOutInfo;
    }

    public VerifyResultDto(String result, String message, String name, String description, String imageUrls, boolean takeOutAllowed, String takeOutInfo) {
        super(result, message);
        this.name = name;
        this.description = description;
        this.imageUrls = imageUrls;
        this.takeOutAllowed = takeOutAllowed;
        this.takeOutInfo = takeOutInfo;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public boolean isTakeOutAllowed() {
        return takeOutAllowed;
    }

    public void setTakeOutAllowed(boolean takeOutAllowed) {
        this.takeOutAllowed = takeOutAllowed;
    }

    public String getTakeOutInfo() {
        return takeOutInfo;
    }

    public void setTakeOutInfo(String takeOutInfo) {
        this.takeOutInfo = takeOutInfo;
    }
}
