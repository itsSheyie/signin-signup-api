package com.sheyie.signin_signup_api.user.service;

import com.sheyie.signin_signup_api.exception.UserExistsException;
import com.sheyie.signin_signup_api.user.dto.SignUpRequest;
import com.sheyie.signin_signup_api.user.dto.SignUpResponse;
import com.sheyie.signin_signup_api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request){
        boolean userExists = userRepository.existsByEmailIgnoreCase(request.email());

        if(userExists) throw new UserExistsException("User already registered");
    }
}
