package com.reminisense.ra.exception;

/**
 * Created by Yumi on 7/7/2016.
 */
public class DishNotFoundException extends Exception {
    public DishNotFoundException() {
    }

    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishNotFoundException(Throwable cause) {
        super(cause);
    }

    public DishNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
