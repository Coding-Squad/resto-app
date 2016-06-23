package com.reminisense.ra.exception;

/**
 * Created by Yumi on 6/23/2016.
 */
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }

    public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
