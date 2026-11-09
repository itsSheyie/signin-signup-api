package com.sheyie.signin_signup_api.user.dto;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest (
        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email")
        @Size(min = 150, message = "Email is too long")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 72, message = "Password must be between 8 and 72 characters")
        String password
){
}
