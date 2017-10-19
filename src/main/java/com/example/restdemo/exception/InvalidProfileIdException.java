package com.example.restdemo.exception;

public class InvalidProfileIdException extends ProfileException {

    public InvalidProfileIdException(String message) {
        super (message);
    }
}
