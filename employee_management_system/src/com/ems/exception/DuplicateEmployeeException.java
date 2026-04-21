package com.ems.exception;

public class DuplicateEmployeeException extends RuntimeException {
    public DuplicateEmployeeException(String msg) {
        super(msg);
    }
}