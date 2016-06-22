package com.reminisense.ra.dto.json;

/**
 * DTO for REST method results.
 * Created by Nigs on 2016-04-15.
 */
public class RestResultDto {
    public static final String RESULT_OK = "OK";
    public static final String RESULT_ERROR = "ERROR";

    private String result;
    private String message;

    public RestResultDto() {
    }

    public RestResultDto(String result) {
        this(result, "");
    }

    public RestResultDto(String result, String message) {
        this.result = result;
        this.message = message;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
