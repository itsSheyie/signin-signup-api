package com.sheyie.signin_signup_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class BaseAppException extends RuntimeException{
    private final HttpStatus status;
    private final String errorCode;

    protected BaseAppException(String message, HttpStatus status, String errorCode){
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
}
