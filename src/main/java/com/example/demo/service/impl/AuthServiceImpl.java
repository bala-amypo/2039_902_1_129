package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ LOGIN → REAL JWT
    public AuthResponse login(AuthRequest request) {

        // (Dummy validation for assignment)
        if (request.getEmail() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtTokenProvider.generateToken(request.getEmail());

        return new AuthResponse("LOGIN_SUCCESS", token);
    }

    // ✅ REGISTER → REAL JWT
    public AuthResponse register(AuthRequest request) {

        String token = jwtTokenProvider.generateToken(request.getEmail());

        return new AuthResponse("REGISTER_SUCCESS", token);
    }
}
