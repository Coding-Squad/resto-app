package com.reminisense.ra.exception;

/**
 * Created by Nigs on 2016-05-16.
 */
public class RegistrationException extends Exception {
    public RegistrationException() {
        super();
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(Throwable cause) {
        super(cause);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
