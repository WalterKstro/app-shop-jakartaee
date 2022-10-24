package com.walterkstro.CustomExceptions;

public class ExceptionService extends RuntimeException{
    public ExceptionService(String message) {
        super(message);
    }

    public ExceptionService(String message, Throwable cause) {
        super(message, cause);
    }
}
