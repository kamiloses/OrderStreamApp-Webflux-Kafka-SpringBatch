package com.group.kamiloses.orderstreamapp.controller.exception;

public class InvalidFieldException extends RuntimeException{
    public InvalidFieldException(String message) {
        super(message);
    }
}