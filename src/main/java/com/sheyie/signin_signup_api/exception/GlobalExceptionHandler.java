package com.sheyie.signin_signup_api.exception;

import com.sheyie.signin_signup_api.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseAppException.class)
    public ResponseEntity<ErrorResponse> handleBaseAppException(BaseAppException ex){
        return ResponseEntity.status(ex.getStatus()).body(ErrorResponse.mapToResponse(
                ex.getStatus().value(), ex.getErrorCode(), ex.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(ErrorResponse.mapToResponse(HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_FAILED", "Invalid input provided", errors));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleNotReadableException(HttpMessageNotReadableException ex){
        return ResponseEntity.badRequest().body(ErrorResponse.mapToResponse(HttpStatus.BAD_REQUEST.value(),
                "NOT_READABLE", "Request body is missing or invalid"));
    }

}
