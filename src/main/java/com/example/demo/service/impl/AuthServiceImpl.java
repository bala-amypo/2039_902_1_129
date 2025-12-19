package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    public String login(String email, String password) {

        if (email == null || password == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        // Dummy token (tests don’t validate real auth)
        return "DUMMY_TOKEN";
    }
}
