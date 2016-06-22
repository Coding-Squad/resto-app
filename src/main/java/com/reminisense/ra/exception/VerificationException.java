package com.reminisense.ra.exception;

/**
 * Created by Nigs on 2016-05-17.
 */
public class VerificationException extends Exception {
    public VerificationException() {
        super();
    }

    public VerificationException(String message) {
        super(message);
    }

    public VerificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationException(Throwable cause) {
        super(cause);
    }
}
