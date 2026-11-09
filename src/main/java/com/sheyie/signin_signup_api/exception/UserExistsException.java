package com.sheyie.signin_signup_api.exception;

import org.springframework.http.HttpStatus;

public class UserExistsException extends BaseAppException {

    public UserExistsException(String message){
        super(message, HttpStatus.CONFLICT, "USER_ALREADY_EXISTS");
    }

}
