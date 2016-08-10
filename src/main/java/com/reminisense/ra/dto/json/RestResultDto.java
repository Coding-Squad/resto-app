package com.reminisense.ra.dto.json;

/**
 * Created by caspe on 7/12/2016.
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
