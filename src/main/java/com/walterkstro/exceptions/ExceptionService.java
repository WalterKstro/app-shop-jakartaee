package com.walterkstro.exceptions;

public class ExceptionService extends RuntimeException{
    public ExceptionService(String message) {
        super(message);
    }

    public ExceptionService(String message, Throwable cause) {
        super(message, cause);
    }
}
