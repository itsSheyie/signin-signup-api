package com.sheyie.signin_signup_api.exception.dto;

import java.time.Instant;
import java.util.Map;

public record ErrorResponse (
        int status,
        String errorCode,
        String message,
        Map<String, String> fieldErrors,
        Instant timestamp

){
    public static ErrorResponse mapToResponse(
            int status,
            String errorCode,
            String message,
            Map<String, String> fieldErrors
    ){
        return new ErrorResponse(status,errorCode,message, fieldErrors, Instant.now());
    }

    public static ErrorResponse mapToResponse(
            int status,
            String errorCode,
            String message
    ){
        return ErrorResponse.mapToResponse(status,errorCode,message, null);
    }

}