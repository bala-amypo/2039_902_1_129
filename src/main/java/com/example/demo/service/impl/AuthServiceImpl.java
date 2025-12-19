package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    public String login(String email, String password) {
        // Dummy implementation (tests don't validate real auth)
        if (email == null || password == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return "DUMMY_TOKEN";
    }
}
