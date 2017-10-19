package com.example.restdemo.exception;

public class ProfileNotFoundException extends ProfileException {

    public ProfileNotFoundException(String message) {
        super (message);
    }
}
