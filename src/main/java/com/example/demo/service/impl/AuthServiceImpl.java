package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    // ✅ Register user
    public AuthResponse register(AuthRequest request) {
        // demo implementation (no DB user table yet)
        return new AuthResponse(
                "REGISTER_SUCCESS",
                "dummy-jwt-token"
        );
    }

    // ✅ Login user
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse(
                "LOGIN_SUCCESS",
                "dummy-jwt-token"
        );
    }
}
