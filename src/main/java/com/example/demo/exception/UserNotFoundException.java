package com.example.demo.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String massage) {
        super(massage);
    }
}
