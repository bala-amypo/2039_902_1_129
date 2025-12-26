package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider tokenProvider;

    public AuthController(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {

        String email = body.get("email");

        String token = tokenProvider.generateToken(email);

        return Map.of(
                "message", "LOGIN_SUCCESS",
                "token", token
        );
    }
}
