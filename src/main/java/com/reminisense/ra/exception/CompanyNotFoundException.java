package com.reminisense.ra.exception;

/**
 * Created by Yumi on 7/12/2016.
 */
public class CompanyNotFoundException extends Exception
{
    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }

    public CompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyNotFoundException(Throwable cause) {
        super(cause);
    }

    public CompanyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
