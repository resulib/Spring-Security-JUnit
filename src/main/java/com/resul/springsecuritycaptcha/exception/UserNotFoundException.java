package com.resul.springsecuritycaptcha.exception;

public class UserNotFoundException extends NotFoundException{
    public UserNotFoundException(String s) {
        super(s);
    }
}
